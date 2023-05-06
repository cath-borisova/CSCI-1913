//Katya Borisova
//boris040

class Pile{
    
    private class Layer{
        Card card;
        Layer next;
        private Layer(Card card, Layer next){
            this.card = card;
            this.next = next;
        }
    }
    private Layer top;
    public Pile(){

        top = null;
    }
    public void add(Card card){

        top = new Layer(card, top);
    }
    public Card draw(){
        if(isEmpty()){
            throw new IllegalStateException("There are no more cards left in the pile.");
        } else {
            Card x = top.card;
            top=top.next;
            return x;
        }
    }
    public boolean isEmpty(){
        return top==null;
    }
}
