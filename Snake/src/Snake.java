
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Snake {

    ArrayList<Node> listNodes;

    private DirectionType directionType;

    Snake() {
        Color colorHead;

        listNodes = new ArrayList<Node>(3);
        
        
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2, Color.green.darker()));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1, Color.green));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2, Color.green));

    }

    public void drawSnake(Graphics g, int squareWidth, int squareHeight) {

        for (Node n : listNodes) {
            Util.drawSquare(g, n, squareWidth, squareHeight);
        }
    }
    
   public void moveSnake(int currentRow, int currentCol){
       
       
   }

}
