package com.example.demo.search.ui.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Setter
@Getter
@NoArgsConstructor
@ToString
public class SearchAlbumsAndSongsRequestDto {
    private String title;
    private String locale;
}
