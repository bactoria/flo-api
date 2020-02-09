package com.example.demo.album.application.dto;

import com.example.demo.locale.Locale;
import lombok.*;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlbumSearchRequestDto {
    private String searchData;
    private Locale userLocale;
}
