package de.erdlet.libertydemo.common.service;

import de.erdlet.libertydemo.common.dao.CommentDao;
import de.erdlet.libertydemo.common.dao.PostDao;
import de.erdlet.libertydemo.common.model.Comment;
import de.erdlet.libertydemo.common.model.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class BlogServiceImpl implements BlogService {

    @Inject
    PostDao postDao;

    @Inject
    CommentDao commentDao;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Optional<Post> findPostById(final Long id) {
        return postDao.findById(id);
    }

    @Override
    public Post createPost(final Post newPost) {
        return postDao.persist(newPost);
    }

    @Override
    public Post updatePost(final Post updatedPost) {
        return postDao.merge(updatedPost);
    }

    @Override
    public void deletePost(final Post postToDelete) {
        postDao.remove(postToDelete);
    }

    @Override
    public Comment addCommentToPost(final Long postId, final String text, final String author) {
        final Post post = postDao.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("No post found for id: " + postId));
        final Comment comment = post.addComment(text, author);

        return commentDao.persist(comment);
    }

    @Override
    public Comment updateComment(final Long postId, final Comment comment) {
        final Post post = postDao.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("No post found for id: " + postId));
        final Comment updatedComment = post.updateComment(comment);

        return commentDao.merge(updatedComment);
    }

    @Override
    public void deleteComment(final Long postId, final Comment comment) {
        final Post post = postDao.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("No post found for id: " + postId));
        final Comment commentToDelete = post.removeComment(comment);

        commentDao.remove(commentToDelete);
    }
}
