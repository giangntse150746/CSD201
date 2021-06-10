
public class DLLNode<T> {
    public T info;
    public DLLNode<T> next;
    public DLLNode<T> previous;
    
    public DLLNode() {
        this(null,null,null);
    }
        public DLLNode(T el) {
        this(el,null,null);
    }
    public DLLNode(T el, DLLNode<T> next, DLLNode<T> previous) {
        this.info = el; this.next = next; this.previous = previous;
    }
}

class DLL<T>{
    public DLLNode<T> head, tail;
    int size;
    
    public DLL()
    {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void addFirst(T el)
    {
        if(isEmpty())
        {
            head = tail = new DLLNode<>(el);
        }
        else
        {
            DLLNode<T> tmp = new DLLNode<>();
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
            head = tail = new DLLNode<>(el);
        }
        else
        {
            DLLNode<T> tmp = new DLLNode<>();
            tmp.info = el;
            tmp.next = null;
            tail.next = tmp;
            tail = tmp;
        }
        size++;
    }
        
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
                DLLNode<T> tmp = head;
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

    public T get(int pos) throws IndexOutOfBoundsException
    {
        if(pos < 0 || pos >= size)
        {
            throw new IndexOutOfBoundsException("");
        }
        else
        {
            DLLNode<T>temp = head;
            for(int i=0; i< pos; i++)
                temp = temp.next;
            return temp.info;
        }
    }
}

//    public T deleteHead(int)
/******************************************************************************/

class Student {
    String ID;
    String Name;
    
    public Student() {
        ID = "";
        Name = "";
    }

    public Student(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}

/******************************************************************************/

class Test {
    public static void main(String[] args) {
        
    }
}