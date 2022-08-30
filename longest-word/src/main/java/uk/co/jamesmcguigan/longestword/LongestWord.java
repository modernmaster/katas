package uk.co.jamesmcguigan.longestword;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class LongestWord {

    //or full set of lowercase letters
    private static final char[] WILDCARD_CHARACTERS = {'a', 'b', 'c', 'd'};

    private LongestWord() {
    }

    public static Set<String> calculate(String letters, Dictionary dict) {
        Set<String> permutations = permutation(letters);
        Set<String> matches = permutations.stream().filter(dict::contains).collect(Collectors.toSet());
        int length = matches.stream()
                .mapToInt(String::length)
                .reduce(Integer::max)
                .orElse(0);
        return matches.stream().filter(x -> x.length() == length).collect(Collectors.toSet());
    }

    public static Set<String> permutation(String str) {
        return permutation("", str);
    }

    private static Set<String> permutation(String prefix, String str) {
        Set<String> test = new HashSet<>();
        int n = str.length();
        if (!prefix.equals("")) {
            test.add(prefix);
        }
        for (int i = 0; i < n; i++) {
            String suffix = str.substring(0, i) + str.substring(i + 1, n);
            if (str.charAt(i) == '?') {
                for (char wildcardCharacter : WILDCARD_CHARACTERS) {
                    test.addAll(permutation(prefix + wildcardCharacter, suffix));
                }
            } else {
                test.addAll(permutation(prefix + str.charAt(i), suffix));
            }
        }
        return test;
    }

}
