
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
        Node head = getNodeHead();
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
        if (!Board.hasEated) {
            listNodes.remove(listNodes.size() - 1);
        }
        Board.hasEated = false;

    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public ArrayList<Node> getListNodes() {
        return listNodes;
    }

    public Node getNodeHead() {
        return listNodes.get(0);
    }

    public boolean hitWall() {
        if (getNodeHead().getCol() == Board.NUM_COLS || getNodeHead().getCol() == -1
                || getNodeHead().getRow() == Board.NUM_ROWS || getNodeHead().getRow() == -1) {
            return true;
        }

        return false;
    }

    public Node walkSnake() {
        for (Node n : listNodes) {
            return n;
        }
        return null;
    }

    public boolean hitItself() {
        for (int i = 1; i < listNodes.size(); i++) {
            if (Node.checkNodesHit(getNodeHead(), listNodes.get(i))) {
                return true;
            }
        }
        return false;

    }

}
