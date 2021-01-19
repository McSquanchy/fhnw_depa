package patterns.composite;

public class OvalFigure extends Figure {
	private final String name;

	public OvalFigure(String name) {
		this.name = name;
	}

	@Override
	public void draw(String prefix) {
		System.out.println(prefix + name);
	}
}
