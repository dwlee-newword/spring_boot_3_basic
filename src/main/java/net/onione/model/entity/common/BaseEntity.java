package net.onione.model.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : net.onione.model.schema.common
 * fileName       : BaseEntity
 * author         : hanumoka
 * date           : 2/17/24
 * description    : 모든 엔티티의 공통 정보를 담고 있는 추상 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/17/24        hanumoka       최초 생성
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Comment("버전")
    @Column(name="version")
    protected Long version;

    @Comment("생성자")
    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;

    @Comment("수정자")
    @LastModifiedBy
    @Column(name = "modified_by")
    protected String modifiedBy;

    @Comment("생성일시")
    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Comment("수정일시")
    @Column(name = "modified_at")
    protected LocalDateTime modifiedAt;
}
