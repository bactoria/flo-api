package com.example.demo.song.domain;

import com.example.demo.album.domain.Album;
import lombok.*;

import javax.persistence.*;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@ToString
@EqualsAndHashCode(of = "songId")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @Column(unique = true)
    private String title;

    @Column(unique = false)
    private Long track;

    @Column(unique = false)
    private Long length;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album albumId;

}
