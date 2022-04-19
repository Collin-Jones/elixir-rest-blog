package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {

    @GetMapping
    private List<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1L, "User1", "email address","password", null, User.Role.ADMIN));
        users.add(new User(2L, "User2", "email address2","thePassword", null, User.Role.USER));
        users.add(new User(3L, "User3", "email address3","passwordThe", null, User.Role.ADMIN));
        return users;
    }

    @GetMapping("{userId}")
    private User getById(@PathVariable Long userId){
        return new User(userId, "User3", "email address3","passwordThe", null, User.Role.ADMIN);
    }

    @GetMapping("/username")
    private User getByUsername(@RequestParam String userName){
        return new User(1L, userName, "email address3","passwordThe", null, User.Role.ADMIN);
    }

    @GetMapping("/email")
    private User getByEmail(@RequestParam String userEmail){
        return new User(1L, "TheTaco", userEmail,"passwordThe", null, User.Role.ADMIN);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser);
    }
    @PutMapping("{userId}")
    private void updateUser(@PathVariable Long userId , @RequestBody User updatedUser){
        updatedUser.setId(userId);
        System.out.println(userId + " " + updatedUser);
    }

    @PutMapping("{userId}/updatePassword")
    private void updatePassword(@PathVariable Long userId, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword){
        System.out.println(userId + " " + oldPassword + " " + newPassword);
    }

    @DeleteMapping("{userId}")
    private void deleteUser(@PathVariable Long userId){
        System.out.println(userId);
    }

}
