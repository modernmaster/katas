package uk.co.jamesmcguigan.dictionary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DictionaryApplication {
    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(DictionaryApplication.class, args);
        log.info("APPLICATION FINISHED");
    }
}
