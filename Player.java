import java.util.ArrayList;
import java.lang.Integer;
public class Player {
	
		
	private ArrayList<Card> hand; //the player's cards
	private double bankroll;
    private double bet;

	//you may choose to use more instance variables
		
	public Player(){		
	    //create a player here
        bankroll = 0;
        hand = new ArrayList<Card>();
	}

	public void addCard(Card c){
     
	    //add the card c to the player's hand
        hand.add(c);
        bankroll++;
	}

	public void removeCard(Card c){
	    //remove the card c from the player's hand
        if (bankroll > 0) hand.remove(c); bankroll--;
        }
		
        public void bets(double amt){
            //player makes a bet
             bankroll = amt;
        }

        public void winnings(double odds){
            //adjust bankroll if player wins
            bankroll += odds;
        }

        public double getBankroll(){
            //return current balance of bankroll
            return bankroll;
        }

        //you may wish to use more methods here
        public ArrayList<Card> getHand()
        {
        return hand;
        }
}
