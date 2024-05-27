package org.example.itunes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.example.itunes.proxy.ItunesResponse;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyList;

@Component
@Log4j2
public class ItunesMapper {

    private final ObjectMapper objectMapper;

    public ItunesMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    ItunesResponse mapJsonItunesResponse(String json) {
        try {
            return objectMapper.readValue(json, ItunesResponse.class);
        } catch (JsonProcessingException e) {
            log.error("ItunesMapper could not map json");
            return new ItunesResponse(0, emptyList());
        }
    }
}
