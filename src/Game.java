import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Deck deck = new Deck();
    int num=2;
    int playerScore;
    int dealerScore;

    public Game(){
        deck.shuffle();
    }

    public void dealInitialCardsPlayer(){
        System.out.println("You drew: "+deck.cards.get(0).name +", "+deck.cards.get(1).name);
        playerScore+=(deck.cards.get(0).number +deck.cards.get(1).number);
    }

    public void dealInitialCardsDealer(){
        System.out.println("Dealer drew: "+deck.cards.get(num).name +", "+deck.cards.get(num+1).name);
        dealerScore+=(deck.cards.get(num).number +deck.cards.get(num+1).number);
        num+=2;
    }

    public boolean keepGoingPlayer(){
        String choice=scanWord();
        if(choice.equals("hit")){
            return true;
        }
        return false;
    }

    public boolean keepGoingDealer(){
        if(dealerScore<17){
            return true;
        }
        return false;
    }

    public void dealNewCardPlayer(){
        System.out.println("You drew: "+deck.cards.get(num).name);
        playerScore+=deck.cards.get(num).number;
        num++;
    }

    public void dealNewCardDealer(){
        System.out.println("Dealer drew: "+deck.cards.get(num).name);
        dealerScore+=deck.cards.get(num).number;
        num++;
    }

    public String scanWord(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please type 'hit' or 'stand'");
        String letter=scanner.next();
        return letter;
    }

    public boolean hasNotBustedPlayer(){
        if(playerScore>21){
            return false;
        }
        return true;
    }

    public boolean hasNotBustedDealer(){
        if(dealerScore>21){
            return false;
        }
        return true;
    }

    public void bustedPlayer(){
        System.out.println("You busted!");
    }
    public void bustedDealer(){
        System.out.println("Dealer busted");
        System.out.println("You win");
    }
}
