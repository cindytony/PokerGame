import java.lang.Integer;
import java.util.ArrayList;
import java.util.*;

public class Game {
	
	private Player p;
	private Deck cards;
	// you'll probably need some more here
	public ArrayList<Card> hand;
	
	public Game(String[] testHand){
        p = new Player();
        cards = new Deck();
        cards.shuffle();
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		// 
		// you need to figure out what card to instantiate and then add it to the player 
		// hand using p.addHand(Card(testHand[i]))
		
        //p.remove(p.getHand());
        //p.addHand(Card(testHand[0]));
        handOfCards(testHand);
        hand = new ArrayList<Card>(p.getHand());
        System.out.println(checkHand(hand));
		
	}
	
    
	public Game(){
		p = new Player();                                     // First, we initialize variables of the class
        cards = new Deck();
        cards.shuffle();
        for (int i = 1; i < 6; i++)  p.addCard(cards.deal());
        hand = new ArrayList<Card>(p.getHand());
        
        // This no-argument constructor is to actually play a normal game
		
	}
	
    
	public void play(){
        
        // this method should play the game	
         
        
        /* 0. shuffle cards - 
         * 1. computer deals 5 cards
         * 5 times:
         *  deal a single card - how? - cards.deal() gives me a card
         *  add it to the players hand  p.addCard( put that card here)
         * 
         * 2. player chooses which cards to replace
         *   solicit input from the user. which cards to keep
         * 
         * 
         * 
         * 
         * 3. computer replaces specified cards
         *   use the remove and add methods on p to do this
         * 
         * 
         * 4. computer declares the hand type
         *   *this is the bison
         * 
         *    a) evaluate the hand -- so call checkHand
         * 
         * how do we access the hand?  checkhand(p.getHand())
         * 
         * 5. payout
        
        */
        int Options, theChosenOne;                                     // initialize variables
        String valueChecked;

        Scanner sc = new Scanner(System.in);
        int tokens = 0;
        int costOfEachToken = 20;
        System.out.println(("Poker Game"));                           // Prompt and read the input from the user
        do {
            System.out.println("Each token costs: $20.00");               // prompt the user for the number of tokens
            System.out.println("How many tokens do you want to bet?");
            System.out.println("Please enter (1-5): ");
            tokens = sc.nextInt();
        } while (tokens > 5 || tokens < 1);


        p.bets(costOfEachToken * tokens);                            //calculate the bet amount
        System.out.printf(tokens + " tokens so it will cost $%.f", p.getBankroll());

        for (int j = 0; j < tokens; j++) {
            Collections.sort(hand);                             // utilize the built-in sort() method of Collections class
            System.out.println(("Cards dealt are:"));                     // we sort the cards and show the dealt cards
            for (Card card : hand)  System.out.println("\t" + card);

            do{                                                                // read until correct input
                System.out.print("How many cards you want to remove? Enter (1-5): ");       // ask the user
                Options = sc.nextInt();
            }
            while (Options > 5 || Options < 1);

            if (Options > 0)   {
                for (int i = 0; i < Options; i++) {
                    System.out.print("Enter card index to remove (1-5): ");
                    theChosenOne = sc.nextInt();
                    p.removeCard(hand.get(theChosenOne - 1));
                    p.addCard(cards.deal());
                }
            }
            hand = new ArrayList<Card>(p.getHand());                  // initialize the hand
            System.out.println("So the updated cards are: ");
            for (Card card : hand)  System.out.println(("\t" + card));             // output the cards array using for each loop

            valueChecked = checkHand(hand);                         // using the checkHand() method to check and get result
            System.out.println("Result of Hand: " + valueChecked);
            System.out.println();
        }
        System.out.printf("You won: $%.f", p.getBankroll());
    
        
	
	}
	
    
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		// 
		
        
       /*
		// 
		// first thing to do is sort the hand. how?
		// 
		// call each of the submethods(giving each of them access to the hand)
		// 
		
        sort the hand
            how do we do this?
            Collections.sort(hand or p.getHand())
            
            get the hand, then sort it
      
            2s,2h,4d,5h,6s
            
        evaluate the hand
            call helper methods for each hand in descending order
        return the string
        
       Here are the hands in descending order:
         * royal flush - 
                             
         * straight flush  -  
         * 4 of a kind               int first=hand.get(0).getRank()
         * full house
         * flush
         * straight  
         * 3 of a kind
         * two pair
         * 1 pair                 2c,2s,3c,4c,5c    2c,2s,2d,3c,4c
         * nothing (high card)
        
        
        
        public boolean straightFlush(){
            return 
        }
        */
        if (royalFlush(hand)) {
            p.winnings(250000);
            return "royal flush or 5 of a kind";
        }

