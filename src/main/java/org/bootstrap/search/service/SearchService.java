package org.bootstrap.search.service;


import lombok.RequiredArgsConstructor;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.dto.response.SearchPostResponseDto;
import org.bootstrap.search.helper.SearchHelper;
import org.bootstrap.search.mapper.SearchMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchService {

    private final SearchHelper searchHelper;
    private final SearchMapper searchMapper;
    public SearchPostResponseDto findPostByTitle(String title, Pageable pageable) {
        Slice<Post> postSlice = searchHelper.findPostsByTitle(title, pageable);
        return searchMapper.slicePostToResponse(postSlice);
    }
}
