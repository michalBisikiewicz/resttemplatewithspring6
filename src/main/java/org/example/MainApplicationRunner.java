package org.example;

import lombok.extern.log4j.Log4j2;
import org.example.songviewer.Song;
import org.example.songviewer.SongViewerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class MainApplicationRunner {
    private final SongViewerService songViewerService;

    public MainApplicationRunner(SongViewerService songViewerService) {
        this.songViewerService = songViewerService;
    }

    public void run() {
        List<Song> songs = songViewerService.viewAllSongs();
        log.info(songs);
     }
}
