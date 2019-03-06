public class Runner {

    public static void main(String[] args){
        boolean playerDone=false;
        boolean dealerDone=false;
        Game g= new Game();
        g.dealInitialCardsPlayer();
        playerDone=!g.keepGoingPlayer();
        while(!playerDone){
            if(g.hasNotBustedPlayer()){
                g.dealNewCardPlayer();
                if(!g.hasNotBustedPlayer()){
                    g.bustedPlayer();
                    playerDone=true;
                }
            }else{
                g.bustedPlayer();
                playerDone=true;
            }
            if(!playerDone){
                playerDone=!g.keepGoingPlayer();
            }
        }
        if(g.hasNotBustedPlayer()){
            System.out.println("Your score: "+ g.playerScore);
            g.dealInitialCardsDealer();
            dealerDone=!g.keepGoingDealer();
            while(!dealerDone){
                if(g.hasNotBustedDealer()){
                    System.out.println("Dealer hits");
                    g.dealNewCardDealer();
                    if(!g.hasNotBustedDealer()){
                        g.bustedDealer();
                        dealerDone=true;
                    }
                }else{
                    g.bustedDealer();
                    dealerDone=true;
                }
                if(!dealerDone){
                    dealerDone=!g.keepGoingDealer();
                }
            }
            if(g.hasNotBustedDealer()){
                System.out.println("Dealer stands");
                System.out.println("Dealer score: "+ g.dealerScore);
                if(g.dealerScore>g.playerScore){
                    System.out.println("Dealer wins");
                }
                if(g.dealerScore<g.playerScore){
                    System.out.println("You win");
                }
                if(g.dealerScore==g.playerScore){
                    System.out.println("You tied the dealer");
                }
            }
        }

    }

}
