package com.example.demo.song.domain.dto;

import com.example.demo.song.domain.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongSearchResponseDto {
    private String title;
    private Long id;
    private Long length;
    private Long track;

    public SongSearchResponseDto(Song song) {
        this.title = song.getTitle();
        this.track = song.getTrack();
        this.length = song.getLength();
        this.id = song.getSongId();
    }

}
