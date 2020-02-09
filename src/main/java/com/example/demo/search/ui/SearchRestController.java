package com.example.demo.search.ui;

import com.example.demo.search.SearchService;
import com.example.demo.search.ui.dto.SearchAlbumsAndSongsResponseDto;
import com.example.demo.search.ui.dto.SearchAlbumsAndSongsRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/search")
@RestController
public class SearchRestController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<SearchAlbumsAndSongsResponseDto> searchAlbumsAndSongs(@ModelAttribute SearchAlbumsAndSongsRequestDto searchRequestDto) {
        log.info("GET :: /search , QueryString=",searchRequestDto);
        SearchAlbumsAndSongsResponseDto body = searchService.searchAlbumsAndSongs(searchRequestDto);
        return ResponseEntity.ok(body);
    }

}
