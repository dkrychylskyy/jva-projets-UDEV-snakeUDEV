package udev.snake;

public class GameMotor {
	private GameBoard gb;
	public Direction direction;
	public Direction up = Direction.UP;
	public Direction down = Direction.DOWN;
	public Direction left = Direction.LEFT;
	public Direction right = Direction.RIGHT;
	public Empty empty;

	public Block testSymbol = new TestSymbol("T");


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

	public int move(Direction right) {
		Block[][] pg = gb.getPlayGround();
		switch (direction) {
		case RIGHT:
			if (pg[2][2 + 2].getSymbol() != " ") {
				return -1;
			} else if (pg[2][2 + 1].getSymbol() == " ") {
				return 0;
			}
			break;
		default:
			break;
		}
		return 0;
	}
}
