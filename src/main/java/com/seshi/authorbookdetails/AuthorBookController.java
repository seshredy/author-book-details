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

        return Arrays.asList(a1, a2, a3);

    }


}
