/**
 * 
 */
package patterns.Method;

/**
 * @author user
 *
 */
public class GamesManager {

	public static void main(String[] args) {
		final Game.GameCode gameCode = Game.GameCode.CHESS;

		Game game;

		switch (gameCode) {
		case CHESS:
			game = new Chess();
			break;
		case MONOPOLY:
			game = new Monopoly();
			break;
		default:
			throw new IllegalStateException();
		}

		game.playOneGame(2);
	}
}