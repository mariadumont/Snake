
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

    private ArrayList<Node> listNodes;

   

    private DirectionType direction;

    Snake() {
        listNodes = new ArrayList<Node>(3);

        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2, Color.green.darker()));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1, Color.green));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2, Color.green));
        direction = DirectionType.RIGHT;

    }

    public void drawSnake(Graphics g, int squareWidth, int squareHeight) {

        for (Node n : listNodes) {
            Util.drawSquare(g, n, squareWidth, squareHeight);
        }
    }

    public void move() {
        Node head = listNodes.get(0);
        Node firstNode = null;

        switch (direction) {
            case RIGHT:
                firstNode = new Node(head.row, head.col + 1, head.color);
                break;

            case LEFT:
                firstNode = new Node(head.row, head.col - 1, head.color);
                break;

            case UP:
                firstNode = new Node(head.row - 1, head.col, head.color);
                break;

            case DOWN:
                firstNode = new Node(head.row + 1, head.col, head.color);
                break;
        }
        head.color = Color.green;
        listNodes.add(0, firstNode);
        listNodes.remove(listNodes.size() - 1);
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }
    
     public ArrayList<Node> getListNodes() {
        return listNodes;
    }
     
     

}