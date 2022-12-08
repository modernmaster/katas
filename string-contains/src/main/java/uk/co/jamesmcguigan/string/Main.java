package uk.co.jamesmcguigan.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String TWO_WORDS_HAVE_NOT_BEEN_ENTERED = "Two words have not been entered";
    private static final String EMPTY_STRING = " ";
    private static final String ARGUMENT_TO_TOO_LONG = "Argument to too long";
    private static final String CHARACTER_IS_NOT_LOWERCASE = "Character is not lowercase";
    private static final String N_IS_BEYOND_BOUNDARIES = "N is beyond boundaries";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        if(lines > 100 || lines < 0) {
            throw new IllegalArgumentException(N_IS_BEYOND_BOUNDARIES);
        };
        List<Response> responses = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String input = br.readLine();
            String[] words = input.split(EMPTY_STRING);
            if (words.length != 2) {
                throw new IllegalArgumentException(TWO_WORDS_HAVE_NOT_BEEN_ENTERED);
            }
            responses.add(contains(words[0], words[1]));
        }
        responses.forEach(System.out::println);
    }

    private static Response contains(String value1, String value2) {
        char[] value1Array = value1.toCharArray();
        if(value1.length() > 100 || value2.length()>100) {
            throw new IllegalArgumentException(ARGUMENT_TO_TOO_LONG);
        };
        List<String> values2List = value2.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
        for (char c : value1Array) {
            if(!Character.isLowerCase(c)) {
                throw new IllegalArgumentException(CHARACTER_IS_NOT_LOWERCASE);
            };
            if (!values2List.remove(String.valueOf(c))) {
                return Response.NO;
            }
        }
        return Response.YES;
    }

    enum Response {
        NO, YES;
    }

}