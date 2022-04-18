package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {

    @GetMapping
    private List<User> getAll() {
        List<User> posts = new ArrayList<>();
        posts.add(new User());
        posts.add(new User());
        posts.add(new User());
        return posts;
    }

    @GetMapping("{postId}")
    private User getById(@PathVariable Long postId){
        return new User();
    }

    @PostMapping
    private void createUser(@RequestBody Post newPost){
        System.out.println(newPost);
    }
    @PutMapping("{postId}")
    private void updateUser(@PathVariable Long postId , @RequestBody Post updatedPost){
        updatedPost.setId(postId);
        System.out.println(postId + " " + updatedPost);
    }

    @DeleteMapping("{postId}")
    private void deleteUser(@PathVariable Long postId){
        System.out.println(postId);
    }

}
