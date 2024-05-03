package org.bootstrap.search.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.search.common.PageInfo;
import org.bootstrap.search.document.Post;
import org.springframework.data.domain.Slice;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record SearchPostResponseDto(
        List<Post> posts,
        PageInfo pageInfo
) {
    public static SearchPostResponseDto of(Slice<Post> postSlice){
        return SearchPostResponseDto.builder()
                .posts(postSlice.getContent())
                .pageInfo(PageInfo.of(postSlice))
                .build();
    }
}
