package org.bootstrap.search.controller;


import lombok.RequiredArgsConstructor;
import org.bootstrap.search.dto.response.SearchPostResponseDto;
import org.bootstrap.search.service.SearchService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SearchPostResponseDto> findPostByTitle(@RequestParam final String title,
                                                                 final Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(searchService.findPostByTitle(title, pageable));
    }
}
