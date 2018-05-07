
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class ScoreBoard extends JLabel {

    private int score;
    private int level;

    public ScoreBoard() {
        score = 0;
        level = 1;
    }

    public void pause() {
        setText("Level: " + level + " · Score: " + score + " PAUSED");

    }

    public void resume() {
        setText("Level: " + level + " · Score: " + score);
    }

    public void increment(int points) {
        score += points;

        setText("Level: " + level + " · Score: " + score);

    }

    public void reset() {
        score = 0;
        level = 1;
        setText("Level: " + level + " · Score: " + score);
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /*public void specialFoodTime() {
        
        setText("Level: " + level + " · Score: " + score + " · Time: " + SpecialFood.timerCountDown);
    }*/
}
