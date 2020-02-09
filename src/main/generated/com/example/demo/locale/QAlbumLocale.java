package com.example.demo.locale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbumLocale is a Querydsl query type for AlbumLocale
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbumLocale extends EntityPathBase<AlbumLocale> {

    private static final long serialVersionUID = 1238188271L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlbumLocale albumLocale = new QAlbumLocale("albumLocale");

    public final com.example.demo.album.domain.QAlbum album;

    public final EnumPath<Locale> locale = createEnum("locale", Locale.class);

    public QAlbumLocale(String variable) {
        this(AlbumLocale.class, forVariable(variable), INITS);
    }

    public QAlbumLocale(Path<? extends AlbumLocale> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlbumLocale(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlbumLocale(PathMetadata metadata, PathInits inits) {
        this(AlbumLocale.class, metadata, inits);
    }

    public QAlbumLocale(Class<? extends AlbumLocale> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new com.example.demo.album.domain.QAlbum(forProperty("album")) : null;
    }

}

