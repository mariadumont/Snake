
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Food {

    private Node nodeFood;
    private Snake snake;

    
    public Food(Snake snake) {
        nodeFood = new Node(getRandomRow(), getRandomCol(), Color.yellow);
        while (Node.checkNodesHit(nodeFood, snake.getListNodes().get(0))) {
            nodeFood = new Node(getRandomRow(), getRandomCol(), Color.yellow);
        }
    }

    public void drawFood(Graphics g, int squareWidth, int squareHeight) {
        Util.drawSquare(g, nodeFood, squareWidth, squareHeight);
    }

    public int getRandomCol() {
        return (int) (Math.random() * Board.NUM_COLS + 1); //(Math.random()*(N - M + 1) + M) Valor entre M y N, ambos incluidos
    }

    public int getRandomRow() {
        return (int) (Math.random() * Board.NUM_ROWS + 1);
    }

    public Node getNodeFood() {
        return nodeFood;
    }

   

}
