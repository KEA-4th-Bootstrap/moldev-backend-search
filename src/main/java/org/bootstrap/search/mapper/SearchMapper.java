package org.bootstrap.search.mapper;


import org.bootstrap.search.common.PageInfo;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.dto.response.PostResponseDto;
import org.bootstrap.search.dto.response.PostResponseWithRedisDto;
import org.bootstrap.search.dto.response.SearchPostResponseDto;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchMapper {
    public PostResponseDto postToResponse(Post post) {
        return PostResponseDto.of(post);
    }

    public List<PostResponseDto> postSliceToResponse(Slice<Post> postSlice) {
        return postSlice.getContent()
                .stream()
                .map(PostResponseDto::of)
                .collect(Collectors.toList());
    }

    public SearchPostResponseDto postListToResponse(List<PostResponseWithRedisDto> postList, PageInfo pageInfo) {
        return SearchPostResponseDto.of(postList, pageInfo);
    }
}
