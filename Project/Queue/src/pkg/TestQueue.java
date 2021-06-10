package pkg;

import java.util.Random;
import java.util.Scanner;
import pkg.Queue;


public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args)
        {
		// TODO Auto-generated method stub
		System.out.println("----------------------QUEUE--------------------");
		Queue<Integer> q = new Queue<Integer>();
		inputQueueAuto(q);
                    outputQueue(q);
                reverse(q);
                    outputQueue(q);
                sortQueue1(q);
                    outputQueue(q);
//                sortQueue2(q);
//                    outputQueue(q);
//                sortQueue3(q);
//                    outputQueue(q);
	}
	
	static void inputQueue(Queue<Integer> Q)
	{
		System.out.print("Enter elements separated by space: ");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
	          Q.enqueue(sc.nextInt());
	    }
	}
        static void inputQueueAuto(Queue<Integer> Q)
        {
            Random rand = new Random();
            System.out.print("Running");
            for (int i = 0; i < 1000; i++)
            {
                int randomizer = rand.nextInt(90);
                Q.enqueue(randomizer);
                if(i % 333 == 0)
                    System.out.print(".");
            }
            try {
                Thread.sleep(1000);
                System.out.println("\n<Done!>");
            } catch (Exception e) {
                System.out.println("<Fail to Call Sleep method!>");
            }
        }
	
	static void outputQueue(Queue<Integer> Q)
	{
		System.out.println(Q.toString());
	}
	
	public static void reverse(Queue<Integer> Q)
	{
		//Reverse the order of elements on stack Q using one additional queue
		Queue<Integer> Q1 = new Queue<Integer>();
		
		//2. Transfer all elements from Q to Q1
		while(!Q.isEmpty()) {
			Q1.enqueue(Q.l.removeLast());
                }

		//3. Transfer all elements from Q1 to Q
		while(!Q1.isEmpty())
			Q.enqueue(Q1.dequeue());
		
	}
	
	public static void sortQueue1(Queue<Integer> Q)
	{
            //Ascending Order
		//Using two additional queue and some non-array variables, order all elements on a queue
            Queue<Integer> Q1 = new Queue<>();      //Queue to store values in the rest of Queue Q 
            Queue<Integer> Q2 = new Queue<>();      //Queue to store values that compared
            int count = Q.Size() - 1;
            int compVar = 0;
            if (count < 1)
                System.out.println("Nothing to sort!");
            else
            {
                while (count > 0)
                {
                    compVar = Q.dequeue();  //get the first value in the rest of Q
                    for (int i = 0; i< count; i++)
                    {
                        //get the smallest value of the rest queue
                        if (compVar <= Q.front())
                            Q1.enqueue(Q.dequeue());
                        else
                        {
                            //if compVar is bigger than, change element. -->Make compVar has the smallest
                            Q1.enqueue(compVar);
                            compVar = Q.dequeue();
                        }
                    }
                    //bring the next smallest into Q2
                    Q2.enqueue(compVar);
                    
                    //prepare for the next round
                    if (Q1.Size() == 1)     //Q1 has 1 element, needn't to sort, send it to the sorted list
                        Q2.enqueue(Q1.dequeue());
                    else
                        while (!Q1.isEmpty())   //send all rest of elements to Q for the next round
                            Q.enqueue(Q1.dequeue());
                    count--;
                }
                
                //send all values to the original Queue (Q)
                while (!Q2.isEmpty())
                    Q.enqueue(Q2.dequeue());
            }
	}
	
	public static void sortQueue2(Queue<Integer> Q)
	{
		//Using one additional queue and some non-array variables, order all elements on a queue
            Queue<Integer> Q1 = new Queue<>();
            int count = Q.Size()-1;
            int compVar;
            if (count < 1)
                System.out.println("Nothing to sort!");
            else
            {
                while (count > 0)
                {
                    compVar = Q.dequeue();       //get the first value in the rest of Q
                    for (int i = 0; i < count; i++)
                        if (compVar <= Q.front())
                            Q.enqueue(Q.dequeue());
                        else
                        {
                            Q.enqueue(compVar);
                            compVar = Q.dequeue();
                        }
                    Q1.enqueue(compVar);
                    count--;
                }
                if (!Q.isEmpty())
                    Q1.enqueue(Q.dequeue());
                while (!Q1.isEmpty())
                    Q.enqueue(Q1.dequeue());
            }
        }

        public static void sortQueue3(Queue<Integer> Q)
	{
		//Using no additional queue and some non-array variables, order all elements on a queue
            int count = Q.Size()-1;
            int sorted = 0;
            int compVar;
            if (count < 1)
                System.out.println("Nothing to sort!");
            else
            {
                while (count > 0)
                {
                    compVar = Q.dequeue();  //get the first value in the rest of Q
                    
                    for (int i = 0; i < count; i++)
                        if (compVar > Q.front())    //get the smallest value
                        {                   //change the value of compVar if it bigger than inList element.
                            Q.enqueue(compVar);
                            compVar = Q.dequeue();
                        }
                        else                //if not, just send it to the last.
                            Q.enqueue(Q.dequeue());
                    
                    if (sorted > 0)
                        for (int i = 0; i < sorted; i++)
                            Q.enqueue(Q.dequeue());
                    //send value of compVar to the last of Queue
                    Q.enqueue(compVar);
                    //increase the sorted element, so program will not sort it again
                    sorted++;
                    //decrease the list need to sort
                    count--;
                }
                //one last and biggest element can not compare
                //so it will attend at the first of list, send it to the last
                Q.enqueue(Q.dequeue());
            }
        }
}
