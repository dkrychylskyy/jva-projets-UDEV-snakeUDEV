package udev.snake;

public class Main {

	public static void main(String[] args) {
		GameBoard gb = new GameBoard(5, 5);
		try {
			gb.generateFood();
		} catch (NoFoodGeneratedException e) {
			System.out.println(e.getMessage());
		}
		try {
			gb.generateSnake();
		} catch (NoSnakeGeneratedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(gb.toString());
	}
}
