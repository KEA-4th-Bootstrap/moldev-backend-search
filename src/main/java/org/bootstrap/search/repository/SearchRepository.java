package org.bootstrap.search.repository;

import org.bootstrap.search.dto.support.PostsDto;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface SearchRepository {

    PostsDto findPostByTitle(String title) throws IOException;

}
