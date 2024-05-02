package org.bootstrap.search.controller;


import lombok.RequiredArgsConstructor;
import org.bootstrap.search.common.SuccessCode;
import org.bootstrap.search.common.SuccessResponse;
import org.bootstrap.search.dto.support.PostsDto;
import org.bootstrap.search.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/posts")
    public ResponseEntity<SuccessResponse<?>> findPostByTitle(@RequestParam String title) {
        return SuccessResponse.ok(searchService.findPostByTitle(title));
    }
}
