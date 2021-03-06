package com.example.demo.song.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSong is a Querydsl query type for Song
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSong extends EntityPathBase<Song> {

    private static final long serialVersionUID = 1386001472L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSong song = new QSong("song");

    public final com.example.demo.album.domain.QAlbum albumId;

    public final NumberPath<Long> length = createNumber("length", Long.class);

    public final NumberPath<Long> songId = createNumber("songId", Long.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> track = createNumber("track", Long.class);

    public QSong(String variable) {
        this(Song.class, forVariable(variable), INITS);
    }

    public QSong(Path<? extends Song> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSong(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSong(PathMetadata metadata, PathInits inits) {
        this(Song.class, metadata, inits);
    }

    public QSong(Class<? extends Song> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.albumId = inits.isInitialized("albumId") ? new com.example.demo.album.domain.QAlbum(forProperty("albumId")) : null;
    }

}

