//Katya Borisova
//boris040

class PerteDeTemps {
    public static void main (String [] args){
        //creation of a deck of 52 cards
        Deck d = new Deck();
        System.out.println("\nThe length of the new deck is " + d.cards.length);
        System.out.println("\nThe initial order of cards:");
        for(int i = 0; i<d.cards.length; i++){
            System.out.println(d.cards[i]);
        }
        //shuffling of a deck
        d.shuffle();
        System.out.println("\nThe new order of cards:");
        for(int i = 0; i<d.cards.length; i++){
            System.out.println(d.cards[i]);
        }
        //creation of a new empty pile of cards
        Pile p = new Pile();

        //adding the first card from deck to a pile
        p.add(d.cards[0]);
        System.out.println("\n The first card in pile: " + p.draw());

        //dealing cards
        Card c = d.deal();
        System.out.println("\n The dealt card is: " + c);

        //dealing a card and then adding it to pile
        p.add(c);
        System.out.println("\n The dealt card that was added to pile was: " + p.draw());
        p.add(d.deal());
        System.out.println("The next dealt card that was added to pile was: " + p.draw());

        //shuffling after the deck has been dealt returns an exception
        //d.shuffle();

        //drawing from an empty pile returns an exception
        //System.out.println(p.draw());

        //dealing more than 52 cards returns an exception
        /*Deck dTwo = new Deck();
        dTwo.shuffle();
        for(int i = 0; i< 52; i++){
            int j = i+1;
            System.out.println("Card " + j + " out of 53 is " + dTwo.deal());
        }
        System.out.println("Card 53 out of 53 is " + dTwo.deal());
         */


        //play the full game 10 different times
        System.out.println("\n 10 games:");
        for(int i = 0; i<10; i++) {
            Tableau t  = new Tableau();
            t.play();
        }
    }
}
