package com.owls.owlworld.member;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.university.UniversityMajorDto;
import com.owls.owlworld.university.UniversityService;
import com.owls.owlworld.util.CryptoUtil;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final UniversityService universityService;

    public MemberService(MemberRepository memberRepository, UniversityService universityService) {
        this.memberRepository = memberRepository;
        this.universityService = universityService;
    }

    public MemberDto findById(Long id) {
        MemberEntity memberEntity = memberRepository
            .findById(id)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0004));

        UniversityMajorDto universityMajorDto = universityService.getMajorById(memberEntity.getUniversityMajorId());

        return memberEntity.toDto(universityMajorDto);
    }

    public MemberDto findByEmail(String email) {
        MemberEntity memberEntity = memberRepository.findByEmail(email);
        if (memberEntity == null) {
            throw new BusinessErrorException(ErrorCode.ERROR_0004);
        }

        UniversityMajorDto universityMajorDto = universityService.getMajorById(memberEntity.getUniversityMajorId());

        return memberEntity.toDto(universityMajorDto);
    }

    public boolean isEmailExist(String email) {
        return memberRepository.existsByEmail(email);
    }

    public boolean isNicknameExist(String nickname) {
        return memberRepository.existsByNickname(nickname);
    }

    public MemberDto addMember(AddMemberRequest addMemberRequest) {
        if (isEmailExist(addMemberRequest.getEmail())) {
            throw new BusinessErrorException(ErrorCode.ERROR_0001);
        }
        if (isNicknameExist(addMemberRequest.getNickname())) {
            throw new BusinessErrorException(ErrorCode.ERROR_0002);
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname(addMemberRequest.getNickname());
        memberEntity.setEmail(addMemberRequest.getEmail());
        memberEntity.setUniversityMajorId(addMemberRequest.getMajorId());

        try {
            memberEntity.setPassword(CryptoUtil.encrypt(addMemberRequest.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        MemberEntity savedEntity = memberRepository.save(memberEntity);

        UniversityMajorDto universityMajorDto = universityService.getMajorById(savedEntity.getUniversityMajorId());
        return savedEntity.toDto(universityMajorDto);
    }
}
