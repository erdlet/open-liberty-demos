package de.erdlet.libertydemo.common.service;

import de.erdlet.libertydemo.common.model.Comment;
import de.erdlet.libertydemo.common.model.Post;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<Post> findAll();

    Optional<Post> findPostById(final Long id);

    Post createPost(final Post newPost);

    Post updatePost(final Post updatedPost);

    void deletePost(final Post postToDelete);

    Comment addCommentToPost(final Long postId, final String text, final String author);

    Comment updateComment(final Long postId, final Comment comment);

    void deleteComment(final Long postId, final Comment comment);
}
