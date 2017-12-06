package queue;

public class QueueFullEx extends Exception {
	public QueueFullEx(){}
	public QueueFullEx(String Causa){
		super(Causa);
	}
	public QueueFullEx(Throwable Causa){
		super(Causa);
	}
}
