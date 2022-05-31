package de.erdlet.libertydemo.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class IndexController {

    private String greeting;

    @PostConstruct
    public void init() {
        this.greeting = "Hello from liberty-jsf!";
    }

    public String getGreeting() {
        return greeting;
    }
}
