package uk.co.jamesmcguigan.longestword;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public class Dictionary {
    private final String[] entries;

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}
