package com.example.demo.album.domain;

import java.util.Optional;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

public interface AlbumQueryRepository {
    Optional<Album> findById(Long id);
}
