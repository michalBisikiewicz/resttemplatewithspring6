package org.example.itunes.service;

import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItunesMapper {

    ItunesResponse mapJsonItunesResponse(String json) {
        return new ItunesResponse(0, List.of());
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(json, ItunesResponse.class);
    }
}
