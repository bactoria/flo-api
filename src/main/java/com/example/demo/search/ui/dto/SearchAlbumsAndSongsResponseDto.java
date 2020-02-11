package com.example.demo.search.ui.dto;

import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Getter
@AllArgsConstructor
public class SearchAlbumsAndSongsResponseDto {
    private List<AlbumSearchResponseDto> albums;
    private List<SongSearchResponseDto> songs;
}
