package com.example.demo.album.ui;

import com.example.demo.album.domain.AlbumQueryRepository;
import com.example.demo.album.domain.AlbumRepository;
import com.example.demo.album.domain.Album;
import com.example.demo.album.ui._dto.AlbumResponseDto;
import com.example.demo.album.ui._dto.AlbumSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Bactoria
 * @since 2020-02-08 [2020.2월.08]
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/albums")
public class AlbumRestController {

    private final AlbumRepository albumRepository;
    private final AlbumQueryRepository albumQueryRepository;

    @GetMapping
    public ResponseEntity<List<Album>> all() {
        return ResponseEntity.ok().body(albumRepository.findAll());
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<AlbumResponseDto> byId(@PathVariable Long albumId) {
        log.info("GET :: /albums/{}", albumId);

        Album album = albumQueryRepository.findById(albumId)
                            .orElseThrow(EntityNotFoundException::new);
        AlbumResponseDto body = new AlbumResponseDto(album);
        return ResponseEntity.ok().body(body);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AlbumSaveRequestDto requestDto) {
        log.info("POST :: /albums :: {}", requestDto);
        Album album = requestDto.toEntity();
        Album savedAlbum = albumRepository.save(album);

        URI createdAlbumUri = linkTo(AlbumRestController.class).slash(savedAlbum.getAlbumId()).toUri();
        return ResponseEntity.created(createdAlbumUri).build();
    }

}
