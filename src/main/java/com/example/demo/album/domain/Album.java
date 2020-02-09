package com.example.demo.album.domain;

import com.example.demo.locale.AlbumLocale;
import com.example.demo.locale.Locale;
import com.example.demo.song.domain.Song;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@Entity
@Getter
@Builder @AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "songs")
@EqualsAndHashCode(of = "albumId")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(unique = true)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    private List<AlbumLocale> locales = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "albumId")
    private List<Song> songs = new ArrayList<>();
}