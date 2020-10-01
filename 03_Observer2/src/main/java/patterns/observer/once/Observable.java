package patterns.observer.once;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private final List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	protected void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this);
		}
		// observers.forEach(obs -> obs.update(this));
	}
}
