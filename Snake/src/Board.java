
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
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
public class Board extends JPanel implements ActionListener {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (!(snake.getDirection() == DirectionType.RIGHT)) {
                        snake.setDirection(DirectionType.LEFT);
                    }

                    break;
                case KeyEvent.VK_RIGHT:
                    if (!(snake.getDirection() == DirectionType.LEFT)) {
                        snake.setDirection(DirectionType.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (!(snake.getDirection() == DirectionType.DOWN)) {
                        snake.setDirection(DirectionType.UP);
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (!(snake.getDirection() == DirectionType.UP)) {
                        snake.setDirection(DirectionType.DOWN);
                    }
                    break;

                case KeyEvent.VK_P:
                    if (!timer.isRunning()) {
                        scoreBoard.resume();
                        timer.start();
                    } else {
                        timer.stop();
                        scoreBoard.pause();

                    }
                    break;

                default:
                    break;
            }
            repaint();
        }

    }

    private int deltaTime;
    private Food food;
    private SpecialFood specialFood;
    private Snake snake;

    private Timer timer;

    private MyKeyAdapter myKeyAdepter;
    private ScoreBoard scoreBoard;

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    private Game game;

    public Board() {
        super();
        initComponents();
        setFocusable(true);

        deltaTime = 300;
        timer = new Timer(deltaTime, this);
        myKeyAdepter = new MyKeyAdapter();
        snake = new Snake();

        food = null;
        specialFood = null;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void initGame() {

        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);
        timer.start();

        scoreBoard.reset();

        snake = new Snake();

        food = new Food(snake);

    }

    private int squareWidth() {
        return getWidth() / NUM_COLS;
    }

    private int squareHeight() {
        return getHeight() / NUM_ROWS;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.drawSnake(g, squareWidth(), squareHeight());
        if (food != null) {
            food.drawFood(g, squareWidth(), squareHeight());
        }
        if (specialFood != null) {
            specialFood.drawFood(g, squareWidth(), squareHeight());
        }

        drawBorder(g);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (snake.hitWall() || snake.hitItself()) {
            gameOver();

        } else {
            snake.move();
            eat();
            eatSpecialFood();

        }

        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public void eat() {
        if (snake.getNodeHead().checkNodesHit(snake.getNodeHead(), food.getNodeFood())) {

            scoreBoard.increment(1);

            food = new Food(snake);

            if (scoreBoard.getScore() % 2 == 0) {
                specialFood = new SpecialFood(snake, this);

            }

            incrementLevel();

            snake.setCountGrowSnake(1);
        }
    }

    public void eatSpecialFood() {
        if (specialFood != null) {
            // scoreBoard.setText("Level: " + scoreBoard.getLevel() + " · Score: " + scoreBoard.getScore() + " · " + specialFood.getVisibleTime());
            
            scoreBoard.specialFoodTime();
            
            if (snake.getNodeHead().checkNodesHit(snake.getNodeHead(), specialFood.getNodeFood())) {
                scoreBoard.increment(3);

                snake.setCountGrowSnake(3);

                specialFood = null;
                incrementLevel();
            }
        }
    }

    public boolean incrementLevel() {
        if (scoreBoard.getScore() % 5 == 0) {
            if (!(deltaTime < 100)) {
                deltaTime -= 150;
                scoreBoard.setLevel(scoreBoard.getLevel() + 1);
                return true;
            } else {
                scoreBoard.setLevel(scoreBoard.getLevel() + 1);
                return true;
            }
        }
        return false;
    }

    public void gameOver() {

        scoreBoard.setText("GAME OVER");

        removeKeyListener(myKeyAdepter);
        timer.stop();
    }

    public void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, NUM_COLS * squareWidth(), NUM_ROWS * squareHeight());
    }

    public void removeSpecialFood() {
        specialFood = null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
