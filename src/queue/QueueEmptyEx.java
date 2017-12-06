package queue;

public class QueueEmptyEx extends Exception {
	public QueueEmptyEx(){}
	public QueueEmptyEx(String Causa){
		super(Causa);
	}
	public QueueEmptyEx(Throwable Causa){
		super(Causa);
	}
}
