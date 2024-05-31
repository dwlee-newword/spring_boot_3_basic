package net.onione.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.onione.model.entity.common.BaseEntity;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Comment("로그인 식별키")
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Comment("사용자 UUID")
    @Column(name = "user_uuid", unique = true, nullable = false)
    private String userUuid;

    @Comment("비밀번호")
    @Column(name = "password", nullable = false)
    private String password;

    @Comment("가입일시")
    @Column(name = "join_date_time")
    private LocalDateTime joinDateTime;

    public static Member createByVO(String username, String password, String userUuid, LocalDateTime joinDateTime) {
        return Member.builder()
                .username(username)
                .password(password)
                .userUuid(userUuid)
                .joinDateTime(joinDateTime)
                .build();
    }
}
