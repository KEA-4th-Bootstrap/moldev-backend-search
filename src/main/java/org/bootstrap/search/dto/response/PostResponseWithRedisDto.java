package org.bootstrap.search.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.search.document.CategoryType;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record PostResponseWithRedisDto(
        Long id,
        Long memberId,
        String title,
        String content,
        String frontUrl,
        String thumbnail,
        CategoryType category,
        LocalDateTime createDate,
        LocalDateTime lastModifiedDate,
        Long viewCount,
        String moldevId
) {
    public static PostResponseWithRedisDto of(PostResponseDto postResponseDto, Integer redisViewCount) {
        return PostResponseWithRedisDto.builder()
                .id(postResponseDto.postId())
                .memberId(postResponseDto.memberId())
                .title(postResponseDto.title())
                .content(postResponseDto.content())
                .frontUrl(postResponseDto.frontUrl())
                .thumbnail(postResponseDto.thumbnail())
                .category(postResponseDto.category())
                .createDate(postResponseDto.createDate())
                .lastModifiedDate(postResponseDto.lastModifiedDate())
                .viewCount(postResponseDto.viewCount() + redisViewCount)
                .moldevId(postResponseDto.moldevId())
                .build();
    }
}
