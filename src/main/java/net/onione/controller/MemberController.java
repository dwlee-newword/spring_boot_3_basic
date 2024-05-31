package net.onione.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.onione.model.vo.common.ApiResponse;
import net.onione.model.vo.member.MemberSaveInVO;
import net.onione.model.vo.member.MemberSearchOutOutVO;
import net.onione.model.vo.member.MemberUpdateInVO;
import net.onione.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberSearchOutOutVO>> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(ApiResponse.success(memberService.getMember(memberId)));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<MemberSearchOutOutVO>> saveMember(@Valid @RequestBody MemberSaveInVO memberSaveVO) {
        return ResponseEntity.ok(ApiResponse.success(memberService.saveMember(memberSaveVO)));
    }

    @PostMapping("/{memberId}/update")
    public ResponseEntity<ApiResponse<MemberSearchOutOutVO>> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateInVO memberUpdateInVO) {
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @PostMapping("/{memberId}/delete")
    public ResponseEntity<ApiResponse<Object>> deleteMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(ApiResponse.success());
    }

}
