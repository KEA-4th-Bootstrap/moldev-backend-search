package org.bootstrap.search.repository;

import org.bootstrap.search.document.Post;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface SearchRepository {

    public Post findPostByText(String text) throws IOException;

}
