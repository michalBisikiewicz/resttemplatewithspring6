package org.example.sampleshawnmendes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import org.springframework.stereotype.Component;

@Component
public class ShawnMendesServiceMapper {

    SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
//        System.out.println("mapJsonToSampleShawnMendesResponse");
//        return new SampleServerShawnMendesResponse("1", List.of());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
