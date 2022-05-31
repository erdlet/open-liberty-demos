package de.erdlet.libertydemo.common.dao;

import de.erdlet.libertydemo.common.model.Comment;
import de.erdlet.libertydemo.common.model.Post;

import java.util.List;

public interface CommentDao extends Dao<Comment, Long> {

    List<Comment> findCommentsByPost(final Post post);
}
