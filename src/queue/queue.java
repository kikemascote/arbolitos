package queue;

import java.util.Iterator;

public class queue<T> implements queue.iqueue<T>,Iterable<T> {
	
	private qnode<T> start = null, end = null;
	qnode<T> back;
	qnode<T> front;
	int count = 0;
	int size  = 10;
	
	
	public queue(){
		start = new qnode<T>();
		start.setIndex(-1);
		end = new qnode<T>();
		end.setIndex(-1);
		qnode<T> n = new qnode<T>();
		start.setNext(n);
		n.setBack(start);
		qnode<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			qnode<T> nuevo = new qnode<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	
	public queue(int size){
		this.size = size;
		start = new qnode<T>();
		start.setIndex(-1);
		end = new qnode<T>();
		end.setIndex(-1);
		qnode<T> n = new qnode<T>();
		start.setNext(n);
		n.setBack(start);
		qnode<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			qnode<T> nuevo = new qnode<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	public void index(){
		qnode<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			qnode<T> tmp = back.getBack();
			int i = 0;
			@Override
			public boolean hasNext() {
				if(tmp.getNext() == null)
					tmp = start.getNext();
				else
					tmp = tmp.getNext();
				return i++ != count;
			}
			@Override
			public T next() {
				return tmp.getValue();
			}
		};
	}


	@Override
	public void enQueue(T value) throws queue.QueueFullEx {
		if(IsFull()) throw new queue.QueueFullEx("La cola est� llena");
		front.setValue(value);
		count++;
		if(front.getNext() == null)
			front = start.getNext();
		else
			front = front.getNext();
		
	}


	@Override
	public T deQueue() throws queue.QueueEmptyEx {
		if(IsEmpty()) throw new queue.QueueEmptyEx("La cola est� vac�a");
		T tmp=back.getValue();
		back.setValue(null);
		count--;
		if(back.getNext() == null)
			back = start.getNext();
		else
			back = back.getNext();
		return tmp;
	}


	@Override
	public boolean IsEmpty() {
		return (count == 0);
	}


	@Override
	public boolean IsFull() {
		return (count == size);
	}


	@Override
	public T front() throws queue.QueueEmptyEx {
		if(IsEmpty()) throw new queue.QueueEmptyEx("La cola est� vac�a");
		return back.getValue();
	}


	@Override
	public qnode<T> search(T value) throws queue.QueueEmptyEx {
		if(IsEmpty()) throw new queue.QueueEmptyEx("Pila vac�a");
		qnode<T> tmp = back;
		int i = 0;
		while (i<=count){
			i++;
			if (tmp.getValue().equals(value))
				return tmp;
			if(tmp.getNext() == null)
				tmp = start.getNext();
			else
				tmp = tmp.getNext();
		}
		return null;
	}


	@Override
	public void clear() {
		while(!IsEmpty())
			try {
				deQueue();
			} catch (queue.QueueEmptyEx e) {
				e.printStackTrace();
			}
	}


	@Override
	public int size() {
		return count;
	}
}
