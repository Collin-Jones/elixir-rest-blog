package com.example.restblog.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private Long id;
    private String title;
    private String content;

    public Post(Long postId, String s) {
    }
}
