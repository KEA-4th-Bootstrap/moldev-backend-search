package org.bootstrap.search.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.search.common.PageInfo;
import org.bootstrap.search.document.Post;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public record SearchPostResponseDto(
        List<PostResponseWithRedisDto> postList,
        PageInfo pageInfo
) {
    public static SearchPostResponseDto of(List<PostResponseWithRedisDto> postList, PageInfo pageInfo){
        return SearchPostResponseDto.builder()
                .postList(postList)
                .pageInfo(pageInfo)
                .build();
    }
}
