package org.example.songviewer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongViewerService {

    //dzięki List<SongFetchable> będzie wstrzykiwana cała lista serwisów używająca tego Interfejsu
    private final List<SongFetchable> songFetchable;

    public SongViewerService(List<SongFetchable> songFetchable) {
        this.songFetchable = songFetchable;
    }

    public List<Song> viewAllSongs() {
        List<Song> songsToView = new ArrayList<>();
        songFetchable.forEach(
                songService -> songsToView.addAll(songService.fetchAllSongs())
        );
        return songsToView;
    }

}
