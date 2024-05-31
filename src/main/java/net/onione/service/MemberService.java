package net.onione.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.onione.data.mapper.hc.MemberMapper;
import net.onione.data.repository.MemberRepository;
import net.onione.model.entity.Member;
import net.onione.model.vo.member.MemberSaveInVO;
import net.onione.model.vo.member.MemberSearchOutOutVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper hcMemberMapper;
    private final net.onione.data.mapper.mc.MemberMapper mcMemberMapper;

    @Transactional(readOnly = true)
    public MemberSearchOutOutVO getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        MemberSearchOutOutVO memberSearchOutVO = MemberSearchOutOutVO.createByEntity(member);
        return memberSearchOutVO;
    }

    @Transactional
    public MemberSearchOutOutVO saveMember(MemberSaveInVO memberSaveVO) {
        ZoneId kstZoneId = ZoneId.of("Asia/Seoul");
        LocalDateTime joinDateTime = LocalDateTime.now(kstZoneId);
        String userUuid = UUID.randomUUID().toString();
        Member member = memberRepository.save(memberSaveVO.toEntity(userUuid, joinDateTime));
        MemberSearchOutOutVO memberSearchOutVO = MemberSearchOutOutVO.createByEntity(member);
        return memberSearchOutVO;
    }

//    public MemberOutDTO saveMember(MemberSaveInDTO memberSaveInDTO) {
//        Member member = memberRepository.save(memberSaveInDTO.toEntity());
//        return null;
//    }

//    @Transactional
//    public Member saveMember(String username) {
//        Member save = memberRepository.save(Member.builder().username(username).build());
//
//        if (username.equals("ex")) {
//            throw new IllegalArgumentException();
//        }
//
//        return save;
//    }
//
//    public List<AllMemberOutDto> getAllMemberHc() {
//        log.info("HC Start");
//        return hcMemberMapper.getAllMember();
//    }
//
//    public List<AllMemberOutDto> getAllMemberMc() {
//        log.info("MC Start");
//        return mcMemberMapper.getAllMember();
//    }


}
