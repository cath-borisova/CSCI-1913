//Name: Katya Borisova

public class Sieve {
 private boolean [] numbers;

    public Sieve (int max){
        if(max < 2){
            throw new IllegalArgumentException("Max cannot be less than 2");
        } else {
            numbers = new boolean[max];
            numbers[0] = false;
            numbers[1] = false;
            for(int i =2; i < numbers.length; i++){
                numbers [i] =  true;
            }
        }
    }

    public void findPrimes(){
        for (int i = 2; i<numbers.length; i++) {
            if (numbers[i]) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if ((j) % (i) == 0) {
                        numbers[j] = false;
                    }
                }
            }
        }
    }

    public String toString(){
        String temp = "";
        for(int i = 0; i<numbers.length; i++) {
            if (numbers[i]) {
                temp += (i) + " ";
            }
        }
        return temp;
    }
}