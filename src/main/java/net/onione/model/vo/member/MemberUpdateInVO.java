package net.onione.model.vo.member;

import lombok.*;

/**
 * 클래스 설명란
 *
 * @author : KYB
 * @fileName : MemberUpdateInVO
 * @since : 2024-02-20
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateInVO {
    private String username;
    private String password;
}
