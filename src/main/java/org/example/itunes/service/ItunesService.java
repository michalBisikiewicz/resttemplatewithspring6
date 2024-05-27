package org.example.itunes.service;


import org.example.itunes.proxy.ItunesProxy;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Service;

@Service
public class ItunesService {

    ItunesProxy itunesClient;
    ItunesMapper itunesMapper;

    public ItunesService(ItunesProxy itunesClient, ItunesMapper itunesMapper) {
        this.itunesClient = itunesClient;
        this.itunesMapper = itunesMapper;
    }

    public void fetchShawnMendesSongs()  {
        String json = itunesClient.makeGetRequest("shawnmendes", 1);
        if (json != null) {
            ItunesResponse shawnMendesResponse = itunesMapper.mapJsonItunesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }


}
