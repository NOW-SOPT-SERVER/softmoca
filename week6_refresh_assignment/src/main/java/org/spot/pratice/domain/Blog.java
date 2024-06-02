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

    private String imageUrl;

    @Builder
    public Blog(Member member, String title, String description, String imageUrl) {
        this.member = member;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static Blog create(
            Member member,
            String title,
            String description,
            String imageUrl
    ) {
        return new Blog(member, title, description, imageUrl);
    }

    public void updateTitle(
            String title
    ) {
        this.title = title;
    }
}
