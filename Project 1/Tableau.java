//Katya Borisova
//boris040

class Tableau{
    public Pile [] pile;
    public Tableau(){
        pile = new Pile[13];
        for(int i = 0; i<13; i++){
            pile[i] = new Pile();
        }
        Deck d = new Deck();
        d.shuffle();
        for(int i = 0; i<13; i++){
            for(int j = 0; j<4; j++){
                Card x = d.deal();
                pile[j].add(x);
            }
        }
    }
    public void play() {
        Card cOne = pile[0].draw();
        Card cTwo = pile[0].draw();
        Pile p = pile[0];
        int pIndex = 0;
        boolean playing = true;
        boolean win = true;

        while (playing) {
            if (cOne.getSuit() == cTwo.getSuit()) {
                p = pile[cOne.getRank()];
                pIndex = cOne.getRank();
            } else {
                p = pile[cTwo.getRank()];
                pIndex = cTwo.getRank();
            }
            cOne = cTwo;
            if (p.isEmpty()) {
                playing = false;
            } else {
                cTwo = p.draw();
            }
        }
        for (int i = 0; i < 13; i++) {
            if (pile[i]!= null) {
                win = false;
            }
        }
        if (win) {
            System.out.println("We won!");
        } else {
            System.out.println("Pile " + pIndex + " is empty. We lost!");
        }
    }

}
