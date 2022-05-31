package de.erdlet.libertydemo.common.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
@NamedQueries({
        @NamedQuery(name = Post.FIND_ALL, query = "SELECT p FROM Post p"),
        @NamedQuery(name = Post.FIND_BY_ID, query = "SELECT p FROM Post p JOIN FETCH p.comments WHERE p.id = :id")
})
public class Post {
    public static final String FIND_ALL = "Post.findAll";
    public static final String FIND_BY_ID = "Post.findById";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<Comment> comments;

    public Post() {
        this.comments = new ArrayList<>();
    }

    public Post(Long id, String title, String text, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return List.copyOf(comments);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Comment addComment(final String text, final String author) {
        final Comment comment = new Comment(text, author, this);
        this.comments.add(comment);

        return comment;
    }

    public Comment updateComment(final Comment comment) {
        comments.set(comments.indexOf(comment), comment);
        comment.setPost(this);

        return comment;
    }

    public Comment removeComment(final Comment comment) {
        comments.remove(comment);
        comment.setPost(null);

        return comment;
    }
}
