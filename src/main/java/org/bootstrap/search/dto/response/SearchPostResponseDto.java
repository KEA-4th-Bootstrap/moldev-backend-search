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
        List<PostResponseDto> postList,
        PageInfo pageInfo
) {
    public static SearchPostResponseDto of(Slice<Post> postSlice){
        return SearchPostResponseDto.builder()
                .postList(postSlice.getContent().stream()
                        .map(PostResponseDto::of)
                        .collect(Collectors.toList()))
                .pageInfo(PageInfo.of(postSlice))
                .build();
    }
}
