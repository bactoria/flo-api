package com.example.demo.album.infra;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.AlbumQueryRepository;
import com.example.demo.album.domain.dto.AlbumSearchRequestDto;
import com.example.demo.locale.Locale;
import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.album.domain.QAlbum.album;
import static com.example.demo.locale.QAlbumLocale.albumLocale;
import static com.example.demo.song.domain.QSong.song;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Repository
public class AlbumQueryRepositoryImpl extends QuerydslRepositorySupport implements AlbumQueryRepository {

    private final JPAQueryFactory queryFactory;

    public AlbumQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Album.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Album> findById(Long id) {

        Album fetchedData = queryFactory
                .selectFrom(album)
                .where(album.albumId.eq(id))
                .join(album.songs, song).fetchJoin()
                .fetchOne();
        return Optional.ofNullable(fetchedData);
    }

    @Override
    public List<AlbumSearchResponseDto> searchAlbumsWithLocale(AlbumSearchRequestDto albumSearchRequestDto) {
        final String SEARCH_DATA = albumSearchRequestDto.getSearchData();
        final Locale USER_LOCALE = albumSearchRequestDto.getUserLocale();

        List<Album> fetchedData = queryFactory
                .selectFrom(album)
                .join(album.locales, albumLocale).fetchJoin()
                .join(album.songs, song).fetchJoin()
                .where(album.title.contains(SEARCH_DATA))
                .where(eqLocale(USER_LOCALE))
                .fetch();

        return fetchedData.stream()
                .map(AlbumSearchResponseDto::new)
                .collect(Collectors.toList());
    }

    private BooleanExpression eqLocale(Locale locale) {
        if (locale == Locale.ALL) {
            return null;
        }
        return albumLocale.locale.eq(locale);
    }

}
