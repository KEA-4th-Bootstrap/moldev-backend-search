package org.bootstrap.search.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import org.bootstrap.search.document.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.bootstrap.search.common.Constants.POSTS;


@RequiredArgsConstructor
@Repository
public class SearchRepositoryImpl implements SearchRepository{

    private final ElasticsearchClient esClient;

    public Slice<Post> findPostByTitle(String title, Pageable pageable) throws IOException {
        SearchResponse<Post> getPosts = esClient.search(ss -> ss
                        .index(POSTS)
                        .from(pageable.getPageNumber() * pageable.getPageSize())
                        .size(pageable.getPageSize() + 1)
                        .query(q -> q
//                                .match(t -> t
//                                        .field("title")
//                                        .query(title))
//                                .term(t -> t
//                                        .field("title")
//                                        .value(title))
                                // ngram tokenizer를 통해 검색 쿼리를 쪼개 검색해 검색성능 향상
                                .bool(b -> b
                                        .should(s -> s
                                                .match(m -> m
                                                        .field("title.ngram")
                                                        .query(title))))
                        )
                , Post.class);
        // 검색 결과에서 Hits 추출
        List<Hit<Post>> hits = getPosts.hits().hits();

        // Hit 객체에서 실제 Post 객체를 추출하여 List에 추가
        List<Post> postList = hits.stream()
                .map(Hit::source)  // Hit 객체에서 Post 객체를 추출
                .collect(Collectors.toCollection(ArrayList::new));  ;  // ArrayList로 수집
        return new SliceImpl<>(postList, pageable, hasNextPage(postList, pageable.getPageSize()));
    }

    private boolean hasNextPage(List<Post> postList, int pageSize) {
        if (postList.size() > pageSize) {
            postList.remove(pageSize);
            return true;
        }
        return false;
    }
}
