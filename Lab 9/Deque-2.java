//Katya Borisova
//boris040

class Deque <Base> {
    private class Node{
        private Base object;
        private Node left;
        private Node right;
        private Node(Base object, Node left, Node right){
            this.object = object;
            this.left = left;
            this.right = right;
        }
    }
    private Node head;
    public Deque(){
        head = new Node(null, head, head);
        head.left = head;
        head.right = head;
    }
    public void enqueueFront(Base object){
        Node node = new Node(object, head, head.right);
        head.right.left = node;
        head.right = node;
    }
    public void enqueueRear(Base object){
        Node node = new Node(object, head.left, head);
        head.left.right = node;
        head.left = node;
    }
    public Base dequeueFront(){
        if(isEmpty()) {
            throw new IllegalStateException("deque is empty");
        }
        Node temp = head.right;
        head.right = head.right.right;
        head.right.right.left = head;
        return temp.object;
    }
    public Base dequeueRear(){
        if(isEmpty()) {
            throw new IllegalStateException("deque is empty");
        }
        Node temp = head.left;
        head.left = head.left.left;
        head.left.left.right = head;
        return temp.object;
    }
    public boolean isEmpty(){
        return head.right == head && head.left == head;
    }
}
