
//Method to find the sum of elements with odd and even numbered indexes
public static String oddEven(int[] array)
{
    int oddCount  = 0;
    int evenCount = 0;
    int arraySize = array.length;
    for(int i = 0; i<arraySize;i++)
    {
        if(i % 2 == 0)
        {
            evenCount += array[i];
        }
        else
        {
            oddCount += array[i];
        }
    }
    String counts = "Sum of the elements with odd indexes: " + oddCount + ". Sum of the elements with even indexes: " + evenCount;
    return counts;
}
