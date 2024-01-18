package uk.co.jamesmcguigan.dictionary.service;

import org.springframework.stereotype.Component;

@Component
class Padding {
    public static final String SPACE = " ";
    private static final Integer LINE_LENGTH = 20;

    public String calculate(String value, Integer counter) {
        int length = LINE_LENGTH - value.length() - counter.toString().length();
        return SPACE.repeat(Math.max(0, length));
    }
}
