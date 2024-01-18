package uk.co.jamesmcguigan.dictionary.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class SageDictionary implements Dictionary {
    private static final String WORD_ADDED = "Word {} added";
    private final static TreeMap<String, Integer> words = new TreeMap<>();
    private static final String OUTPUT_FORMAT = "{}{}{}";
    private final Padding paddingService;

    public void add(String value) {
        Integer counter = words.get(value);
        if (counter == null) {
            counter = 0;
        }
        words.put(value, ++counter);
        log.trace(WORD_ADDED, value);
    }

    public int size() {
        return words.size();
    }

    public void print() {
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            String padding = paddingService.calculate(key, value);
            log.info(OUTPUT_FORMAT, key, padding, value);
        }
    }
}
