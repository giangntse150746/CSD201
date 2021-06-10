package pkg;

import java.util.Scanner;

public class TestStack {
	public static void main(String[] args) {	
		System.out.println("----------------------STACK--------------------");
		Stack<Integer> s = new Stack<Integer>();
                Stack<Integer> s2 = new Stack<Integer>();
		inputStack(s);
		outputStack(s);
		try {
			reverse1c(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		outputStack(s);
                transfer(s, s2);
                outputStack(s2);
		
	}
	
	static void inputStack(Stack<Integer> S)
	{
		System.out.print("Enter elements separated by space: ");
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
	          S.push(sc.nextInt());
	      }
	}
	
	static void outputStack(Stack<Integer> S)
	{
		System.out.println(S.toString());
	}
	
	public static void reverse1a(Stack<Integer> S) throws Exception
	{
		//Reverse the order of elements on stack S using 2 additional stacks
		//1. Declare Stack S1, S2
		Stack<Integer> S1 = new Stack<Integer>();
		Stack<Integer> S2 = new Stack<Integer>();
		
		//2. Transfer all elements from S to S1
		while(!S.isEmpty())
			S1.push(S.pop());
		
		//3. Transfer all elements from S1 to S2
		while(!S1.isEmpty())
			S2.push(S1.pop());
		
		//4. Transfer all elements from S2 to S
		while(!S2.isEmpty())
			S.push(S2.pop());		
	}
		
	public static void reverse1c(Stack<Integer> S) throws Exception
	{
		//Reverse the order of elements on stack S using one //additional stack and some additional non-array variables
		
		//1. Declare Stack S1, variable top, variable count
		Stack<Integer> S1 = new Stack<Integer>();
		Integer top = new Integer(S.topEl());
                Integer count = new Integer(S.Size() - 1);
		//2. Initialize count = size of S1 - 1
		
		//3. Repeat the following steps until count = 0
                while (count > 0) {
                    //4. Take the top element of S and assign to top
                    top = S.pop();
                    //5. Transfer count elements from S to S1
                    for (int i=0; i<count; i++) {
                        S1.push(S.pop());
                    }	
                    //6. Put value of top in S
                    S.push(top);
                    //7. Transfer all elements from S1 to S
                    while (!S1.isEmpty())
                        S.push(S1.pop());
                    //8. Decrement count
                    count--;
                }
	}
	
	public static void sortStack(Stack<Integer> S)
	{
		//Put the elements on the stack S in ascending order using one additional stack and
		//some additional non-array variables
            Stack<Integer> S1 = new Stack<>();
            int count = S.Size()-1;   //count transfer times need to do
            int compVar = 0;    //contain element to compare with the others
                //sort condition
            if (count < 1)
                System.out.println("Nothing to sort!");
            else {
                while (count > 0) {
                    compVar = S.pop();
                    //Compare with the variable and swap
                    for (int i=0; i<count; i++) {
                        //if compVar is not bigger than top element, push top of S2 to S1.
                        if (S.topEl() >= compVar)   
                            S1.push(S.pop());
                        else {
                        //if compVar is bigger than, change element.
                            S1.push(compVar);
                            compVar = S.pop();
                        }
                    }
                    //Push the smallest value back to S
                    S.push(compVar);
                    //Transfer all elements from S1 to S
                    while (!S1.isEmpty())
                        S.push(S1.pop());
                    //Decrease count
                    count--;
                }
            }
	}
	
	public static void transfer(Stack<Integer> S1, Stack<Integer> S2)
	{
		//Transfer elements from stack S1 to stack S2
		//so that the elements from S2 are in the same order as on S1
		//using no additional stack but only some additional non-array variables
            int temp = 0, count = S1.Size()-1;
            if (count < 1)
                System.out.println("Nothing to sort!");
            else {
                while (count > 0)
                {
                    //Reach the deepest value
                    for (int i=0; i<count; i++)
                        S2.push(S1.pop());
                    
                    //Get the deepest value
                    temp = S1.pop();
                    
                    //Bring the rest back to original Stack
                    for (int i = 0; i < count; i++)
                        S1.push(S2.pop());
                    
                    //Send this value into Stack transfer
                    S2.push(temp);
                    
                    //Decrease count
                    count--;
                }
                //Push the last (highest) element from original Stack into transfer Stack
                S2.push(S1.pop());
            }
	}
	
}
