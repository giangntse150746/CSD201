//
//package recursion;
//
//import pkg.Queue;
//import java.util.Random;
//
///**
// *
// * @author saoranngu
// */
//public class Recursion {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        //(4)
//        printRangeFromNto1(10);
//        
//            System.out.println();
//        printRangeFromItoN(20, 10);
//            System.out.println();
//        System.out.println("***************************");
//        //(5)
//        String toString = "";
//        toString = intToString(-193564123, false, 0, toString);
//        System.out.println(toString);
//        System.out.println("***************************");
//        //(6)
//        int[] a = new int[10];
//        Random rand = new Random();
//            System.out.print("Array: ");
//            for (int i = 0; i < a.length; i++)
//            {
//                a[i] = rand.nextInt(300);
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
//        int max = maxInArray(a, 0, 0);
//        System.out.println("Max is: " + max);
//        System.out.println("***************************");
//        /***/
////        Queue<Integer> q = new Queue<>();
////        for (int i = 0; i < q.Size(); i++) {
////            q.enqueue(rand.nextInt(300));
////        }
////        max = maxInQueue(q, max);
////        System.out.println("Max is: " + max);
//    }
//    
///*(4)*/    //In: 10 --> Out: 10 9 8 7 6 5 4 3 2 1
//    static int printRangeFromNto1(int n)
//    {   //from N to 1
//        System.out.print(n + " ");
//        if (n == 1)
//            return 1;
//        return printRangeFromNto1(n-1);
//    }
//    static int printRangeFromItoN(int n, int i)
//    {   //from I to N
//        System.out.print(i + " ");
//        if (i == n)
//            return n;
//        return printRangeFromItoN(n,i+1);
//    }
//    
///*(5)*/     //In: 123456 --> Out: 123,456
//    static String intToString(int n, boolean isNegative, int count, String nString)
//    {
//        //if n is negative, switch it to positive and note it
//        if (n < 0 && isNegative == false)
//        {
//            isNegative = true;
//            n = -n;
//        }
//        //when n == 0, then return the answer
//        if (n == 0)
//            //when n == 0, if the original number is negative, make it negative
//            if (isNegative)
//                return "-" + nString;
//            else
//                return nString;
//        //place comma when the count reach
//        if (count % 3 == 0 && count > 0)
//            nString = "," + nString;
//        return intToString(n/10, isNegative, count+1, nString = n%10 + nString);
//    }
//    
///*(6)*/     //In: and array [1,6,3,4,5,2,8,7] --> Out: 8 (max number)
//    static int maxInArray(int [] array, int max, int curPos)
//    {
//        if (curPos == array.length)
//            return max;
//        if (max < array[curPos])
//            return maxInArray(array, max = array[curPos], curPos+1);
//        return maxInArray(array, max, curPos+1);
//    }
//    static int maxInQueue(Queue<Integer> q, int max)
//    {
//        if (q.isEmpty())
//            return max;
//        if (max < q.front())
//            return maxInQueue(q, max = q.dequeue());
//        q.dequeue();
//        return maxInQueue(q, max);
//    }
//}
