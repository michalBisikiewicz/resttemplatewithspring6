package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.itunes.service.ItunesService;
import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.springframework.stereotype.Component;

@Component
public class MainApplicationRunner {
    private final ItunesService itunesService;
    private final ShawnMendesService shawnMendesService;

    //robimy tutaj wstrzykiwanie przez konstruktor, także adnotacja @Autowired nie jest potrzebna
    public MainApplicationRunner(ItunesService itunesService, ShawnMendesService shawnMendesService) {
        this.itunesService = itunesService;
        this.shawnMendesService = shawnMendesService;
    }

    public void run() throws JsonProcessingException {
         itunesService.fetchShawnMendesSongs();
         shawnMendesService.testClient();
     }
}
