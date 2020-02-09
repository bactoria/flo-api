package com.example.demo.album.domain;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class AlbumLocale implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    @Id
    @ElementCollection(targetClass = Locale.class)
    @CollectionTable(name = "locales", joinColumns = @JoinColumn(name = "albumId"))
    @Enumerated(EnumType.STRING)
    @Column(name="locale", nullable = false)
    private Locale locale;
}