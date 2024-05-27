package org.example.itunes.proxy;

import java.util.List;

public record ItunesResponse(Integer resultCount, List<ItunesResult> results) {
}
