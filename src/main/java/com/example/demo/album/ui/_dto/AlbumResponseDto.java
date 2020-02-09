package com.example.demo.album.ui._dto;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.Locale;
import com.example.demo.song.domain.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@NoArgsConstructor @Getter
public class AlbumResponseDto {

    private String title;
    private List<Locale> locales = new ArrayList<>();
    private List<SongResponseDto> song = new ArrayList<>();

    public AlbumResponseDto(Album album) {
        this.title = album.getTitle();
        this.locales = album.getLocales();
        this.song = album.getSongs().stream().map(SongResponseDto::new).collect(Collectors.toList());
    }

    @Getter
    static class SongResponseDto {

        private Long length;
        private String title;
        private Long track;

        SongResponseDto(Song song) {
            this.length = song.getLength();
            this.title = song.getTitle();
            this.track = song.getTrack();
        }
    }
}
