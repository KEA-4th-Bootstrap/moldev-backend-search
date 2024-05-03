package org.bootstrap.search.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.search.common.error.ElasticSearchException;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.repository.SearchRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.bootstrap.search.common.error.GlobalErrorCode.ELASTIC_SEARCH_QUERY_ERROR;

@RequiredArgsConstructor
@Component
public class SearchHelper {

    private final SearchRepository searchRepository;

    public Slice<Post> findPostsByTitle(String title, Pageable pageable) {
        try {
            return searchRepository.findPostByTitle(title, pageable);
        } catch (IOException e) {
            throw new ElasticSearchException(ELASTIC_SEARCH_QUERY_ERROR);
        }
    }
}
