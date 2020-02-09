package com.example.demo.album.domain;

import com.example.demo.album.domain.dto.AlbumSearchRequestDto;
import com.example.demo.locale.Locale;
import com.example.demo.album.domain.dto.AlbumSearchResponseDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

public interface AlbumQueryRepository {
    Optional<Album> findById(Long id);
    List<AlbumSearchResponseDto> searchAlbumsWithLocale(AlbumSearchRequestDto albumSearchRequestDto);
}
