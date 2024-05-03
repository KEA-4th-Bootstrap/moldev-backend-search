package org.bootstrap.search.mapper;


import org.bootstrap.search.document.Post;
import org.bootstrap.search.dto.response.SearchPostResponseDto;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
public class SearchMapper {
    public SearchPostResponseDto slicePostToResponse(Slice<Post> postSlice) {
        return SearchPostResponseDto.of(postSlice);
    }
}
