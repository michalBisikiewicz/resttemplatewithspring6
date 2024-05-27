package org.example.itunes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Service;

@Service
public class ItunesService {

    private final ItunesProxy itunesClient;
    private final ItunesMapper itunesMapper;

    public ItunesService(ItunesProxy itunesClient, ItunesMapper itunesMapper) {
        this.itunesClient = itunesClient;
        this.itunesMapper = itunesMapper;
    }

    public void fetchShawnMendesSongs() throws JsonProcessingException {
        String json = itunesClient.makeGetRequest("shawnmendes", 3);
        if (json != null) {
            ItunesResponse shawnMendesResponse = itunesMapper.mapJsonItunesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }


}
