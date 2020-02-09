package com.example.demo.appRunner.dbInit;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.AlbumRepository;
import com.example.demo.locale.AlbumLocale;
import com.example.demo.locale.AlbumLocaleRepository;
import com.example.demo.locale.Locale;
import com.example.demo.song.domain.Song;
import com.example.demo.song.domain.SongRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final AlbumLocaleRepository albumLocaleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArr = (JSONArray) jsonParse.parse(new InputStreamReader(getClass().getResourceAsStream("/albums.json")));

        for(Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;

            Album album = Album.builder()
                    .title(title(jsonObj))
                    .build();
            albumRepository.saveAndFlush(album);

            List<Song> songs = songs(album, jsonObj);
            songs.forEach(songRepository::save);

            List<Locale> locales = locales(jsonObj);
            locales.stream().map(locale->AlbumLocale.builder().locale(locale).album(album).build()).forEach(albumLocaleRepository::save);
        }

    }

    private List<Song> songs(Album album, JSONObject jsonObj) {
        JSONArray jsonArr = (JSONArray) jsonObj.get("songs");
        List<Song> songs = new ArrayList<>();

        for(Object obj : jsonArr) {
            JSONObject songJsonObj = (JSONObject) obj;
            songs.add(Song.builder()
                    .length((Long)songJsonObj.get("length"))
                    .title((String)songJsonObj.get("title"))
                    .track((Long)songJsonObj.get("track"))
                    .albumId(album)
                    .build());
        }

        return songs;
    }

    private List<Locale> locales(JSONObject jsonObj) {
        JSONArray jsonArr = (JSONArray) jsonObj.get("locales");
        return (List<Locale>) jsonArr.stream()
                .map(l->Locale.findLocale((String)l))
                .collect(Collectors.toList());
    }

    private String title(JSONObject jsonObj) {
        return (String) jsonObj.get("album_title");
    }


}
