package com.owls.owlworld.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/exist/email/{email}")
    public boolean isExistEmail(@PathVariable String email) {
        return memberService.isEmailExist(email);
    }

    @GetMapping("/exist/nickname/{nickname}")
    public boolean isExistNickname(@PathVariable String nickname) {
        return memberService.isNicknameExist(nickname);
    }

    @PostMapping("")
    public MemberDto addMember(@RequestBody AddMemberRequest addMemberRequest) {
        return memberService.addMember(addMemberRequest);
    }
}
