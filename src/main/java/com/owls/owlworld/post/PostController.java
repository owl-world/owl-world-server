package com.owls.owlworld.post;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public GetAllPostResponse getPosts(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "30") Integer size) {
        return postService.getPosts(page, size);
    }

    @GetMapping("/{postId}")
    public PostDto getPost(@PathVariable String postId) {
        return postService.getPost(Long.valueOf(postId));
    }

    @PostMapping("")
    public PostDto addPost(@RequestBody AddPostRequest addPostRequest, HttpServletRequest request) {
        Long memberId = Long.valueOf(String.valueOf(request.getAttribute("memberId")));
        return postService.createPost(addPostRequest, memberId);
    }
}
