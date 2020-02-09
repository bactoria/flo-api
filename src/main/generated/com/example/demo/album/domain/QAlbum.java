package com.example.demo.album.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = -1911724354L;

    public static final QAlbum album = new QAlbum("album");

    public final NumberPath<Long> albumId = createNumber("albumId", Long.class);

    public final ListPath<Locale, EnumPath<Locale>> locales = this.<Locale, EnumPath<Locale>>createList("locales", Locale.class, EnumPath.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.song.domain.Song, com.example.demo.song.domain.QSong> songs = this.<com.example.demo.song.domain.Song, com.example.demo.song.domain.QSong>createList("songs", com.example.demo.song.domain.Song.class, com.example.demo.song.domain.QSong.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QAlbum(String variable) {
        super(Album.class, forVariable(variable));
    }

    public QAlbum(Path<? extends Album> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbum(PathMetadata metadata) {
        super(Album.class, metadata);
    }

}

