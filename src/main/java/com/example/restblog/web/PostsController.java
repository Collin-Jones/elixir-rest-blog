package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.User;
import com.example.restblog.data.UserRepository;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.restblog.services.EmailService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {
    private final EmailService emailService;

    private final PostsRepository postRepository;
    private final UserRepository userRepository;

    public PostsController(EmailService emailService, PostsRepository postRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.emailService = emailService;
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
    private void createPost(@RequestBody Post newPost,  OAuth2Authentication auth){
        String email = auth.getName();
        User user = userRepository.findByEmail(email);
        newPost.setAuthor(user);
        postRepository.save(newPost);
        System.out.println("Post created");
        emailService.prepareAndSend(newPost,"title", "Hello world");
    }
    @PutMapping("{postId}")
    private void updatePost(@PathVariable Long postId , @RequestBody Post updatedPost){
        updatedPost.setId(postId);
        Post oldpost = postRepository.getById(postId);
        if (updatedPost.getTitle() != null){
            oldpost.setTitle(updatedPost.getTitle());
        }
        if (updatedPost.getContent() != null){
            oldpost.setContent(updatedPost.getContent());
        }
        postRepository.save(oldpost);
        System.out.println(postId + " " + oldpost);
    }

    @DeleteMapping("{postId}")
    private void deletePost(@PathVariable Long postId){
        postRepository.deleteById(postId);
        System.out.println(postId);
    }

}
