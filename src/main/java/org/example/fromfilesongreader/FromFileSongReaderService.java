package org.example.fromfilesongreader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.example.songviewer.Song;
import org.example.songviewer.SongFetchable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class FromFileSongReaderService implements SongFetchable {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public FromFileSongReaderService(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Song> fetchAllSongs() {
        Resource resource = resourceLoader.getResource("classpath:songs.json");
        try {
            File file = resource.
                    getFile();
            FileSongWrapper fileSongWrapper = objectMapper.readValue(file, FileSongWrapper.class);
            return fileSongWrapper.songs()
                    .stream()
                    .map(fileSong -> new Song(fileSong.trackName()))
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            log.error("could not map json" + e.getMessage());
        } catch (IOException e) {
            log.error("songs.json error" + e.getMessage());
        }
        return Collections.emptyList();
    }
}
