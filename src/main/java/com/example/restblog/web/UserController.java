package com.example.restblog.web;

import com.example.restblog.data.User;
import com.example.restblog.data.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UserController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //    private static final Post POST1 = new Post(1L, "Post 1", "Blah", null, Arrays.asList(CAT1, CAT2));
//    private static final Post POST2 = new Post(2L, "Post 2", "Blah", null, Arrays.asList(CAT2, CAT3));
//    private static final Post POST3 = new Post(3L, "Post 3", "Blah", null, Arrays.asList(CAT1, CAT3));
//    private static final Post POST4 = new Post(4L, "Post 4", "Blah", null, Arrays.asList(CAT1, CAT2));
//    private static final Post POST5 = new Post(5L, "Post 5", "Blah", null, Arrays.asList(CAT2, CAT3));
//    private static final Post POST6 = new Post(6L, "Post 6", "Blah", null, Arrays.asList(CAT1, CAT3));

    @GetMapping
    private List<User> getAll() {
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User(1L, "User1", "email address","password", null, User.Role.ADMIN, Arrays.asList(POST1, POST2)));
//        users.add(new User(2L, "User2", "email address2","thePassword", null, User.Role.USER, Arrays.asList(POST3, POST4)));
//        users.add(new User(3L, "User3", "email address3","passwordThe", null, User.Role.ADMIN, Arrays.asList(POST5, POST6)));
        return userRepository.findAll();
    }

    @GetMapping("{userId}")
    private User getById(@PathVariable Long userId){
//        return new User(userId, "User3", "email address3","passwordThe", null, User.Role.ADMIN, Arrays.asList(POST1, POST2));
        return userRepository.getById(userId);
    }
//
//    @GetMapping("/username")
//    private User getByUsername(@RequestParam String userName){
//        return new User(1L, userName, "email address3","passwordThe", null, User.Role.ADMIN, Arrays.asList(POST1, POST2));
//    }
//
//    @GetMapping("/email")
//    private User getByEmail(@RequestParam String userEmail){
//        return new User(1L, "TheTaco", userEmail,"passwordThe", null, User.Role.ADMIN, Arrays.asList(POST1, POST2));
//    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        newUser.setCreatedAt(LocalDate.now());
        newUser.setRole(User.Role.USER);
        String encodePassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);
        userRepository.save(newUser);
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
