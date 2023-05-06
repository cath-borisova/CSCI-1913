//Name: Katya Borisova
//Partner's Name: Eric Philipps
//I was told by others that a TA said to remove "public" from the class name, so that is why I am resubmitting.
class Zillion {
    private static int counter;
    private int [] array;
    public Zillion(int size) {
        array = new int [size];
    }
    public void increment() {
        counter++;
        int counterTwo = 0;
        for(int i = array.length-1; i>=0; i--) {
            if(array[i] < 9 && counterTwo != 1) {
                array[i] += 1;
                counterTwo = 1;
            } else if(counterTwo != 1){
                array[i] = 0;

            }

        }


    }
    public String toString() {
        String temp ="";
        for(int i =0; i< array.length; i++) {
            temp += array[i] + "";
        }
        return temp;
    }
}
