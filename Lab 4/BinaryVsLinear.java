//Katya Borisova
//boris040

public class BinaryVsLinear
{
    private static int linearSearch(int key, int [] array)
    {
        int comparisons = 0;
    for(int i =0; i<array.length; i++){
        comparisons++;
        if(key == array[i]){
            return comparisons;
        }
    }
    return comparisons;
    }

    private static int binarySearch(int key, int [] array)
    {
        int left = 0;
        int mid = 0;
        int right = array.length-1;
        int comparisons = 0;
        while(true){
            if (left>right){
               mid =- 1;
                break;
            } else {
                mid = (left + right)/2;
                if(key<array[mid]){
                    right = mid-1;
                    comparisons ++;
                } else if (key > array[mid]){
                    left = mid+1;
                    comparisons +=2;
                } else {
                    comparisons +=2;
                    break;
                }
            }
        }
        return comparisons;
    }

    public static void main(String [] args)
    {
        for (int length = 1; length <= 30; length += 1)
        {
            int[] array = new int[length];
            for (int index = 0; index < length; index += 1)
            {
                array[index] = index;
            }

            double linearTotal = 0.0;
            double binaryTotal = 0.0;
            for (int element = 0; element < length; element += 1)
            {
                linearTotal += linearSearch(element, array);
                binaryTotal += binarySearch(element, array);
            }

            double linearAverage = linearTotal / length;
            double binaryAverage = binaryTotal / length;
            System.out.println(length + " " + linearAverage + " " + binaryAverage);
        }
    }
}