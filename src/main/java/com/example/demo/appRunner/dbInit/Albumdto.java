package com.example.demo.appRunner.dbInit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Bactoria
 * @since 2020-02-09 [2020.2월.09]
 */

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Albumdto {

    private String album_title;
    private List<String> locales;
    private List<Songdto> songs;

    @Getter @Setter
    static class Songdto {
        private String length;
        private String title;
        private String track;
    }

}
