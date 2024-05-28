package org.example.itunes.service;


import lombok.extern.log4j.Log4j2;
import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.proxy.ItunesResponse;
import org.example.itunes.proxy.ItunesResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class ItunesService {

    private final ItunesProxy itunesClient;
    private final ItunesMapper itunesMapper;

    public ItunesService(ItunesProxy itunesClient, ItunesMapper itunesMapper) {
        this.itunesClient = itunesClient;
        this.itunesMapper = itunesMapper;
    }

    public List<ItunesResult> fetchShawnMendesSongs() {
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
