package net.onione.model.dto.member;

import lombok.*;
import net.onione.model.vo.member.MemberSaveInVO;

/**
 * packageName    : net.onione.model.dto.member
 * fileName       : MemberSaveInDTO
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
public class MemberSaveInDTO {
    private Long id;
    private String username;
    public static MemberSaveInDTO createByVO(MemberSaveInVO memberSaveVO) {
        return null;
    }
}
