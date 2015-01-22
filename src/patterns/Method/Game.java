package patterns.Method;


	public abstract class Game {
		
		public enum GameCode {
			 CHESS,
			 MONOPOLY
			}	

	 private int playersAmount;

	 protected abstract void initializeGame();

	 protected abstract void playGame();

	 protected abstract void endGame();

	 protected abstract void printWinner();

	public void playOneGame(int playersAmount) {
		setPlayersAmount(playersAmount);

		initializeGame();
		playGame();
		endGame();

		printWinner();
	}

	 public void setPlayersAmount(int playersAmount){
	 this.playersAmount = playersAmount;
	 }

	}

	





	
