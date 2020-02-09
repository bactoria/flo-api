package com.example.demo.song.domain;

import com.example.demo.song.domain.dto.SongSearchResponseDto;
import com.example.demo.song.domain.dto.SongSearchRequestDto;

import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

public interface SongQueryRepository {
    List<SongSearchResponseDto> searchSongs(SongSearchRequestDto songSearchRequestDto);
}
