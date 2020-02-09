package com.example.demo.song.application;

import com.example.demo.locale.Locale;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import com.example.demo.song.domain.SongQueryRepository;
import com.example.demo.song.domain.dto.SongSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Service
@RequiredArgsConstructor
public class SongSearchService {

    private final SongQueryRepository songQueryRepository;

    public List<SongSearchResponseDto> searchSongsWithLocale(SongSearchRequestDto requestDto) {
        return songQueryRepository.searchSongs(requestDto);
    }

}
