package org.bootstrap.search.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.search.repository.SearchRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SearchHelper {

    private final SearchRepository searchRepository;
}
