package de.erdlet.libertydemo.common.dao;

import de.erdlet.libertydemo.common.model.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostDaoImpl implements PostDao {

    @PersistenceContext(name = "blog")
    EntityManager em;

    @Override
    public List<Post> findAll() {
        final TypedQuery<Post> query = em.createNamedQuery(Post.FIND_ALL, Post.class);

        return query.getResultList();
    }

    @Override
    public Optional<Post> findById(final Long id) {
        final TypedQuery<Post> query = em.createNamedQuery(Post.FIND_BY_ID, Post.class);
        query.setParameter("id", id);

        return query.getResultList().stream().findFirst();
    }

    @Override
    public Post persist(final Post post) {
        em.persist(post);
        /* Flush to get ID generated */
        em.flush();

        return post;
    }

    @Override
    public Post merge(final Post post) {
        return em.merge(post);
    }

    @Override
    public void remove(final Post post) {
        em.remove(post);
    }
}
