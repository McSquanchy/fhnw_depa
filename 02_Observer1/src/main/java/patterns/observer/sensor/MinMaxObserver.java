package patterns.observer.sensor;

import patterns.observer.Observable;


// CONCRETE OBSERVER
public class MinMaxObserver extends AbstractObserver {
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;

	public MinMaxObserver(Sensor s) {
		super(s);
		sensor = s;
		sensor.addObserver(this); // WICHTIG!!

	@Override
	public void updatePull(Observable source) {
		if (source == sensor) {
			int temp = sensor.getTemperature();
			if (temp > max) {
				System.out.println("New maximum: " + temp);
				max = temp;
			}
			if (temp < min) {
				System.out.println("New minimum: " + temp);
				min = temp;
			}
		}
	}
	@Override // value könnte hier auch direkt int sein
	public void updatePush(Observable source, Object value) {
		if (source == sensor) {
			int temp = (int) value;
			// [...same as Pull]
		}
	}
	public int getMinimum() {
		return min;
	}
	public int getMaximum() {
		return max;
	}
}
