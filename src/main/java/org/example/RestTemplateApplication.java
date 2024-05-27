package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
//adnotacja @ComponentScan przy uruchomieniu apki przeszukuje wszystkie pliki pod kątem adnotacji i tworzy np. w
//miejscu @Component Beana , którego może pózniej wstrzyknąć
public class RestTemplateApplication {

    //    @Autowired
//    MainApplicationRunner mainApplicationRunner;
    public static void main(String[] args) throws JsonProcessingException {
        //stworzy się tutaj Spring Container na bazie określonej klasy RestTemplateApplication.class w parametrze
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                RestTemplateApplication.class);
        //funkcją getBean pobieramy beana, ktory został zarejestrowany i wywołujemy metodę testClient
//        ShawnMendesService shawnMendesService = annotationConfigApplicationContext.getBean(ShawnMendesService.class);
//        shawnMendesService.testClient();

//        ItunesProxy itunesProxy = annotationConfigApplicationContext.getBean(ItunesProxy.class);
//        System.out.println(itunesProxy.makeGetRequest("shawnmendes", 2));

        MainApplicationRunner mainApplicationRunner = annotationConfigApplicationContext.getBean(
                MainApplicationRunner.class);
        mainApplicationRunner.run();


    }
}