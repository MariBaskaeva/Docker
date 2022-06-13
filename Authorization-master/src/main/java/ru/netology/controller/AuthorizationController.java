package ru.netology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.enums.Authorities;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/signin")
    public String signin() {
        return "";
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String handleInvalidCredentials(InvalidCredentials ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private String handleUnauthorizedUser(UnauthorizedUser ex){
        String message = ex.getMessage();
        System.out.println(message);
        return message;
    }
}