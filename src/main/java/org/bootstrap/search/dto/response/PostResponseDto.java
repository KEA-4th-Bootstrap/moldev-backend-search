package org.bootstrap.search.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.search.document.CategoryType;
import org.bootstrap.search.document.Post;

import java.time.LocalDateTime;

import static org.bootstrap.search.utils.PostCategoryConverter.convertCodeToDesc;

@Builder(access= AccessLevel.PRIVATE)
public record PostResponseDto (
        Long postId,
        String title,
        String content,
        Long memberId,
        String thumbnail,
        CategoryType category,
        LocalDateTime createDate,
        LocalDateTime lastModifiedDate,
        Long viewCount,
        String moldevId
){
    public static PostResponseDto of(Post post) {
        return PostResponseDto.builder()
                .postId(Long.valueOf(post.post_id()))
                .title(post.title())
                .content(post.content())
                .memberId(Long.valueOf(post.member_id()))
                .thumbnail(post.thumbnail())
                .category(convertCodeToDesc(Integer.valueOf(post.category())))
                .createDate(LocalDateTime.parse(post.create_date()))
                .lastModifiedDate(LocalDateTime.parse(post.last_modified_date()))
                .viewCount(Long.valueOf(post.view_count()))
                .moldevId(post.moldev_id())
                .build();
    }
}
