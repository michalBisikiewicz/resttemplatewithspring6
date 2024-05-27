package org.example;


import org.example.sampleshawnmendes.service.ShawnMendesService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@ComponentScan
//adnotacja @ComponentScan przy uruchomieniu apki przeszukuje wszystkie pliki pod kątem adnotacji i tworzy np. w
//miejscu @Component Beana , którego może pózniej wstrzyknąć
public class RestTemplateApplication {

//    @Autowired
//    MainApplicationRunner mainApplicationRunner;
    public static void main(String[] args) {
        //stworzy się tutaj Spring Container na bazie określonej klasy RestTemplateApplication.class w parametrze
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                RestTemplateApplication.class);
        //funkcją getBean pobieramy beana i wywołujemy metodę testClient
//        ShawnMendesService shawnMendesService = annotationConfigApplicationContext.getBean(ShawnMendesService.class);
//        shawnMendesService.testClient();

        // wyświetlanie Beanów
        List<String> singletonNames = Arrays.asList(annotationConfigApplicationContext.getDefaultListableBeanFactory()
                .getSingletonNames());
        singletonNames.forEach(
                        System.out::println
        );
        ShawnMendesService shawnMendesService = annotationConfigApplicationContext.getBean(ShawnMendesService.class);
        shawnMendesService.testClient();


//        mainApplicationRunner.run();

//        MainApplicationRunner mainApplicationRunner = new MainApplicationRunner(
//                // wstrzykiwanie przez konstuktor. Alternatywenie można wstrzykiwać przez settery lub przez pole
//                // czyli przez zmienna. Dokładnie tego używa spring tylko robi to ukrycie przez adnotację
//                new ItunesService(
//                        new ItunesProxy(),
//                        new ItunesMapper()
//                ),
//                new ShawnMendesService(
//                        new SampleShawnMendesServerProxy(),
//                        new ShawnMendesServiceMapper()
//                )
//        );
//        mainApplicationRunner.run();
    }
}