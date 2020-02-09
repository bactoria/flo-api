package com.example.demo.album.infra;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.AlbumQueryRepository;
import com.example.demo.album.domain.dto.AlbumSearchRequestDto;
import com.example.demo.locale.Locale;
import com.example.demo.album.domain.dto.AlbumSearchResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.album.domain.QAlbum.album;
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

/* select 문 3번 날림.
GET :: /albums/1
Hibernate: select album0_.album_id as album_id1_0_0_, album0_.title as title2_0_0_ from album album0_ where album0_.album_id=?
Hibernate: select songids0_.song_id as song_id1_2_0_, songids0_.song_id as song_id1_2_1_, songids0_.album_id as album_id5_2_1_, songids0_.length as length2_2_1_, songids0_.title as title3_2_1_, songids0_.track as track4_2_1_ from song songids0_ where songids0_.song_id=?
Hibernate: select locales0_.album_id as album_id1_1_0_, locales0_.locale as locale2_1_0_ from locales locales0_ where locales0_.album_id=?

    @Override
    public Optional<Album> findById(Long id) {
        Album fetchedData = queryFactory
                        .selectFrom(album)
                        .where(album.albumId.eq(id))
                        .fetchOne();

        return Optional.ofNullable(fetchedData);
    }
*/

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
                .join(album.songs, song).fetchJoin()
                .where(album.title.contains(SEARCH_DATA))
                .fetch();

        return fetchedData.stream()
                .map(AlbumSearchResponseDto::new)
                .collect(Collectors.toList());
    }

}
