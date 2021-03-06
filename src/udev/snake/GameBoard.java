package udev.snake;

import java.util.Random;

public class GameBoard {

	Block[][] playGround;
	Wall wall = new Wall("W");
	Fruit fruit = new Fruit("F");
	Empty empty = new Empty(" ");
	Snake snake = new Snake("S");
	int posCol;
	int posLine;
	int nbCol;
	int nbLine;
	int startPosSnakeX;
	int startPosSnakeY;
	Random random = new Random();

	public int getStartPosSnakeX() {
		return startPosSnakeX;
	}

	public int getStartPosSnakeY() {
		return startPosSnakeY;
	}

	public int getNbCol() {
		return nbCol;
	}

	public void setNbCol(int nbCol) {
		this.nbCol = nbCol;
	}

	public int getNbLine() {
		return nbLine;
	}

	public void setNbLine(int nbLine) {
		this.nbLine = nbLine;
	}

	// Creation GameBoard
	public GameBoard(int nbCol, int nbLine) {

		setNbCol(nbCol);
		setNbLine(nbLine);

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

		// Mettre les blocks emptys
		for (int i = 0; i < playGround.length; i++) {
			for (int j = 0; j < playGround[i].length; j++) {
				if (playGround[i][j] == null) {
					playGround[i][j] = empty;
				}
			}
		}
	}

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
			// Une condition pour eviter � ajouter "\n" apres la dernier colonne
			if (i + 1 != playGround.length) {
				res += "\n";
			}
		}
		return res;
	}

	static GameBoard createGameBoard(int nbCol, int nbLine) throws IllegalArgumentException{
		if (nbCol >= 3 && nbLine >=3) {
			GameBoard gb = new GameBoard(nbCol, nbLine);
			System.out.println(gb.toString());
			return gb;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void generateSnake() throws NoSnakeGeneratedException {

		if ((nbCol == 3 && nbLine == 3) && playGround[1][1].equals(fruit)) {
			throw new NoSnakeGeneratedException("No Snake Generated Exception");
		}

		// Generation les posCol et posLine n-fois pour pour trouver un block empty
		while (playGround[posCol][posLine] != empty) {
			generatePositionsAleat(nbCol, nbLine);
		}

		if (playGround[posCol][posLine].equals(empty)) {
			playGround[posCol][posLine] = snake;
			System.out.println(this.toString());
		} else {
			throw new NoSnakeGeneratedException("No Snake Generated Exception");
		}
	}

	// Generation les pos_col pos_line n-fois pour nous nous tombons sur un block empty
	public void generateFood() throws NoFoodGeneratedException {
		// Si on a 3x3 il faut verifier si la place est disponible
		if ((nbCol == 3 && nbLine == 3) && playGround[1][1].equals(snake)) {
			throw new NoFoodGeneratedException("No Food Generated Exception");
		}

		while (playGround[posCol][posLine] != empty) {
			generatePositionsAleat(nbCol, nbLine);
		}
		if (playGround[posCol][posLine].equals(empty)) {
			playGround[posCol][posLine] = fruit;
			System.out.println(this.toString());
		} else {
			throw new NoFoodGeneratedException("No Food Generated Exception");
		}
	}

	private void generatePositionsAleat(int nbCol, int nbLine) {
		// Generation position pour le snake et fruit
		posCol = (int) (Math.random() * (playGround.length - 1));
		posLine = (int) (Math.random() * (playGround[0].length - 1));
	}

	public void addSnake(int i, int j) {
		startPosSnakeY = i;
		startPosSnakeX = j;
		if (playGround[i][j].equals(empty) || playGround[i][j].equals(fruit)) {
			playGround[i][j] = snake;
		}
	}

	public void addFood(int i, int j) {
		if (playGround[i][j].equals(empty)) {
			playGround[i][j] = fruit;
		}
	}
}
