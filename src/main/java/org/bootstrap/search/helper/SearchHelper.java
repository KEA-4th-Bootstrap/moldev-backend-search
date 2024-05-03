package org.bootstrap.search.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.search.dto.support.PostsDto;
import org.bootstrap.search.repository.SearchRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class SearchHelper {

    private final SearchRepository searchRepository;

    public PostsDto findPostsByTitle(String title) {
        try {
            PostsDto postByTitle = searchRepository.findPostByTitle(title);
            return postByTitle;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
