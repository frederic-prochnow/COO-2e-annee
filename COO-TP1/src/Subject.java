import java.util.ArrayList;
import java.util.List;

public abstract class Subject  {
	
	List<Observer> observers = new ArrayList<>();

	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObserver(){
		for(Observer observer : observers){
			observer.update();
		}
	}
}
