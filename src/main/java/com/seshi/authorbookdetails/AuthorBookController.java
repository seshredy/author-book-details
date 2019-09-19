package com.seshi.authorbookdetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AuthorBookController {

    @GetMapping("/getauthorbooks")
    public List<AuthorBooks> getAuthorBooks() {
        AuthorBooks a1 = new AuthorBooks(1,"Spring Fundamentals",20);
        AuthorBooks a2 = new AuthorBooks(2, "Spring Boot",30);
        AuthorBooks a3 = new AuthorBooks(3, "Spring Rest Apress",40);
        AuthorBooks a4 = new AuthorBooks(4, "Jenkins up and running",45);
        AuthorBooks a5 = new AuthorBooks(5, "Jenkins up and running v2",50);
        AuthorBooks a6 = new AuthorBooks(6, "Jenkins up and running v3",500);
        AuthorBooks a7 = new AuthorBooks(6, "Jenkins up and running v3",500);

        return Arrays.asList(a1, a2, a3,a4,a5,a6);

    }


}
