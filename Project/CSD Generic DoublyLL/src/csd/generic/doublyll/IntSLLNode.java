/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd.generic.doublyll;

/**
 *
 * @author cuong
 */
public class IntSLLNode<T> {
    public T info;
    public IntSLLNode<T> next;
    public IntSLLNode<T> back;
    public IntSLLNode(T i)
    {
        info = i;
        next = null;
        back = null;
    }
    public IntSLLNode(T i, IntSLLNode<T> n, IntSLLNode<T> b)
    {
        info = i;
        next = n;
        back = b;
    }
}
class IntSLL<T>
    {
    IntSLLNode<T> head, tail;
    int size;
    public IntSLL()
    {
        head = tail =  null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void clear()
    {
        head = tail = null;
        size = 0;
    }
    public void AddFirst(T el)
    {
        IntSLLNode<T> newest = new IntSLLNode(el, null, null);
        newest.next = head;
        if (head!=null) head.back=newest;
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
    public void AddLast(T el)
    {
        IntSLLNode<T> newest = new IntSLLNode(el, null, null);
        if (isEmpty()) head = tail = newest;
        else {
            tail.next = newest;
            newest.back=tail;
            tail = newest;
        }
    size++; 
    }


    public T get(int position) throws IndexOutOfBoundsException
    {
        int count=0;
        IntSLLNode<T> target= new IntSLLNode(0, null, null);
        IntSLLNode<T> tmp = head;
        while (count < position){
            target=tmp;
            tmp=tmp.next;
            count++;
        }
        if (count>size)  throw new IndexOutOfBoundsException();       
        return target.info;
    }
    public void Add(T el, int position) throws IndexOutOfBoundsException
    {
        int count=1;
        IntSLLNode<T> current = head;
        IntSLLNode<T> nex = head; 
        if (position==1) AddFirst(el);
        if (position==size) AddLast(el);
        if (position>size) System.out.println("Add fail");   
        else {
        while (count<position){
            current=nex;
            nex=nex.next;
            count++;
        }
        }
        IntSLLNode<T> add = new IntSLLNode(el, null, null);
        add.next=nex;
        nex.back=add;
        add.back=current;
        current.next=add; 
        size++;
    }
    public T RemoveFirst() throws Exception 
    {
        IntSLLNode<T> tmp = head; 
        head=tmp.next;
        if (isEmpty()) {
            throw new Exception("");
        }
        size--;
        return head.info;
    }
    public T RemoveLast() throws Exception
    {
        IntSLLNode<T> tmp = tail; 
        tail=tmp.back;
        if (head != null) {
            size--;
            return head.info;
        }
        throw new Exception("Empty");
    }
    public T RemoveAt(int position)  throws IndexOutOfBoundsException, Exception
    {
        IntSLLNode<T> target= new IntSLLNode(0, null, null);
        IntSLLNode<T> tmp = head;
        int count=1;
        if (position==1) return RemoveFirst();
        if (position==size) return RemoveLast();
        if (position>size) throw new Exception("Not exist at the positon "+ position);;        
        while (count < position){
            target=tmp;
            tmp=tmp.next;
            count++;
        }
        target.next=tmp.next;
        size--;
        return tmp.info;
    }
    public void reverse() // require take in place
    {
        IntSLLNode<T> current = head;
        IntSLLNode<T> nex = head; 
        IntSLLNode<T> pre = null;
        IntSLLNode<T> tmp = tail;
        while (nex != null){
            pre=current;
            current=nex;
            nex=nex.next;  
            if (pre==head) {
                pre.next=null;
                tmp=pre;
            }
            current.next=pre;
            current.back=nex;
        }
        head=current;
        tail=tmp;
    }
//    public void sort()
//    }
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
        IntSLL test = new IntSLL();
        for(int i = 0; i < 10; i++)
                test.AddFirst(i);
        try {
            test.printList();
            test.Add(20, 20);
//            test.RemoveFirst();
//            test.RemoveLast();
            test.RemoveAt(20);
//            test.reverse();
//            test.sort();
//            System.out.println(sll.get(5));
                
        } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
        }
    }	
}
