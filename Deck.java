public class Deck {
	
	private Card[] cards;
	private int top; //the index of the top of the deck
    public int numCards = 0;
	//add more instance variables if needed
	
    
    
	public Deck(){
		//make a 52 card deck here
                //Card = card;
        cards = new Card[52];                            // initialize the cards array of size 52
        top = 0;                                       // private method to initialize the deck of cards
        Card card;                                        // Define the Card class variable
        for (int suit = 1; suit < 5; suit++) {            // nested loops to create the array of Card
            for (int rank = 1; rank < 14; rank++) {          // objects
                card = new Card(suit, rank);
                cards[numCards] = card;
                numCards++;
            }
        }
	}
