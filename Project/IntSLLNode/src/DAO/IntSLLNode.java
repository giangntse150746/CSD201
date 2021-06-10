package DAO;


public class IntSLLNode {
	public int info;
	public IntSLLNode next;
	public IntSLLNode(int i)
	{
		info = i;
		next = null;
	}
	public IntSLLNode(int i, IntSLLNode n)
	{
		info = i;
		next = n;
	}
}

class IntSLL
{
	IntSLLNode head, tail;
	int size;
	public IntSLL()
	{
		head = tail =  null;
		size = 0;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public void clear()
	{
		head = tail = null;
		size = 0;
	}
	public void AddFirst(int el)
	{
		IntSLLNode newest = new IntSLLNode(el, null);
		newest.next = head;
		head = newest;
		size++;
		if(tail == null)
			tail = head;
	}
	public void traverse() throws Exception // print all info of the list
	{
		if(isEmpty())
		{
			throw new Exception("Empty list");
		}
		IntSLLNode temp = head;
		while(temp != null)
		{
			System.out.print(temp.info);
			temp = temp.next;
		}
	}
	
	public void AddLast(int el)
	{
		IntSLLNode newest = new IntSLLNode(el, null);
		if (isEmpty()) head = tail = newest;
		else {
			tail.next = newest;
			tail = newest;
		}
		size++;	
	}
	
	
	
	
	public int get(int position) throws IndexOutOfBoundsException
	{
            IntSLLNode CurrentNode = head;
            int count = 0;  //change to 1 if want to see the order from 1 instead 0;
            while (CurrentNode != null)
            {
                if (count == position)
                    return CurrentNode.info;
                count++;
                CurrentNode = CurrentNode.next;
            }
		return 0;
	}
	
	public void Add(int el, int position) throws IndexOutOfBoundsException
	{
            IntSLLNode CurrentNode = head;
            int count = 0;
            while (CurrentNode != null)
            {
                if (count == position)
                {
                    IntSLLNode newest = new IntSLLNode(el, null);
                    newest.next = CurrentNode.next;
                    CurrentNode.next = newest;
                    size++;
                    break;
                }
                count++;
                CurrentNode = CurrentNode.next;
            }
	}
	
	public int RemoveFirst() throws Exception
	{
            if(head == null)
            {
                System.out.println("Null List");
                return 0;
            }
		head = head.next;
		size--;
		if(tail == null)
			tail.next = head;
            return head.info;
	}
	
	public int RemoveLast() throws Exception
	{
            if(head == null)
            {
                System.out.println("Null List");
                return 0;
            }
            IntSLLNode CurrentNode = head;
            while (CurrentNode.next.next != null)
            {
                CurrentNode = CurrentNode.next;
            }
            CurrentNode.next = null;
            tail = CurrentNode;
            size--;
            return CurrentNode.info;
	}
	
	public int RemoveAt(int position)  throws IndexOutOfBoundsException
	{
            if(head == null)
            {
                System.out.println("Null List");
                return 0;
            }
            IntSLLNode CurrentNode = head;
            int count = 1;
            if (position == 0) 
            { 
                head = CurrentNode.next;   // Change head to next node
            }
            else
            {
                while (CurrentNode != null)
                {
                    if (count == position)
                    {
                        IntSLLNode NextTemp = CurrentNode.next.next;  //pos(CurrentNode) - 1
                        CurrentNode.next = NextTemp;
                        size--;
                        break;
                    }
                    count++;
                    CurrentNode = CurrentNode.next;
                }
            }
            return CurrentNode.info;    //Node was replace the deleted node
	}
	
	public void reverse() throws Exception // require take in place
	{ 
            if(head == null)
            {
                System.out.println("Null List");
                System.exit(0);
            }
            IntSLLNode PreviousNode = null;
            IntSLLNode CurrentNode = head;
            IntSLLNode NextNode = head.next;
            IntSLLNode tempNode = null;
            if(head != null)
            {
                PreviousNode = head;
                CurrentNode = head.next;
                head = head.next;

                PreviousNode.next = null; // Make first node as last node

                while(head != null)
                {
                    head = head.next;
                    CurrentNode.next = PreviousNode;
                    PreviousNode = CurrentNode;
                    CurrentNode = head;
                }

                head = PreviousNode; // Make last node as head

                System.out.println("SUCCESSFULLY REVERSED LIST\n");
            }
	}
	
	public void sort()
	{
            if(head == null)
            {
                System.out.println("Null List");
                System.exit(0);
            }
            IntSLLNode current = head, index = null;  
            int temp;  

            if(head == null) {  
                return;  
            }  
            else {  
                while(current != null) {  
                    //Node index will point to node next to current  
                    index = current.next;  

                    while(index != null) {  
                        //If current node's data is greater than index's node data, swap the data between them  
                        if(current.info > index.info) {  
                            temp = current.info;  
                            current.info = index.info;  
                            index.info = temp;  
                        }  
                        index = index.next;  
                    }  
                    current = current.next;  
                }      
            }  
	}
        
    void printList() throws Exception
    {
        IntSLLNode node = head;
        if (tail == null) {
            System.out.println("Null List");
        }
        while (node != null)
        {
            System.out.print(node.info + " "); 
            node = node.next;
        }
        System.out.println();
    } 
}

class Test
{
    public static void main(String[] args){
        IntSLL sll = new IntSLL();
        for(int i = 0; i < 10; i++)
                sll.AddFirst(i);

        try {
            sll.RemoveFirst();
            sll.RemoveLast();
            sll.RemoveAt(5);
            //ll.reverse();
            sll.sort();
            //System.out.println(sll.get(5));
                sll.printList();
        } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
        }
    }	
}