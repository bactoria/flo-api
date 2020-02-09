package com.example.demo.album.ui._dto;

import com.example.demo.album.domain.Album;
import com.example.demo.album.domain.Locale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@Getter
@ToString
@NoArgsConstructor
public class SaveAlbumRequestDto {
    private String title;
    private List<Locale> locales = new ArrayList<>();

    public Album toEntity() {
        return Album.builder()
                .title(title)
                .locales(locales)
                .build();
    }

}
