//Katya Borisova
//boris040

import java.util.Random;

class Deck {
    public Card [] cards;
    public int count;
    public boolean isDealt;
    Random r;
    public Deck(){
        count = -1;
        cards = new Card [52];
        int rank = 0;
        int suit = 0;
        isDealt = false;
        for(int i = 0; i<52; i++) {
            if (rank == 13) {
                rank = 0;
                suit++;
            }
            cards[i] = new Card(rank, suit);
            rank++;

        }
        r = new Random();
    }
    public Card deal (){
        if(count >= 51){
            throw new IllegalStateException("The deck is empty");
        } else {
            count++;
            isDealt = true;
            return cards[count];
        }
    }
    public void shuffle(){
        if(isDealt){
            throw new IllegalStateException("The deck cannot be shuffled after it's been dealt");
        } else {
            for(int i = 0; i< 52; i++){
                int j = Math.abs(r.nextInt())% 52;
                Card temp = cards[i];
                cards[i] = cards[j];
                cards[j] = temp;
            }
        }

    }

}
