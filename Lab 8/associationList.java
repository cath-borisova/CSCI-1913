//Katya Borisova
//boris040

class AssociationList<Key, Value> {
    private class Node {
        private Value value;
        private Key key;
        private Node next;

        private Node(Value value, Key key, Node next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }

    private Node head;

    public AssociationList() {
        head = new Node(null, null, head);
    }

    public void delete(Key key) {
        Node tempRight = head.next;
        Node tempLeft = head;
        while (tempRight != null) {

            if (isEqual(key, tempRight.key)) {
                tempLeft.next = tempRight.next;
                break;
            }
                tempLeft = tempRight;
                tempRight = tempRight.next;
            }
        }



    public Value get(Key key) {
        if (isIn(key)) {
            Node temp = head.next;
            while (temp != null) {
                if (isEqual(temp.key, key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
            throw new IllegalArgumentException("Key was not found");

    }

    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null || rightKey == null) {
            return leftKey == rightKey;
        } else {
            return leftKey.equals(rightKey);
        }
    }

    public boolean isIn(Key key) {
            Node temp = head.next;
            while (temp != null) {
                if (isEqual(temp.key, key)) {
                    return true;
                }
                temp= temp.next;
            }

            return false;
    }
    public void put(Key key, Value value) {
        Node temp = head.next;
        while (temp != null) {
            if (isEqual(key, temp.key)) {
                temp.value = value;
                break;
            }
            temp = temp.next;
        }
        temp = head.next;
        head.next = new Node(value, key, temp);
    }
}

/* Results:
false
No null
true
false
true
true
true
false
Lavender
Ginny
null
Wormtail
No Joanne
false
true
null
Ginny
Ginny
Hermione
No Dean
 */