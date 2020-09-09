package pokergame;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Player {

    private List<Card> dealCards;

    public void sortDealCards() {
        Collections.sort(dealCards);
    }
}
