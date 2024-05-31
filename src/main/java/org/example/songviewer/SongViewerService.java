package org.example.songviewer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongViewerService {

    //dzięki List<SongFetchable> będzie wstrzykiwana cała lista serwisów używająca tego Interfejsu
    private final List<SongFetchable> services;

    public SongViewerService(List<SongFetchable> services) {
        this.services = services;
    }

    public List<Song> viewAllSongs() {
        List<Song> songsToView = new ArrayList<>();
        services.forEach(
                service -> songsToView.addAll(service.fetchAllSongs())
        );
        return songsToView;
    }

}
