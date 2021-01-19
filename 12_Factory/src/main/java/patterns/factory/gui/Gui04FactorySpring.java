package patterns.factory.gui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import patterns.factory.gui.Components.Frame;

public class Gui04FactorySpring {
	private static ClassPathXmlApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("gui-context.xml");
	}

	public static void main(String[] args) {
		CalculatorBuilder calcBuilder = ctx.getBean("calculatorBuilderBean", CalculatorBuilder.class);
		Frame f = calcBuilder.newCalculatorFrame();
		f.setVisible(true);
	}
}