        else if (straightFlush(hand)) {
            p.winnings(50000);
            return "straight flush";
        }

        else if (fourOfAKind(hand)) {
            p.winnings(10000);
            return "4 of a kind";
        }

        else if (fullHouse(hand)) {
            p.winnings(6000);
            return "full house";
        }

        else if (flush(hand)) {
            p.winnings(500);
            return "flush";
        }

        else if (straightHand(hand)) {
            p.winnings(40);
            return "straight";
        }

        else if (threeOfAKind(hand)) {
            p.winnings(30);
            return "3 of a kind";
        }

        else if (twoPairs(hand)) {
            p.winnings(20);
            return "2 pairs";
        }

        else if (onePair(hand) == 1) {
            p.winnings(10);
            return "1 pair";
        }
        else return "nothing";
        
		
	}
    
        public void handOfCards(String[] testHand) {                // handOfCards() method will create cards of hand
        int suit, rank;
        char suitChar;
        //int rank;
        String strValue;
        rank = 1;
        for (int i = 0; i < 5; i++) {
            suitChar = testHand[i].charAt(0);
            strValue = testHand[i].substring(1);
            rank = Integer.parseInt(strValue);
            switch (suitChar) {
                case 'c': suit = 1;
                    break;
                case 'd': suit = 2;
                    break;
                case 'h': suit = 3;
                    break;
                default:
                    suit = 4;
            }

            p.addCard(new Card(suit, rank));                    // Finally we add cards to p
        }
    }
    
    
	    private int onePair(ArrayList<Card> hand) {                        // onePair() method to check whether cards
        Card tempCard;                                                  //if 1 then we have 1 pair
        int i = 1;
        int numOfPairs = 0;
        while (i < hand.size()) { tempCard = hand.get(i - 1);          // using while loop
            if (tempCard.sameRankCard(hand.get(i))) {
                i++;
                numOfPairs++;
            }
            i++;
        }
        return numOfPairs;

    }



    private boolean twoPairs(ArrayList<Card> hand) {             // twoPairs() method to check whether there are two pairs
        if (onePair(hand) == 2)  return true;                   //if 2 pairs ==> true
        else return false;                                           // else ==> false
    }



    private boolean threeOfAKind(ArrayList<Card> hand) {
        if (onePair(hand) == 0) return false;
        else if (hand.get(0).sameRankCard(hand.get(2))
                || hand.get(1).sameRankCard(hand.get(3))
                || hand.get(2).sameRankCard(hand.get(4))) return true;
        else return false;
    }


    private boolean straightHand(ArrayList<Card> hand)
    {
        // get the values of the hand
        Card firstCards = hand.get(0);
        Card secondCard = hand.get(1);
        Card fifthCards = hand.get(4);

        // get the value returned by the one pair

        if (onePair(hand) > 0) return false;

        else if (fifthCards.differentRankCard(firstCards) == 4) return true;     // get the rank differences between the first and fifth card
        else if (firstCards.getRank() == 1 && secondCard.getRank() == 10           // check for the rank values
                &&  fifthCards.getRank() == 13) return true;
        else return false;                                                       // otherwise return false
    }

  
    public boolean flush(ArrayList<Card> hand) {            // flush() methods, checks whether the cards in the
        // check for number of pairs                           // hand are of same suit. 
        if (onePair(hand) > 0) return false;                     // 
        // otherwise check for the flush

        else {
            int i = 1;
            for (Card card : hand) {
                if (!card.sameSuitCard(hand.get(i))) return false;
                if (i < hand.size() - 1) i++; }      return true;
        }
    }
        public boolean fullHouse(ArrayList<Card> hand) {
        if (onePair(hand) == 2 && fourOfAKind(hand) == false
                && threeOfAKind(hand) == true)         return true;
        else                                             return false;

    }


    public boolean fourOfAKind(ArrayList<Card> hand) {                   // fourOfAKind() method to check if there are cards
        if (onePair(hand) == 2 && threeOfAKind(hand) == true) {                  // of same kind(same ranks)
            if (hand.get(0).sameRankCard(hand.get(3))
                    || hand.get(1).sameRankCard(hand.get(4))) return true;
        }
        return false;
    }


    public boolean straightFlush(ArrayList<Card> hand) {        // straightFlush() method will check straight or flush
        if (flush(hand) && straightHand(hand))         return true;
        else                                              return false;
    }



    public boolean royalFlush(ArrayList<Card> hand) {    // royalFlush() method will check for the better cards
        if (straightFlush(hand) && hand.get(0).getRank() == 1) return true;
        else                                                    return false;
    }






}
