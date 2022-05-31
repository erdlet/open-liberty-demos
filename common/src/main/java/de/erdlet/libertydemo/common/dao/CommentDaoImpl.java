package de.erdlet.libertydemo.common.dao;

import de.erdlet.libertydemo.common.model.Comment;
import de.erdlet.libertydemo.common.model.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext(name = "blog")
    EntityManager em;

    @Override
    public List<Comment> findAll() {
        final TypedQuery<Comment> query = em.createNamedQuery(Comment.FIND_ALL, Comment.class);

        return query.getResultList();
    }

    @Override
    public Optional<Comment> findById(final Long id) {
        final TypedQuery<Comment> query = em.createNamedQuery(Comment.FIND_BY_ID, Comment.class);
        query.setParameter("id", id);

        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<Comment> findCommentsByPost(final Post post) {
        final TypedQuery<Comment> query = em.createNamedQuery(Comment.FIND_BY_POST, Comment.class);
        query.setParameter("post", post);

        return query.getResultList();
    }

    @Override
    public Comment persist(final Comment comment) {
        em.persist(comment);
        em.flush();

        return comment;
    }

    @Override
    public Comment merge(final Comment comment) {
        return em.merge(comment);
    }

    @Override
    public void remove(final Comment comment) {
        em.remove(comment);
    }
}
