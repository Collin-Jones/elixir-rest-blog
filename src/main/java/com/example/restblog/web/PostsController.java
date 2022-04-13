package com.example.restblog.web;


import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping
    private List<Post> getAll() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 1", "hello"));
        posts.add(new Post(1L, "Post 2", "hello world"));
        posts.add(new Post(1L, "Post 3", "hello world 2.0"));
        return posts;
    }

    @GetMapping("{postId}")
    public Post getById(@PathVariable Long postId){
        return new Post(postId, "Post" + postId, "hello world");
    }
}
