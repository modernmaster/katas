package uk.co.jamesmcguigan.dictionary.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import uk.co.jamesmcguigan.dictionary.service.Dictionary;
import uk.co.jamesmcguigan.dictionary.service.StringFormat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class DictionaryRunner implements CommandLineRunner {

    private static final String CLASSPATH_INPUT_TXT = "classpath:input.txt";
    private static final String SIZE_OF_COLLECTION_IS = "Size of collection is {}";
    private static final String UNABLE_TO_LOADFILE = "Unable to loadfile";
    private final Dictionary sageDictionary;
    private final StringFormat formatService;

    @Override
    public void run(String... args) throws Exception {
        File file = ResourceUtils.getFile(CLASSPATH_INPUT_TXT);
        if (file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                while (line != null) {
                    sageDictionary.add(formatService.toTitleCase(line));
                    line = bufferedReader.readLine();
                }
                log.info(SIZE_OF_COLLECTION_IS, sageDictionary.size());
                sageDictionary.print();
            } catch (IOException e) {
                log.error(UNABLE_TO_LOADFILE, e);
            }
        }

    }
}
