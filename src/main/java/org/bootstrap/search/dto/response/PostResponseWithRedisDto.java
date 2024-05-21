package org.bootstrap.search.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record PostResponseWithRedisDto(
        PostResponseDto postResponseDto,
        Integer redisViewCount
) {
    public static PostResponseWithRedisDto of(PostResponseDto postResponseDto, Integer redisViewCount) {
        return PostResponseWithRedisDto.builder()
                .postResponseDto(postResponseDto)
                .redisViewCount(redisViewCount)
                .build();
    }
}
