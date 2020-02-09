package com.example.demo.album.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

// TODO :: 아.. album 저장할 때 사용하는 request에서 locale을 0으로 해도 KR로 받을 수 있음.. 못받게 수정 필요.
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Locale {
    ALL("all"), // 모든 국가에서 제공 가능한 앨범
    KO("ko"),
    EN("en"),
    JA("ja");

    @JsonValue
    private final String value;

    @JsonCreator
    private Locale(String value) {
        this.value = value;
    }

    public static Locale findLocale(String value) {
        return Arrays.stream(Locale.values())
                .filter(locale -> locale.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력 값 :: " + value));
    }
}
