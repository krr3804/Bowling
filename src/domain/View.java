package domain;

import java.util.ArrayList;

public class View {
	private static final String STRIKE = "X";
	private static final String SPAIRE = "/";
	private static final String GUTTER = "-";

	private static final int FINAL_FRAME = 10;
	
	private String round;
	private String score;
	private String totalScore;
	private ResultScore resultScore;
	
	public View () {
		round = "";
		score = "";
		totalScore = "";
		resultScore = new ResultScore();
	}
	
	public void showBowlingGame(ArrayList<Frame> frames, Players player) {
		for(int i=0;i<frames.size();i++) {
			Frame frame = frames.get(i);
			setRound(frame.getFrameNum());
			resultScore.calculateTotalScore(frame.getScore());
			if(frame.getState() != "NORMAL") {
				resultScore.calculateScoreWithNextFrame(frame.getState(), frames.get(i+1));
			}
			
			setScore(frame.getScore(), frame.getState());
			setTotalScore(resultScore.getTotalScore());
			
		}
		System.out.println("Player : " + player.getName());
		System.out.println(round);
		System.out.println(score);
		System.out.println(totalScore);
	}
	private void setTotalScore(int totalScore) {
		this.totalScore += totalScore + "      || ";
		
	}

	private void setScore(int[] scores, String state) {
		for(int i=0;i<scores.length;i++) {
			String convertScore = String.valueOf(scores[i]);
			
			if(scores[i] == 0) {
				convertScore = GUTTER;
			}
			if(state.equals("STRIKE") && i==0) {
				convertScore = STRIKE;
			}
			if(state.equals("SPAIRE") && i == scores.length-1) {
				convertScore = SPAIRE;
			}
			
			score += convertScore + "   ";
		}
		score += "|| ";
	}

	private void setRound(int frameNum) {
		String thisRound = frameNum + " Frame || ";
		
		round += thisRound;
		

	}
}
