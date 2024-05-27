package org.example;

import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.springframework.stereotype.Component;

@Component
public class MainApplicationRunner {
    ItunesService itunesService;
    ShawnMendesService shawnMendesService;

    public MainApplicationRunner(ItunesService itunesService, ShawnMendesService shawnMendesService) {
        this.itunesService = itunesService;
        this.shawnMendesService = shawnMendesService;
    }

    public void run() {
         itunesService.fetchShawnMendesSongs();
//         shawnMendesService.testClient();
     }
}
