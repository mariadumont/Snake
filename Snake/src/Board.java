
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
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
                    snake.setDirection(DirectionType.LEFT);

                    /*   if (canMoveTo(currentShape, currentRow, currentCol - 1)) {
                        currentCol--;
                    }*/
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.setDirection(DirectionType.RIGHT);

                    break;
                case KeyEvent.VK_UP:
                    snake.setDirection(DirectionType.UP);

                    break;
                case KeyEvent.VK_DOWN:
                    snake.setDirection(DirectionType.DOWN);
                    break;

                case KeyEvent.VK_P:
                    if (!timer.isRunning()) {
                        //scoreBoard.resume();
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

        deltaTime = 500;
        timer = new Timer(deltaTime, this);
        myKeyAdepter = new MyKeyAdapter();
        snake = new Snake();

        food = null;

    }

    public void initGame() {
        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);
        timer.start();

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
        snake.move();
        eat();
        repaint();
    }

    public void eat() {
        if (snake.getListNodes().get(0).checkNodesHit(snake.getListNodes().get(0), food.getNodeFood())) {
            food = new Food(snake);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
