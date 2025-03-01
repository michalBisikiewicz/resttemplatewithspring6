package org.example.sampleshawnmendes.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
public class SampleShawnMendesServerProxy {

    private final RestTemplate restTemplate;

    @Value("${sample-shawn-mendes-server.service.url}")
    String url;

    @Value("${sample-shawn-mendes-server.service.port}")
    int port;

    public SampleShawnMendesServerProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String makePostRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", "headerValuePost");
        SampleShawnMendesRequest requestBody = new SampleShawnMendesRequest("Another Day");
        HttpEntity<SampleShawnMendesRequest> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            log.error(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

    public String makeGetRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", "headerValueGet");
        SampleShawnMendesRequest requestBody = new SampleShawnMendesRequest("Stitches");
        HttpEntity<SampleShawnMendesRequest> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            log.error(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

    public String makeDeleteRequest(String id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs")
                .queryParam("id", id);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.DELETE,
                    null,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            log.error(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

}