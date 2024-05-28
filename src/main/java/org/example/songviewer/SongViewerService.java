package org.example.songviewer;

import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongViewerService {

    private final ItunesService itunesService;

    private final ShawnMendesService shawnMendesService;

    public SongViewerService(ItunesService itunesService, ShawnMendesService shawnMendesService) {
        this.itunesService = itunesService;
        this.shawnMendesService = shawnMendesService;
    }

    public List<Song> viewAllSongs() {
        List<Song> itunesResults = itunesService.fetchAllSongs();
        List<Song> songs = shawnMendesService.fetchAllSongs();
        List<Song> songsToView = new ArrayList<>();
        songsToView.addAll(itunesResults);
        songsToView.addAll(songs);
        return songsToView;
    }

}
