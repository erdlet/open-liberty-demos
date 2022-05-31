package de.erdlet.libertydemo.jsf;

import de.erdlet.libertydemo.common.model.Post;
import de.erdlet.libertydemo.common.service.BlogService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class IndexController {

    @Inject
    BlogService service;

    private List<Post> posts;


    @PostConstruct
    public void init() {
        posts = List.copyOf(service.findAll());
    }

    public List<Post> getPosts() {
        return posts;
    }

    public boolean containsPosts() {
        return !posts.isEmpty();
    }
}
