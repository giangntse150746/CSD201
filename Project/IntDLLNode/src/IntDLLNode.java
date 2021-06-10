
public class IntDLLNode {
	public int info;
	public IntDLLNode next;
        public IntDLLNode prev;
	public IntDLLNode(int i)
	{
		info = i;
		next = null;
                prev = null;
	}
	public IntDLLNode(int i, IntDLLNode n)
	{
		info = i;
		next = n;
                prev = null;
	}
}

class IntDLL
{
	IntDLLNode head;
        IntDLLNode tail;
	int size;
	public IntDLL()
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
		IntDLLNode newest = new IntDLLNode(el, null);
                if (head != null)
                head.prev = newest;
                //
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
		IntDLLNode temp = head;
		while(temp != null)
		{
                    //print out all information of a node, include address
			System.out.println(temp.info + " " + temp.prev + " " + temp + " " + temp.next);
			temp = temp.next;
		}
	}
	
	public void AddLast(int el)
	{
            IntDLLNode newest = new IntDLLNode(el, null);
            if (tail != null)
                tail.next = newest;
                //
                newest.prev = tail;
                tail = newest;
                size++;
                if(head == null)
			head = tail;
	}
	
	
	
	
	public int get(int position) throws IndexOutOfBoundsException
	{
            IntDLLNode CurrentNode = head;
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
            IntDLLNode CurrentNode = head;
            int count = 0;
            while (CurrentNode != null)
            {
                if (count == position)
                {
                    IntDLLNode newest = new IntDLLNode(el, null);
                    IntDLLNode NextNode = CurrentNode.next;
                    newest.prev = CurrentNode;
                    newest.next = CurrentNode.next;
                    CurrentNode.next = newest;
                    NextNode.prev = newest;
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
                head.prev = null;
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
            IntDLLNode CurrentNode = head;
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
            IntDLLNode CurrentNode = head;
            IntDLLNode TempNode = null;
            int count = 1;
            if (position == 0) 
            { 
                head = CurrentNode.next;   // Change head to next node
                head.prev = null;
            }
            else
            {
                while (CurrentNode != null)
                {
                    if (count == position)
                    {
                        TempNode = CurrentNode;
                        IntDLLNode NextTemp = CurrentNode.next;  //pos(CurrentNode) - 1
                        IntDLLNode PrevTemp = CurrentNode.prev;
                        PrevTemp.next = NextTemp;
                        NextTemp.prev = PrevTemp;
                        size--;
                        break;
                    }
                    count++;
                    CurrentNode = CurrentNode.next;
                }
            }
            return TempNode.info;    //Node was replace the deleted node
	}
	
	public void reverse() throws Exception // require take in place (NOTDONE)
	{ 
            if(head == null)
            {
                System.out.println("Null List");
                throw new Exception();
            }
            IntDLLNode CurrentNode = head;
            IntDLLNode TempNode = null;
            while (CurrentNode != null)
            {
                TempNode = CurrentNode.prev;
                CurrentNode.prev = CurrentNode.next;
                CurrentNode.next = TempNode;
                //check if they swapped
                //System.out.println(CurrentNode.info + "|" + CurrentNode.prev + "|" + CurrentNode + "|" + CurrentNode.next);
                CurrentNode = CurrentNode.prev;
            }
            if (TempNode != null)
                head = TempNode.prev;            
            //notice if all nodes are reversed
            //System.out.println("SUCCESSFULLY REVERSED LIST\n");
	}
	
	public void sort() throws Exception
	{
            if(head == null)
            {
                System.out.println("Null List");
                throw new Exception();
            }    
            else {  
                IntDLLNode current = head;  
                IntDLLNode index = null;
                int temp;
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
        IntDLLNode node = head;
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
        IntDLL dll = new IntDLL();
        for(int i = 0; i < 10; i++)
                dll.AddFirst(i);    //done
        //    dll.AddLast(i);         //done
//            dll.Add(120, 4);        //done

        try {
            dll.RemoveFirst();
            dll.RemoveLast();       //done
            dll.RemoveAt(3);        //done
            dll.sort();             //done
            dll.reverse();          //done
            
            //    dll.printList();
            dll.traverse();         //done
        } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
        }
    }	
}