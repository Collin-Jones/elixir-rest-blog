package com.example.restblog.web;

import com.example.restblog.data.Category;
import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {





    private static final User USER1 = new User(1L, "User 1", "user1@bob.com", "1111", null, User.Role.USER, null);
    private static final User USER2 = new User(2L, "User 2", "user2@bob.com", "2222", null, User.Role.ADMIN, null);
    private static final User USER3 = new User(3L, "User 3", "user3@bob.com", "3333", null, User.Role.USER, null);

    private static final Category CAT1 = new Category(1L, "CAT 1", null);
    private static final Category CAT2 = new Category(2L, "CAT 2", null);
    private static final Category CAT3 = new Category(3L, "CAT 3", null);

    private final PostsRepository postRepository;

    public PostsController(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping
    private List<Post> getAll() {
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(new Post(1L, "Post 1", "hello",USER1, Arrays.asList(CAT1, CAT2)));
//        posts.add(new Post(2L, "Post 2", "hello world",USER2, Arrays.asList(CAT2, CAT3)));
//        posts.add(new Post(3L, "Post 3", "hello world 2.0", USER1, Arrays.asList(CAT1, CAT3)));
        return postRepository.findAll();
    }

    @GetMapping("{postId}")
    public Post getById(@PathVariable Long postId){
//        Post post = new Post(postId, "Post " + postId, "This is a test post", USER3, Arrays.asList(CAT1, CAT2));
        return postRepository.getById(postId);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
//        Post postToAdd = new Post(1L, newPost.getTitle(), newPost.getContent());
        System.out.println("Post created");
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
