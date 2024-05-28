package org.example.songviewer;

import org.example.itunes.proxy.ItunesResult;
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
        List<Song> songsToView = new ArrayList<>();
        List<ItunesResult> itunesResults = itunesService.fetchShawnMendesSongs();
        String songs = shawnMendesService.fetchAllShawnMendesSongsFromLocalHost();

        itunesResults.forEach(
                itunesResult -> songsToView.add(new Song(itunesResult.trackName()))
        );
        //na razie traktujemy songs jako pojedyńczego stringa
        songsToView.add(new Song(songs));

        return songsToView;
    }

}
