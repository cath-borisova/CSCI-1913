 //Katya Borisova
 //boris040
class PriorityQueue<Base> {
     private class Node
     {
         private Base object;
         private int  rank;
         private Node left;
         private Node right;

         private Node(Base object, int rank)
         {
             this.object = object;
             this.rank = rank;
             left = null;
             right = null;
         }

     }

     private Node root;  //  Head node of the BST.

     public PriorityQueue(){

         root = new Node(null, 8);
     }
     public Base dequeue(){ //remove the higher ranked object
        if(isEmpty()){
            throw new IllegalStateException("The tree is empty");
        } else {
            Node below = root;
            Node above = root;
            while (below.left != null) {
                above = below;
               below = below.left;
            }
            Base temp = below.object;
            above.left = below.right;
            return temp;
        }
     }
     public void enqueue(Base object, int rank){ //add object
         if(rank < 0){
             throw new IllegalArgumentException("Rank cannot be less than 0");
         } else {
             Node below = root;
                 while (true) {
                     if (rank <= below.rank) {
                         if (below.left == null) {
                             below.left = new Node(object, rank);
                             break;
                         } else {
                             below = below.left;
                         }
                     } else if (rank > below.rank) {
                         if (below.right == null) {
                             below.right = new Node(object, rank);
                             break;
                         } else {
                             below = below.right;
                         }
                     }
                 }
             }
         }


     public boolean isEmpty(){
        return root.left == null;
     }
}
