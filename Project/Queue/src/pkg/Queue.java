package pkg;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Queue<T> {
	LinkedList<T> l =  new LinkedList<T>();
	public void enqueue(T el)
	{
		l.addLast(el);
	}
	
	public T dequeue() throws EmptyStackException
	{
            if (l.isEmpty()) {
                throw new EmptyStackException();
            }
            else
                return l.removeFirst();
	}
	
	public boolean isEmpty()
	{
            if (l.size()==0) {
                return true;
            }
            return false;
	}
	
	public int Size()
	{
            return l.size();
	}
	
	public T front() throws EmptyStackException
	{
            if (l.isEmpty()) {
                throw new EmptyStackException();
            }
            else
                return l.getFirst();
	}
	
	public void clear()
	{
            if (l.isEmpty()) {
                throw new EmptyStackException();
            }
            else
                l.clear();
	}	

    @Override
    public String toString() {
        return "Queue{" + "l=" + l + '}';
    }
}

