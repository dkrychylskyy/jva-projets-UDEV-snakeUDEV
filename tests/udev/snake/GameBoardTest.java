package udev.snake;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GameBoardTest {

	@Test(expected=IllegalArgumentException.class)
	public void create_2_2_Board() {
		GameBoard.createGameBoard(2, 2);
		fail("No expected exception");
	}

	@Test
	public void create_3_3_Board() {
		String expected =
				"WWW"+"\n"+
						"W W"+"\n"+
						"WWW";
		String actual = GameBoard.createGameBoard(3, 3).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void create_4_4_Board() {
		String expected =
				"WWWW"+"\n"+
						"W  W"+"\n"+
						"W  W"+"\n"+
						"WWWW";
		String actual = GameBoard.createGameBoard(4, 4).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void create_5_5_Board() {
		String expected =
				"WWWWW"+"\n"+
						"W   W"+"\n"+
						"W   W"+"\n"+
						"W   W"+"\n"+
						"WWWWW";
		String actual = GameBoard.createGameBoard(5, 5).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void create_5_4_Board() {
		String expected =
				"WWWWW"+"\n"+
						"W   W"+"\n"+
						"W   W"+"\n"+
						"WWWWW";
		String actual = GameBoard.createGameBoard(5, 4).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void create_4_5_Board() {
		String expected =
				"WWWW"+"\n"+
						"W  W"+"\n"+
						"W  W"+"\n"+
						"W  W"+"\n"+
						"WWWW";
		String actual = GameBoard.createGameBoard(4, 5).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void generatedFood_OK() throws NoFoodGeneratedException {
		String expected =
				"WWW"+"\n"+
						"WFW"+"\n"+
						"WWW";
		GameBoard gb = GameBoard.createGameBoard(3, 3);
		gb.generateFood();
		String actual = gb.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void generatedSnake_OK() throws NoSnakeGeneratedException {
		String expected =
				"WWW"+"\n"+
						"WSW"+"\n"+
						"WWW";
		GameBoard gb = GameBoard.createGameBoard(3, 3);
		gb.generateSnake();
		String actual = gb.toString();
		assertEquals(expected, actual);
	}

	@Test(expected=NoSnakeGeneratedException.class)
	public void generatedSnake_KO() throws NoFoodGeneratedException, NoSnakeGeneratedException {
		GameBoard gb = GameBoard.createGameBoard(3, 3);
		gb.generateFood();
		gb.generateSnake();
	}

	@Test(expected=NoFoodGeneratedException.class)
	public void generatedFood_KO() throws NoFoodGeneratedException, NoSnakeGeneratedException {
		GameBoard gb = GameBoard.createGameBoard(3, 3);
		gb.generateSnake();
		gb.generateFood();
	}

}