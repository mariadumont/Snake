
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class SpecialFood extends Food implements ActionListener {

    private int visibleTime;
    private Timer timer;
    private Board board;

    //  public static Timer timerCountDown;
    private ScoreBoard scoreBoard;
    private int delay;

    //  ActionListener actionToPreform;
    public SpecialFood(Snake snake, Board board) {
        super(snake);

        visibleTime = getRandomTime();
        timer = new Timer(visibleTime, this);
        this.board = board;
        nodeFood.color = Color.PINK;
        timer.start();

        /* delay = 1000;

        this.actionToPreform = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (visibleTime > 0) {
                    visibleTime--;
                    board.displayTimeLeft();
                }
            }
        };

        timerCountDown = new Timer(delay, actionToPreform);*/
    }

    public int getRandomTime() {
        return (int) (Math.random() * 21 + 10) * 1000;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        board.removeSpecialFood();
        timer.stop();

    }

    public int getVisibleTime() {
        return visibleTime;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public int getRandomScore() {
        return (int) (Math.random() * 3 + 3); //entre 3 y 5
    }

}
