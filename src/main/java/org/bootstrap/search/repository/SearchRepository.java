package org.bootstrap.search.repository;

import org.bootstrap.search.document.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface SearchRepository {

    Slice<Post> findPostByTitle(String title, Pageable pageable) throws IOException;

}
