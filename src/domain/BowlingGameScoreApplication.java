package domain;

public class BowlingGameScoreApplication {

	public static void main(String[] args) {
		Players player = new Players("Test");
		
		BowlingGame bowlingGame = new BowlingGame(player);
		
		bowlingGame.startGame();
	}
}
