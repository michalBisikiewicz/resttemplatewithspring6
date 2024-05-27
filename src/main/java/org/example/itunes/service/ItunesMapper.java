package org.example.itunes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Component;

@Component
public class ItunesMapper {

    ItunesResponse mapJsonItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ItunesResponse.class);
    }
}
