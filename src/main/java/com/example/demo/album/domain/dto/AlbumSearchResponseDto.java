package com.example.demo.album.domain.dto;

import com.example.demo.album.domain.Album;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumSearchResponseDto {
    private String title;
    private Long id;
    private List<SongSearchResponseDto> songs;

    public AlbumSearchResponseDto(Album album) {
        this.title = album.getTitle();
        this.id= album.getAlbumId();
        this.songs = album.getSongs().stream()
                .map(SongSearchResponseDto::new)
                .collect(Collectors.toList());
    }

}
