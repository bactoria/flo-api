package com.example.demo.locale;

import com.example.demo.album.domain.Album;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Table(name = "ALBUMLOCALE")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@IdClass(AlbumLocaleId.class)
public class AlbumLocale implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @Id
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Locale locale;
}
