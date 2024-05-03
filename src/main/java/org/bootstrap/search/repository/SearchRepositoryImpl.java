package org.bootstrap.search.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.dto.support.PostDto;
import org.bootstrap.search.dto.support.PostsDto;
import org.bootstrap.search.utils.PostPair;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.bootstrap.search.common.Constants.POSTS;


@RequiredArgsConstructor
@Repository
public class SearchRepositoryImpl implements SearchRepository{

    private final ElasticsearchClient esClient;


    public PostsDto findPostByTitle(String title) throws IOException {
        SearchResponse<Post> getPosts = esClient.search(ss -> ss
                        .index(POSTS)
                        .query(q -> q
                                .term(t -> t
                                        .field("title")
                                        .value(title))
                        )
                , Post.class);
        if (getPosts.hits().hits().isEmpty()) {
            return null;
        }
        PostsDto postsDto = PostsDto.of(
                getPosts.hits().hits().stream()
                        .map(post -> PostDto.of(post.source()))
                        .collect(Collectors.toList())
        );
        return postsDto;
    }
}
