package uk.co.jamesmcguigan.checkout;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Bookstore {

  public Double buyBooks(List<String> books) {
    Set<String> uniqueBooks = Sets.newHashSet(books);
    int diff = books.size() - uniqueBooks.size();

    if (uniqueBooks.size() == 1) {
      return 8.0 + (diff * 8);
    } else if (uniqueBooks.size() == 2) {
      return 15.20 + (diff * 8);
    } else if (uniqueBooks.size() == 3) {
      return 21.60 + (diff * 8);
    } else if (uniqueBooks.size() == 4) {
      return 25.6 + (diff * 8);
    } else {
      return 32.0 + (diff * 8);
    }
  }
}
