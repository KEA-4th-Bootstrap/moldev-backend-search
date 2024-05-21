package org.bootstrap.search.service;


import lombok.RequiredArgsConstructor;
import org.bootstrap.search.common.PageInfo;
import org.bootstrap.search.document.Post;
import org.bootstrap.search.dto.response.PostResponseDto;
import org.bootstrap.search.dto.response.PostResponseWithRedisDto;
import org.bootstrap.search.dto.response.SearchPostResponseDto;
import org.bootstrap.search.helper.SearchHelper;
import org.bootstrap.search.mapper.SearchMapper;
import org.bootstrap.search.utils.RedisUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchService {

    private final static String POST_VIEW_COUNT = "post_view_count";
    private final SearchHelper searchHelper;
    private final SearchMapper searchMapper;
    private final RedisUtils redisUtils;
    public SearchPostResponseDto findPostByTitle(String title, Pageable pageable) {
        Slice<Post> postSlice = searchHelper.findPostsByTitle(title, pageable);
        List<PostResponseDto> postResponseDtoList = searchMapper.postSliceToResponse(postSlice);
        List<PostResponseWithRedisDto> postResponseWithRedisDto = createPostResponseWithRedisDto(postResponseDtoList);
        return searchMapper.postListToResponse(postResponseWithRedisDto, PageInfo.of(postSlice));
    }

    private List<PostResponseWithRedisDto> createPostResponseWithRedisDto(List<PostResponseDto> postResponseDtoList) {
        return postResponseDtoList.stream()
                .map(postResponseDto -> {
                            Double viewCount = redisUtils.getZSetOperations().score(POST_VIEW_COUNT, String.valueOf(postResponseDto.postId()));
                            if (viewCount == null) {
                                return PostResponseWithRedisDto.of(postResponseDto, 0);
                            }
                            return PostResponseWithRedisDto.of(postResponseDto, viewCount.intValue());
                        })
                .collect(Collectors.toList());

    }
}
