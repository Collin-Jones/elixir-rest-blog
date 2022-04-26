package com.example.restblog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    public enum Role {USER, ADMIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    private String username;
    @Column(nullable = false, length = 250)
    private String email;
    @Column
    private String password;
    @Column
    private LocalDate createdAt;
    @Column
    private Role role;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    @ToString.Exclude
    private Collection<Post> posts;
}