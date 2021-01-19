package patterns.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GroupFigure extends Figure {
	private final String name;
	private final List<Figure> figures = new ArrayList<>();

	public GroupFigure(String name, Figure... figures) {
		this.name = name;
		for (Figure f : figures) {
				addFigure(f);
		}
	}

	public void addFigure(Figure f) { // this version creates a flat structure of the entire thing -> removes possibility to go back to previous groups (doens't build a tree)
		if(!f.equals(this)) {
			if(f instanceof GroupFigure) {
				((GroupFigure)f).getFigures().forEach(fig -> {
					fig.setContained(false);
					addFigure(fig);
				});
				((GroupFigure)f).removeFigures();
			} else {
				if(!f.isContained()) {
					figures.add(f);
					f.setContained(true);
				} else throw new IllegalArgumentException("Figure f already belongs to another group");
			}
		}
	}

	public Stream<Figure> getFigures() {
		return figures.stream();
	}

	public void removeFigures() {
		figures.clear();

	}

	@Override
	public void draw(String prefix) {
		System.out.println(prefix + name);
		for (Figure f : figures) {
			f.draw(prefix + ">>");
		}
	}
}
