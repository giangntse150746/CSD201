package DAO;

public class SLLNode<T> {
    public T info;
    public SLLNode<T> next;
    public SLLNode() {
        this(null,null);
    }
        public SLLNode(T el) {
        this(el,null);
    }
    public SLLNode(T el, SLLNode<T> ptr) {
        info = el; next = ptr;
    }
}

class SLL<T>{
    public SLLNode<T> head, tail;
    int size;
    
    public SLL()
    {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void traverse() throws Exception // print all info of the list
    {
        if(isEmpty())
        {
                throw new Exception("Empty list");
        }
        SLLNode<T> temp = head;
        while(temp != null)
        {
                System.out.println(temp.info);
                temp = temp.next;
        }
    }
    
/**
 * @Get
 */
    public T get(int pos) throws IndexOutOfBoundsException
    {
        if(pos < 0 || pos >= size)
        {
            throw new IndexOutOfBoundsException("");
        }
        else
        {
            SLLNode<T>temp = head;
            for(int i=0; i< pos; i++)
                temp = temp.next;
            return temp.info;
        }
    }
    
/**
 * @Add
 */    
    public void addFirst(T el)
    {
        if(isEmpty())
        {
            head = tail = new SLLNode<>(el);
        }
        else
        {
            SLLNode<T> tmp = new SLLNode<>();
            tmp.info = el;
            tmp.next = head;
            head = tmp;
        }
        size++;
    }
    
    public void addLast(T el)
    {
        if(isEmpty())
        {
            head = tail = new SLLNode<>(el);
        }
        else
        {
            SLLNode<T> tmp = new SLLNode<>();
            tmp.info = el;
            tmp.next = null;
            tail.next = tmp;
            tail = tmp;
        }
        size++;
    }
    
    public void Add(T el, int position) throws IndexOutOfBoundsException
	{
            SLLNode<T> CurrentNode = head;
            int count = 0;
            while (CurrentNode != null)
            {
                if (count == position)
                {
                    SLLNode<T> newest = new SLLNode<>(el);
                    newest.next = CurrentNode.next;
                    CurrentNode.next = newest;
                    size++;
                    break;
                }
                count++;
                CurrentNode = CurrentNode.next;
            }
	}

/**
 * @Remove
 */
    public T removeFirst() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("");
        }
        else
        {
            T el = head.info;
            head = head.next;
            size--;
            return el;
        }
    }
        
    public T removeLast() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("");
        }
        else
        {
            T el = tail.info;
            if(head == tail)
            {
                head = tail = null;
            }
            else
            {
                SLLNode<T> tmp = head;
                while(tmp.next != tail)
                {
                    tmp = tmp.next;
                }
                tmp.next = null;
                tail = tmp;
            }
            size--;
            return el;
        }
    }
    

    
}

class Test {
    public static void main(String[] args) throws Exception {
        Student Current = new Student("A","B");
        SLL<Student> SLL = new SLL<>();
        
        for (int i=0 ; i<10 ; i++) {
            SLL.addLast(Current = new Student("A"+i,"K"+i));
        }
        
        SLL.traverse();
//        System.out.println(SLL.get(5));
        
//        SLLNode<Student> Node = SLL.head;
//        while (Node != null) {
//            System.out.println(Node.info.toString());
//            Node = Node.next;
//        }
    }
}