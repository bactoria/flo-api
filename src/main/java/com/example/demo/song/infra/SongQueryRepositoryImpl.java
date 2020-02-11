package com.example.demo.song.infra;

import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import com.example.demo.locale.Locale;
import com.example.demo.song.domain.Song;
import com.example.demo.song.domain.SongQueryRepository;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import com.example.demo.song.domain.dto.SongSearchRequestDto;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.album.domain.QAlbum.album;
import static com.example.demo.locale.QAlbumLocale.albumLocale;
import static com.example.demo.song.domain.QSong.song;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Repository
public class SongQueryRepositoryImpl extends QuerydslRepositorySupport implements SongQueryRepository {

    private final JPAQueryFactory queryFactory;

    public SongQueryRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Song.class);
        this.queryFactory = queryFactory;
    }

    public List<SongSearchResponseDto> searchSongs(SongSearchRequestDto songSearchRequestDto) {
        final String SEARCH_DATA = songSearchRequestDto.getSearchData();
        final Locale USER_LOCALE = songSearchRequestDto.getUserLocale();

        List<Song> fetchedData = queryFactory
                .selectFrom(song)
                .join(song.albumId, album).fetchJoin()
                .join(album.locales, albumLocale).fetchJoin()
                .where(song.title.contains(SEARCH_DATA))
                .where(eqLocale(USER_LOCALE))
                .fetch();

        return fetchedData.stream()
                .map(SongSearchResponseDto::new)
                .collect(Collectors.toList());
    }

    private BooleanExpression eqLocale(final Locale locale) {
        if (locale == Locale.ALL) {
            return null;
        }
        return albumLocale.locale.eq(locale);
    }
}
