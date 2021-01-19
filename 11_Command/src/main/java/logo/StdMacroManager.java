package logo;

import logo.commands.Command;
import logo.commands.turtle.CompositeCommand;
import logo.commands.turtle.TurtleCommand;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StdMacroManager implements MacroManager {
	private final LogoInterpreter interpreter;
	private boolean recording = false;
	private final Map<String,CompositeCommand> macros = new HashMap<>();
	private CompositeCommand currentMacro;
	public StdMacroManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}

	/**
	 * Indicates whether a macro is currently being recorded.
	 */
	@Override
	public boolean isRecordingMacro() {
		return recording;
	}

	/**
	 * Adds a command to the current macro. If this method is invoked while no
	 * macro is being recorded, then a NullPointerException should be thrown.
	 */
	@Override
	public void addCommand(TurtleCommand command) {
		interpreter.setColor(Color.RED);
		command.execute();
		if(!recording) throw new NullPointerException();
		else currentMacro.add(command);

	}

	/**
	 * Starts the recording of a new macro.
	 */
	@Override
	public void startMacro(String name) {
		recording = true;
		currentMacro = new CompositeCommand(name);
	}

	/**
	 * Closes the recording of the current macro and registers the macro under its
	 * name.
	 */
	@Override
	public void endMacro() {
		recording = false;
		macros.put(currentMacro.getName(), currentMacro);
		interpreter.resetTurtle();
		interpreter.setColor(Color.BLACK);
	}

	/**
	 * Returns the macro command with a given name. If no macro can be found with
	 * this name, then a NotFoundCommand is returned.
	 */
	@Override
	public Command getCommand(String name) {
		return macros.get(name);
	}
}
