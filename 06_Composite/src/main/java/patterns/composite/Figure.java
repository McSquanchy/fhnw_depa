package patterns.composite;

public abstract class Figure {
	private boolean contained = false;
	public abstract void draw(String prefix);
	public boolean isContained(){
		return contained;
	}
	public void setContained(boolean status) {
		contained = status;
	}
}
