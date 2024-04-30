package org.spot.pratice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spot.pratice.service.dto.BlogCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;



    @Builder
    public Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }


    public static Blog create(
            Member member,
            BlogCreateRequest blogCreateRequest
    ) {
        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
    }

    public void updateTitle(
            String title
    ) {
        this.title = title;
    }


}
