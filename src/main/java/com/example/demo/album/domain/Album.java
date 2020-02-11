package com.example.demo.album.domain;

import com.example.demo.locale.AlbumLocale;
import com.example.demo.locale.Locale;
import com.example.demo.song.domain.Song;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@ToString(exclude = "songs")
@EqualsAndHashCode(of = "albumId")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(unique = true)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    @Fetch(FetchMode.SELECT)
    private Set<AlbumLocale> locales = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "albumId")
    private Set<Song> songs = new HashSet<>();
}