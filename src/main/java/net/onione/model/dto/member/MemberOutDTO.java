package net.onione.model.dto.member;

import lombok.*;
import net.onione.model.entity.Member;

/**
 * packageName    : net.onione.model.dto.member
 * fileName       : MemberOutDTO
 * author         : hanumoka
 * date           : 2/19/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        hanumoka       최초 생성
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberOutDTO {

    private Long id;
    private String username;

    public static MemberOutDTO createByEntity(Member member) {

        if(member == null) {
            return null;
        }

        return MemberOutDTO.builder()
                .id(member.getId())
                .username(member.getUsername())
                .build();
    }

//    private Long id;
//    private String username;
//    private
//
//    public static MemberOutDTO createByMember(Member member) {
//        return MemberOutDTO.builder()
//                .memberId(member.getId())
//                .username(member.getUsername())
//                .build();
//    }
}
