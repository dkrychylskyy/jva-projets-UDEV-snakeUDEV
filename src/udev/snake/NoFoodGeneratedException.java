package udev.snake;

public class NoFoodGeneratedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoFoodGeneratedException(String message) {
		super(message);
	}
}
