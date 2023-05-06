//  ARRAY QUEUE. A fixed length queue represented as a circular array.
//Katya Borisova
//boris040

class ArrayQueue<Base> {
    private int front;    //  Index of front object in OBJECTS.
    private int rear;     //  Index of rear object in OBJECTS.
    private Base[] objects;  //  The OBJECTs in the queue.

//  Constuctor. Make a new empty queue that can hold SIZE - 1 elements.

    public ArrayQueue(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Illegal size.");
        } else {
            front = 0;
            rear = 0;
            objects = (Base[]) new Object[size];
        }
    }

//  DEQUEUE. Remove an object from the queue.

    public Base dequeue() {
        if (front == rear) {
            throw new IllegalStateException("Queue is empty.");
        } else {
            front = (front + 1) % objects.length;
            Base temp = objects[front];
            objects[front] = null;
            return temp;
        }
    }

//  ENQUEUE. Add a new OBJECT to the queue.

    public void enqueue(Base object) {
        int nextRear = (rear + 1) % objects.length;
        if (front == nextRear) {
            throw new IllegalStateException("Queue is full.");
        } else {
            rear = nextRear;
            objects[rear] = object;
        }
    }

//  IS EMPTY. Test if the queue is empty.

    public boolean isEmpty() {
        return front == rear;
    }

//  IS FULL. Test if the queue is full.

    public boolean isFull() {
        return front == (rear + 1) % objects.length;
    }

    public class Iterator {
        private int pos;
        private int size;
        private int fronti;

        private Iterator(int front, int length) {
            pos = (front + 1) % length;
            fronti = front;
            size = length;
        }

        public boolean hasNext() {
            return pos != fronti;
        }

        public Base next() {
            if (!hasNext()) {
                throw new IllegalStateException("The queue is empty");
            } else {
                int temp = pos;
                pos = (pos + 1) % size;
                return objects[temp];
            }
        }
    }
        public Iterator iterator() {
            return new Iterator(front, objects.length);
        }

}