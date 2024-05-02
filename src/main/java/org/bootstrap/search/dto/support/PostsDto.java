package org.bootstrap.search.dto.support;

import lombok.Builder;

import java.util.List;


@Builder
public record PostsDto (
    List<PostDto> postList
){
    public static PostsDto of(List<PostDto> postList) {
        return PostsDto.builder()
                .postList(postList)
                .build();
    }
}
