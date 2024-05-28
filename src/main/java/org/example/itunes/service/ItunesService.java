package org.example.itunes.service;


import lombok.extern.log4j.Log4j2;
import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.proxy.ItunesResponse;
import org.example.itunes.proxy.ItunesResult;
import org.example.songviewer.Song;
import org.example.songviewer.SongFetchable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ItunesService implements SongFetchable {

    private final ItunesProxy itunesClient;
    private final ItunesMapper itunesMapper;

    public ItunesService(ItunesProxy itunesClient, ItunesMapper itunesMapper) {
        this.itunesClient = itunesClient;
        this.itunesMapper = itunesMapper;
    }

    @Override
    public List<Song> fetchAllSongs() {
        List<ItunesResult> itunesResults = fetchShawnMendesSongsFromItunes();
        // stream działa podobnie do forEach
        return itunesResults.stream()
                .map(itunesResult -> new Song(itunesResult.trackName()))
                .collect(Collectors.toList());
    }

    private List<ItunesResult> fetchShawnMendesSongsFromItunes() {
        String json = itunesClient.makeGetRequest("shawnmendes", 3);
        if (json == null) {
            log.error("jsonSogns was null");
            return Collections.emptyList();
        }
        ItunesResponse shawnMendesResponse = itunesMapper.mapJsonItunesResponse(json);
        log.info("ItunesService fetched: " + shawnMendesResponse);
        return shawnMendesResponse.results();
    }



}
