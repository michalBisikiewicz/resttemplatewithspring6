package org.example.sampleshawnmendes.service;


import lombok.extern.log4j.Log4j2;
import org.example.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import org.example.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import org.springframework.stereotype.Service;

@Service
@Log4j2
//adnotacja @Component lub Service rejestruje Beana i pózniej klasa oznaczona adnotacją @ComponentScan jest w stanie
//znaleźć takiego Beana
//aby zrobiuć ręczny wiring wygaszamy adnotację @Service i tworzymy nowa klase konfiguracyjna i ręczne tworzymy beany
public class ShawnMendesService {

    private final SampleShawnMendesServerProxy sampleShawnMendesServerClient;
    private final ShawnMendesServiceMapper shawnMendesServiceMapper;

    //    @Autowired
    //nie używamy tutaj @Autowired - czyli że kontakst sam szuka Beanów - zostanie to automatycznie wstrzykniętę od chyba
    //8 wersji Springa
    public ShawnMendesService(SampleShawnMendesServerProxy sampleShawnMendesServerClient, ShawnMendesServiceMapper shawnMendesServiceMapper) {
        this.sampleShawnMendesServerClient = sampleShawnMendesServerClient;
        this.shawnMendesServiceMapper = shawnMendesServiceMapper;
    }

    public String fetchAllShawnMendesSongs() {
        String jsonSongs = sampleShawnMendesServerClient.makeGetRequest();
        if (jsonSongs == null) {
            log.error("jsonSongs was null");
            return "";
        }
        SampleServerShawnMendesResponse sampleServerShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(jsonSongs);
        log.info("SampleMendesService fetched: " + sampleServerShawnMendesResponse);
        return sampleServerShawnMendesResponse.message();
    }
}
