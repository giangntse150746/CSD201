package pkg;

import java.util.LinkedList;
import java.util.EmptyStackException;


public class Stack<T> {
	LinkedList<T> l = new LinkedList<T>();	
	public void push(T el)
	{
		l.addLast(el);		
	}	
	public T pop() throws EmptyStackException
	{
		if(l.isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return l.removeLast();
		}
	}	
	public boolean isEmpty()
	{
		return l.isEmpty();
	}
	public void printAll()
	{	
		Stack<T> tmp = new Stack<T>();
		while(!this.isEmpty())
		{
			T el = pop();
			System.out.print(el + " ");
			tmp.push(el);
		}
		
		while(!tmp.isEmpty())
		{
			this.push(tmp.pop());
		}
		
		System.out.println();
	}
	
	public void clear()
	{
		l.clear();
	}
	
	public T topEl() throws EmptyStackException
	{
		if(l.isEmpty())
		{
			throw new EmptyStackException();
		}

		return l.getLast();
	}

	public String toString()
	{
		return l.toString();
	}
	
	public int Size()
	{
		return l.size();
	}
	
}
