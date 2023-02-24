package com.owls.owlworld.auth;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.university.UniversityMajorDto;
import com.owls.owlworld.util.CryptoUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberService memberService;

    public AuthService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        MemberDto memberDto = memberService.findByEmail(email);
        try {
            if (!memberDto.getPassword().equals(CryptoUtil.encrypt(password))) {
                throw new BusinessErrorException(ErrorCode.ERROR_0005);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return createToken(memberDto);
    }

    private String createToken(MemberDto memberDto) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000 * 7); // 토큰 만료 시간: 24시간
        Claims claims = Jwts.claims();
        claims.put("memberId", memberDto.getId());
        claims.put("nickname", memberDto.getNickname());
        claims.put("email", memberDto.getEmail());
        claims.put("majorId", memberDto.getUniversityMajorDto().getId());
        claims.put("majorName", memberDto.getUniversityMajorDto().getName());
        claims.put("universityId", memberDto.getUniversityMajorDto().getUniversity().getId());
        claims.put("universityName", memberDto.getUniversityMajorDto().getUniversity().getName());
        claims.put("universityLogo", memberDto.getUniversityMajorDto().getUniversity().getLogo());
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS256, "12345")
            .compact();
    }
}
