package udev.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameMotorTest {

	GameBoard gameBoard = GameBoard.createGameBoard(5,5);

	@Test
	public void canMove_UP_When_LEFT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_DOWN_When_LEFT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_LEFT_When_LEFT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_RIGHT_When_LEFT_False() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		boolean expected = false;
		boolean actual = gm.canMove(Direction.RIGHT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_UP_When_UP_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_DOWN_When_UP_False() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		boolean expected = false;
		boolean actual = gm.canMove(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_LEFT_When_UP_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_RIGHT_When_UP_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.RIGHT);
		assertEquals(expected, actual);
	}


	@Test
	public void canMove_UP_When_RIGHT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_DOWN_When_RIGHT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_LEFT_When_RIGHT_False() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		boolean expected = false;
		boolean actual = gm.canMove(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_RIGHT_When_RIGHT_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.RIGHT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_UP_When_DOWN_False() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		boolean expected = false;
		boolean actual = gm.canMove(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_DOWN_When_DOWN_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_LEFT_When_DOWN_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void canMove_RIGHT_When_DOWN_True() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		boolean expected = true;
		boolean actual = gm.canMove(Direction.RIGHT);
		assertEquals(expected, actual);
	}

	@Test
	public void move_RIGHT_OK() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		int expected = 0;
		int actual = gm.move(Direction.RIGHT);
		assertEquals(expected, actual);
	}

	@Test
	public void move_RIGHT_RIGHT_Then_Wall() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.RIGHT);
		int expected = -1;
		gm.move(Direction.RIGHT);
		int actual = gm.move(Direction.RIGHT);
		assertEquals(expected, actual);
	}


	@Test
	public void move_LEFT_OK() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		int expected = 0;
		int actual = gm.move(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void move_LEFT_LEFT_Then_Wall() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		int expected = -1;
		gm.move(Direction.LEFT);
		int actual = gm.move(Direction.LEFT);
		assertEquals(expected, actual);
	}

	@Test
	public void move_UP_OK() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		int expected = 0;
		int actual = gm.move(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void move_Up_UP_Then_Wall() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.UP);
		int expected = -1;
		gm.move(Direction.UP);
		int actual = gm.move(Direction.UP);
		assertEquals(expected, actual);
	}

	@Test
	public void move_DOWN_OK() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		int expected = 0;
		int actual = gm.move(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void move_DOWN_DOWN_Then_Wall() {
		gameBoard.addSnake(2, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		int expected = -1;
		gm.move(Direction.DOWN);
		int actual = gm.move(Direction.DOWN);
		assertEquals(expected, actual);
	}

	@Test
	public void move_DOWN_Then_Food() {
		gameBoard.addSnake(2, 2);
		gameBoard.addFood(3, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.DOWN);
		int expected = 1;
		int actual = gm.move(Direction.DOWN);
		assertEquals(expected, actual);
	}


	@Test
	public void move_LEFT_DOWN_RIGHT_Then_Food() {
		gameBoard.addSnake(2, 2);
		gameBoard.addFood(3, 2);
		GameMotor gm = new GameMotor(gameBoard, Direction.LEFT);
		gm.move(Direction.LEFT);
		gm.move(Direction.DOWN);
		int expected = 1;
		int actual = gm.move(Direction.RIGHT);
		assertEquals(expected, actual);
	}

}