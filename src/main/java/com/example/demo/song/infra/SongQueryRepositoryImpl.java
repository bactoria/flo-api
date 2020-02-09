package com.example.demo.song.infra;

import com.example.demo.locale.Locale;
import com.example.demo.song.domain.Song;
import com.example.demo.song.domain.SongQueryRepository;
import com.example.demo.song.domain.dto.SongSearchResponseDto;
import com.example.demo.song.domain.dto.SongSearchRequestDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        return queryFactory
                .from(song)
                .select(Projections.constructor(SongSearchResponseDto.class, song.title, song.songId, song.track, song.length))
                .where(song.title.contains(SEARCH_DATA))
                .fetch();
    }
}
