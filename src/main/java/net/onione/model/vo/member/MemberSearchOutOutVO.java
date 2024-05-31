package net.onione.model.vo.member;

import lombok.*;
import net.onione.model.dto.member.MemberOutDTO;
import net.onione.model.entity.Member;
import net.onione.model.vo.common.BaseOutVO;

/**
 * packageName    : net.onione.model.vo.member
 * fileName       : MemberOutVO
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
public class MemberSearchOutOutVO implements BaseOutVO {
    private Long id;
    private String username;

    public static MemberSearchOutOutVO createByDto(MemberOutDTO memberOutDTO) {

        if(memberOutDTO == null) {
            return null;
        }

        return new MemberSearchOutOutVO(memberOutDTO.getId(), memberOutDTO.getUsername());
    }

    public static MemberSearchOutOutVO createByEntity(Member member) {
        if(member == null) {
            return null;
        }

        return new MemberSearchOutOutVO(member.getId(), member.getUsername());
    }


    @Override
    public boolean responseValidate() {
        if(this.id == null || this.username == null || this.username.isEmpty()) {
            return false;
        }
        return true;
    }
}
