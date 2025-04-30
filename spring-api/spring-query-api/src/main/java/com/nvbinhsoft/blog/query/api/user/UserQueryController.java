package com.nvbinhsoft.blog.query.api.user;

import com.nvbinhsoft.blog.query.application.user.handler.UserQueryHandler;
import com.nvbinhsoft.blog.query.dto.UserProfileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    private final UserQueryHandler userQueryHandler;

    @Autowired
    public UserQueryController(UserQueryHandler userQueryHandler) {
        this.userQueryHandler = userQueryHandler;
    }

    @GetMapping("/profile")
    public UserProfileView getUserProfile() {
        return userQueryHandler.handleGetUserProfile();
    }
}
