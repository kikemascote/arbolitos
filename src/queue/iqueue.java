package queue;


public interface iqueue<T> {
	void enQueue(T value) throws queue.QueueFullEx;
	T deQueue() throws queue.QueueEmptyEx;
	boolean IsEmpty();
	boolean IsFull();
	T front() throws queue.QueueEmptyEx;
	qnode<T> search(T value) throws queue.QueueEmptyEx;
	void clear();
	int size();

}
