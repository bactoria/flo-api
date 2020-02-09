package com.example.demo.song.domain.dto;

import com.example.demo.locale.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongSearchRequestDto {
    private String searchData;
    private Locale userLocale;
}
