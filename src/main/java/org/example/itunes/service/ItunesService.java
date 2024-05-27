package org.example.itunes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ItunesService {

    private final ItunesProxy itunesClient;
    private final ItunesMapper itunesMapper;

    public ItunesService(ItunesProxy itunesClient, ItunesMapper itunesMapper) {
        this.itunesClient = itunesClient;
        this.itunesMapper = itunesMapper;
    }

    public void fetchShawnMendesSongs() {
        String json = itunesClient.makeGetRequest("shawnmendes", 3);
        if (json != null) {
            ItunesResponse shawnMendesResponse = itunesMapper.mapJsonItunesResponse(json);
            log.info(shawnMendesResponse);
        }
    }


}
