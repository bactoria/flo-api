package com.example.demo.album.ui._dto;

import com.example.demo.album.domain.Album;
import com.example.demo.locale.AlbumLocale;
import com.example.demo.locale.Locale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@Getter
@ToString
@NoArgsConstructor
public class AlbumSaveRequestDto {
    private String title;
    private List<Locale> locales = new ArrayList<>();

    public Album toEntity() {
        return Album.builder()
                .title(title)
                .locales(locales.stream().map(locale->AlbumLocale.builder().locale(locale).build()).collect(Collectors.toSet()))
                .build();
    }

}
