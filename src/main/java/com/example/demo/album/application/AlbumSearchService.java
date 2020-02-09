package com.example.demo.album.application;

import com.example.demo.album.application.dto.AlbumSearchRequestDto;
import com.example.demo.album.domain.AlbumQueryRepository;
import com.example.demo.locale.Locale;
import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Service
@RequiredArgsConstructor
public class AlbumSearchService {

    private final AlbumQueryRepository albumQueryRepository;

    public List<AlbumSearchResponseDto> searchAlbumsWithLocale(AlbumSearchRequestDto requestDto) {
        final String SEARCH_DATA = requestDto.getSearchData();
        final Locale USER_LOCALE = requestDto.getUserLocale();

        return albumQueryRepository.searchAlbumsWithLocale(new com.example.demo.album.domain.dto.AlbumSearchRequestDto(SEARCH_DATA, USER_LOCALE));
    }

}
