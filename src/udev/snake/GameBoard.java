package udev.snake;

import java.util.Random;

public class GameBoard {
	Block[][] playGround;
	Wall wall = new Wall("W");
	Fruit fruit = new Fruit("F");
	Empty empty = new Empty(" ");
	Snake snake = new Snake("S");
	int pos_col;
	int pos_line;
	Random random = new Random();

	public GameBoard(int nbCol, int nbLine) {

		playGround = new Block[nbLine][nbCol];

		// Remplir premier ligne
		for (int i = 0; i < nbCol; i++) {
			playGround[0][i] = wall;
		}

		// Remplir dernier ligne
		for (int i = 0; i < nbCol; i++) {
			playGround[nbLine - 1][i] = wall;
		}

		// Remplir premier col
		for (int j = 0; j < nbLine; j++) {
			playGround[j][0] = wall;
		}

		// Remplir dernier col
		for (int j = 0; j < nbLine; j++) {
			playGround[j][nbCol - 1] = wall;
		}

		for (int i = 0; i < playGround.length; i++) {
			for (int j = 0; j < playGround[i].length; j++) {
				if (playGround[i][j] == null) {
					playGround[i][j] = empty;
				}
			}
		}

		// Generation les pos_col pos_line n-fois pour nous nous tombons sur un block empty
		while (playGround[pos_col][pos_line] != empty) {
			generatePositionsAleat(nbCol, nbLine);
		}
	}

	//	// Creation fruit
	//	public void setFruit(Fruit fruit) {
	//		Block[][] pg = this.getPlayGround();
	//		if (pg[1][1] == null) {
	//			pg[1][1] = fruit;
	//		}
	//	}

	public Block[][] getPlayGround() {
		return playGround;
	}

	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < playGround.length; i++) {
			for (int j = 0; j < playGround[i].length; j++) {
				res += playGround[i][j].getSymbol();
			}
			if (i + 1 != playGround.length) {
				res += "\n";
			}
		}
		return res;
	}

	static GameBoard createGameBoard(int nbCol, int nbLine) throws IllegalArgumentException{
		if (nbCol >= 3 && nbLine >=3) {
			GameBoard gb = new GameBoard(nbCol, nbLine);
			return gb;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void generateSnake() throws NoSnakeGeneratedException {
		if (playGround[pos_col][pos_line].equals(empty)) {
			playGround[pos_col][pos_line] = snake;
		} else {
			throw new NoSnakeGeneratedException("No Snake Generated Exception");
		}
	}

	public void generateFood() throws NoFoodGeneratedException {
		if (playGround[pos_col][pos_line].equals(empty)) {
			playGround[pos_col][pos_line] = fruit;
		} else {
			throw new NoFoodGeneratedException("No Food Generated Exception");
		}
	}

	private void generatePositionsAleat(int nbCol, int nbLine) {
		// Generation position pour le snake et fruit
		pos_col = random.nextInt(nbCol - 1);
		pos_line = random.nextInt(nbLine - 1);
	}
}
