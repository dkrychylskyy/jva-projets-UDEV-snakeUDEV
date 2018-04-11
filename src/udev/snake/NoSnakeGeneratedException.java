package udev.snake;

public class NoSnakeGeneratedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSnakeGeneratedException(String message) {
		super(message);
	}
}
