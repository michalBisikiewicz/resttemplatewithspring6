package org.example.itunes.proxy;

//@JsonIgnoreProperties(ignoreUnknown = true)
public record ItunesResult(String trackName,
                           String artistName) {
}
