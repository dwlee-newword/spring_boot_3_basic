package net.onione.model.vo.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import net.onione.model.entity.Member;

import java.time.LocalDateTime;

/**
 * packageName    : net.onione.model.vo.member
 * fileName       : MemberSaveVO
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
public class MemberSaveInVO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public Member toEntity(String userUuid, LocalDateTime joinDateTime) {
        return Member.createByVO(username, password, userUuid, joinDateTime);
    }
}
