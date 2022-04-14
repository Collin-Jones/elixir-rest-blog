package com.example.restblog.web;


import com.example.restblog.data.Post;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping
    private List<Post> getAll() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 1", "hello"));
        posts.add(new Post(2L, "Post 2", "hello world"));
        posts.add(new Post(3L, "Post 3", "hello world 2.0"));
        return posts;
    }

    @GetMapping("{postId}")
    public Post getById(@PathVariable Long postId){
        return new Post(postId, "Post" + postId, "hello world");
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost);
    }
    @PutMapping("{postId}")
    private void updatePost(@PathVariable Long postId , @RequestBody Post updatedPost){
        updatedPost.setId(postId);
        System.out.println(postId + " " + updatedPost);
    }

    @DeleteMapping("{postId}")
    private void deletePost(@PathVariable Long postId){
        System.out.println(postId);
    }

}
