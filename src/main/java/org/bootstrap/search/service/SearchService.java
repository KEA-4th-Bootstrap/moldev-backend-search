package org.bootstrap.search.service;


import lombok.RequiredArgsConstructor;
import org.bootstrap.search.dto.support.PostsDto;
import org.bootstrap.search.helper.SearchHelper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchService {

    private final SearchHelper searchHelper;

    public PostsDto findPostByTitle(String title) {
        return searchHelper.findPostsByTitle(title);
    }
}
