package com.example.demo.search;

import com.example.demo.album.application.AlbumSearchService;
import com.example.demo.album.application.dto.AlbumSearchRequestDto;
import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import com.example.demo.locale.Locale;
import com.example.demo.search.ui.dto.SearchAlbumsAndSongsResponseDto;
import com.example.demo.search.ui.dto.SearchAlbumsAndSongsRequestDto;
import com.example.demo.song.application.SongSearchService;
import com.example.demo.song.domain.dto.SongSearchRequestDto;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@RequiredArgsConstructor
@Service
public class SearchService {

    private final AlbumSearchService albumSearchService;
    private final SongSearchService songSearchService;

    public SearchAlbumsAndSongsResponseDto searchAlbumsAndSongs(SearchAlbumsAndSongsRequestDto searchRequestDto) {
        String title = searchRequestDto.getTitle();
        Locale locale = Locale.findLocale(searchRequestDto.getLocale());

        AlbumSearchRequestDto albumSearchRequestDto = new AlbumSearchRequestDto(title, locale);
        SongSearchRequestDto songSearchRequestDto = new SongSearchRequestDto(title, locale);

        List<AlbumSearchResponseDto> albums = albumSearchService.searchAlbumsWithLocale(albumSearchRequestDto);
        List<SongSearchResponseDto> songs = songSearchService.searchSongsWithLocale(songSearchRequestDto);

        return new SearchAlbumsAndSongsResponseDto(albums, songs);
    }

}
