package com.example.demo.song.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

public interface SongRepository extends JpaRepository<Song, Long> {
}
