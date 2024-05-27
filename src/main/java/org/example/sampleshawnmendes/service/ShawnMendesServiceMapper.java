package org.example.sampleshawnmendes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.example.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyList;

@Component
@Log4j2
public class ShawnMendesServiceMapper {

    private final ObjectMapper objectMapper;

    public ShawnMendesServiceMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) {

        try {
            return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
        } catch (JsonProcessingException e) {
            log.error("ShawnMendesServiceMapper could not map json");
            return new SampleServerShawnMendesResponse("error", emptyList());
        }
    }
}
