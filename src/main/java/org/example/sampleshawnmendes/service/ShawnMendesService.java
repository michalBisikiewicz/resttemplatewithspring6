package org.example.sampleshawnmendes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import org.example.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import org.springframework.stereotype.Service;

@Service
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

    public void testClient() throws JsonProcessingException {
        String postRequest = sampleShawnMendesServerClient.makePostRequest();
        if (postRequest != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(postRequest);
            System.out.println(sampleShawnMendesResponse);
        }
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
        sampleShawnMendesServerClient.makeDeleteRequest("0");
        String getJsonSampleShawnMendesServer2 = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleShawnMendesResponse);
        }
    }
}
