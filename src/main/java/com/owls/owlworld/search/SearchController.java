package com.owls.owlworld.search;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("")
    public SearchResponse search(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "100") Integer size,
        @RequestParam String keyword, HttpServletRequest request) {
        boolean isMember = request.getAttribute("memberId") != null;
        Long memberId = isMember ? Long.valueOf(String.valueOf(request.getAttribute("memberId"))) : null;

        SearchRequest searchRequest = new SearchRequest(page, size, keyword);

        return searchService.search(searchRequest, memberId);
    }
}
