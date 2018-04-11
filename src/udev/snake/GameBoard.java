package udev.snake;

public class GameBoard {
	Block[][] playGround;
	Wall wall = new Wall("W");
	Fruit fruit = new Fruit("f");
	Empty empty = new Empty(" ");
	
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
		
		//this.setFruit(fruit);
	}
	
	// Creation fruit
	public void setFruit(Fruit fruit) {
		Block[][] pg = this.getPlayGround();
		if (pg[1][1] == null) {
			pg[1][1] = fruit;
		}
	}
	
	public Block[][] getPlayGround() {
		return playGround;
	}

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
	
	static GameBoard createGameBoard(int nbCol, int nbLine) {
		GameBoard gb = new GameBoard(nbCol, nbLine);
		return gb;
	}
}
