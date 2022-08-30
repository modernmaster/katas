package uk.co.jamesmcguigan.longestword;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestWordTests {

    @Test
    public void testLongestWordForDictionarySizeOne() {
        Dictionary dict = new Dictionary(new String[]{"toes"});
        Set<String> expected = new HashSet<>(List.of("toes"));
        assertEquals(expected, LongestWord.calculate("toes", dict));
    }

    @Test
    public void testLongestWordForDictionarySizeTwo() {
        Dictionary dict = new Dictionary(new String[]{"toes", "to"});
        Set<String> expected = new HashSet<>(List.of("toes"));
        assertEquals(expected, LongestWord.calculate("toes", dict));
    }

    @Test
    public void testLongestWordForDictionarySizeThreeWithAWordThatIsASubsetOfAnother() {
        Dictionary dict = new Dictionary(new String[]{"toes", "to", "toess"});
        Set<String> expected = new HashSet<>(List.of("toes"));
        assertEquals(expected, LongestWord.calculate("toes", dict));
    }

    @Test
    public void testLongestWordForDictionarySizeNineWithAWordThatIsASubsetOfAnother() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
        Set<String> expected = new HashSet<>(List.of("toe"));
        assertEquals(expected, LongestWord.calculate("toe", dict));
    }

    @Test
    public void testLongestWordForDictionarySizeNineThatMatchesTwoEntries() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
        Set<String> expected = new HashSet<>(List.of("toes", "dogs"));
        assertEquals(expected, LongestWord.calculate("osetdg", dict));
    }

}
