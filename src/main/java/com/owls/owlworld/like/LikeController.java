package com.owls.owlworld.like;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("")
    public LikeDto addLike(AddLikeRequest addLikeRequest, HttpServletRequest request) {
        Long memberId = Long.valueOf(String.valueOf(request.getAttribute("memberId")));

        return likeService.addLike(addLikeRequest, memberId);
    }
}
