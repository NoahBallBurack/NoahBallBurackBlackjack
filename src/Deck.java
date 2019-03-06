import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    String[] names={"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    int[] numbers={2,3,4,5,6,7,8,9,10,10,10,10,11};

    ArrayList<Card> cards=new ArrayList<>();

    public Deck(){
        for(int i=0; i<13;i++){
            for(int j=0;j<4;j++) {
                Card c = new Card(names[i], numbers[i]);
                cards.add(c);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
