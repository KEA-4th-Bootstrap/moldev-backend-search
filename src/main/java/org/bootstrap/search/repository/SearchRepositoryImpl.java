package org.bootstrap.search.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.utils.PostPair;

import java.io.IOException;

import static org.bootstrap.search.common.Constants.POSTS;


@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository{

    private final ElasticsearchClient esClient;


    public PostPair findPostByText(String text) throws IOException {

        SearchResponse<Post> getArticle = esClient.search(ss -> ss
                        .index(POSTS)
                        .query(q -> q
                                .term(t -> t
                                        .field("title.text")
                                        .value(text))
                        )
                , Post.class);

        if (getArticle.hits().hits().isEmpty()) {
            return null;
        }
        return new ArticleIdPair(extractSource(getArticle), extractId(getArticle));
    }
}
