package udev.snake;

public class GameMotor {
	private GameBoard gb;
	public Direction direction;
	public Direction up = Direction.UP;
	public Direction down = Direction.DOWN;
	public Direction left = Direction.LEFT;
	public Direction right = Direction.RIGHT;
	public Empty empty;

	public GameMotor(GameBoard gb, Direction direction) {
		super();
		this.setGb(gb);
		this.setDirection(direction);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public GameBoard getGb() {
		return gb;
	}

	public void setGb(GameBoard gb) {
		this.gb = gb;
	}

	public boolean canMove(Direction direction) {

		switch (direction) {
		case UP:
			if (this.direction == Direction.LEFT) {
				return true;
			} else if (this.direction == Direction.UP) {
				return true;
			} else {
				if (this.direction == Direction.RIGHT) {
					return true;
				}
			}
			break;
		case DOWN:
			if (this.direction == Direction.DOWN) {
				return true;
			} else if (this.direction == Direction.LEFT) {
				return true;
			} else if (this.direction == Direction.RIGHT) {
				return true;
			}
			break;
		case RIGHT:
			if (this.direction == Direction.UP) {
				return true;
			}
			else if (this.direction == Direction.RIGHT) {
				return true;
			} else if (this.direction == Direction.DOWN) {
				return true;
			}
			break;
		case LEFT:
			if (this.direction == Direction.UP) {
				return true;
			} else if (this.direction == Direction.DOWN) {
				return true;
			} else if (this.direction == Direction.LEFT) {
				return true;
			}

		default:
			break;
		}
		return false;
	}

	public int move(Direction direction) {
		Block[][] pg = gb.getPlayGround();
		int posSnakeX = gb.getStartPosSnakeX();
		int posSnakeY = gb.getStartPosSnakeY();

		switch (direction) {
		case RIGHT:
			if (canMove(direction)) {
				if (pg[posSnakeY][posSnakeX + 1].getSymbol() == " ") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeX += 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 0;
				}else if (pg[posSnakeY][posSnakeX + 1].getSymbol() == "F") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeX += 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 1;
				} else {
					return -1;
				}
			}
			break;
		case LEFT:
			if (canMove(direction)) {
				if (pg[posSnakeY][posSnakeX - 1].getSymbol() == " ") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeX -= 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 0;
				}else if (pg[posSnakeY][posSnakeX + 1].getSymbol() == "F") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeX -= 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
				} else {
					return -1;
				}
			}
			break;
		case DOWN:
			if (canMove(direction)) {
				if (pg[posSnakeY + 1][posSnakeX].getSymbol() == " ") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeY += 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 0;
				}else if (pg[posSnakeY + 1][posSnakeX].getSymbol() == "F") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeY += 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 1;
				} else {
					return -1;
				}
			}
		case UP:
			if (canMove(direction)) {
				if (pg[posSnakeY - 1][posSnakeX].getSymbol() == " ") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeY -= 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 0;
				}else if (pg[posSnakeY - 1][posSnakeX].getSymbol() == "F") {
					pg[posSnakeY][posSnakeX] = gb.empty;
					posSnakeY -= 1;
					gb.addSnake(posSnakeY, posSnakeX);
					changeDirection(direction);
					System.out.println(gb.toString());
					return 1;
				} else {
					return -1;
				}
			}
		default:
			break;
		}
		return 0;
	}

	// On chanche la direction en cas de succes
	public void changeDirection(Direction direction) {
		this.direction = direction;
	}
}
