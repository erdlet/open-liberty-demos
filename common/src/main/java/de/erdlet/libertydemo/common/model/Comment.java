package de.erdlet.libertydemo.common.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comments")
@NamedQueries({
        @NamedQuery(name = Comment.FIND_ALL, query = "SELECT c FROM Comment  c"),
        @NamedQuery(name = Comment.FIND_BY_ID, query = "SELECT c FROM Comment c WHERE c.id = :id"),
        @NamedQuery(name = Comment.FIND_BY_POST, query = "SELECT c FROM Comment c WHERE c.post = :post")
})
public class Comment {

    public static final String FIND_ALL = "Comment.findAll";
    public static final String FIND_BY_ID = "Comment.findById";
    public static final String FIND_BY_POST = "Comment.findByPost";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment() {
    }

    public Comment(final String text, final String author, final Post post) {
        this.text = text;
        this.author = author;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
