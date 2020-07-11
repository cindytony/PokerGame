//add your own banner here

public class Card implements Comparable<Card>{
	
	private int suit; //use integers 1-4 to encode the suit
	private int rank; //use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v     (is this rank r or v)             
        rank = r;
        suit = s;
	}
	
    
	public int compareTo(Card c){
		//use this method to compare cards so they 
		//may be easily sorted
        if (sameRankCard(c)) return this.getSuit() - c.getSuit();
        return differentRankCard(c);

	}
	
	public String toString(){
		//use this method to easily print a Card object
        String resultCard;
        String suitCard = "0";
        String rankCard = "0";
        
        if (suit == 1)                 suitCard = "Clubs";                      //list conditions of the suit
        else if (suit == 2)            suitCard = "Diamonds";
        else if (suit == 3)            suitCard = "Hearts";
        else                           suitCard = "Spades";
        
        if (rank > 1 && rank < 11)     rankCard = "" + rank;             //list conditions of the rank
        else if (rank == 1)            rankCard = "Ace";
        else if (rank == 11)           rankCard = "Jack";
        else if (rank == 12)           rankCard = "Queen";
        else if (rank == 13)           rankCard = "King";
        
        resultCard = rankCard + " of " + suitCard;                 // this to format
        return resultCard;                                         // then return the  string
	}
	
    
    
    //add some more methods here if needed
        //we have to add 5 additional methods: getSuit, getRank, sameSuitCard, sameRankCard, and differentRankCard.
    
        // Two getter methods
    public int getSuit() {                                          //we create 2 getter methods
        return suit;
    }
    public int getRank() {
        return rank;
    }
    
    
    public boolean sameSuitCard(Card c) {                // this sameSuitCard() method will check the suit values
    return this.getSuit() == c.getSuit();                 // of the two cards.
    }                                                   // If the suit values of two cards are the same ==> true.
                                                        // Otherwise ==> false
    
    
    public boolean sameRankCard(Card c) {             // this sameRankCard() method will check the rank
        return this.getRank() == c.getRank();           // values of two cards. 
    }                                                  // If the same ==> true
                                                        // else ==> false
    
    
    public int differentRankCard(Card c) {               // this differentRankCard() method will computing the 
        return this.getRank() - c.getRank();           // difference between result value of the rank of cards
                                                        // and return them
    }  
    
    
    
}
