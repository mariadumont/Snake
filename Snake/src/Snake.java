
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

    private int countGrowSnake;

    Snake() {
        listNodes = new ArrayList<Node>(3);

        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2, Color.green.darker()));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1, Color.green));
        listNodes.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2, Color.green));
        direction = DirectionType.RIGHT;

        countGrowSnake = 0;

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
                if (Game.noWalls && head.getCol() == Board.NUM_COLS) {
                    firstNode = new Node(head.row, head.getFirstCol(), head.color);

                } else {
                    firstNode = new Node(head.row, head.col + 1, head.color);
                }
                break;

            case LEFT:
                if (Game.noWalls && head.getCol() == 0) {
                    firstNode = new Node(head.row, head.getLastCol(), head.color);
                } else {
                    firstNode = new Node(head.row, head.col - 1, head.color);
                }
                break;

            case UP:
                if (Game.noWalls && head.getRow() == 0) {
                    firstNode = new Node(head.getLastRow(), head.col, head.color);
                } else {
                    firstNode = new Node(head.row - 1, head.col, head.color);
                }
                break;

            case DOWN:
                if (Game.noWalls && head.getRow() == Board.NUM_ROWS) {
                    firstNode = new Node(head.getFirstRow(), head.col, head.color);
                } else {
                    firstNode = new Node(head.row + 1, head.col, head.color);
                }
                break;
        }
        head.color = Color.green;
        listNodes.add(0, firstNode);

        if (countGrowSnake == 0) {
            listNodes.remove(listNodes.size() - 1);
        } else {
            countGrowSnake--;
        }

    }

    // move classic
    /*public void move() {
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

        if (countGrowSnake == 0) {
            listNodes.remove(listNodes.size() - 1);
        } else {
            countGrowSnake--;
        }

    }*/
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
        if (getNextNode().getCol() == Board.NUM_COLS || getNextNode().getCol() == -1
                || getNextNode().getRow() == Board.NUM_ROWS || getNextNode().getRow() == -1) {
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
            if (Node.checkNodesHit(getNextNode(), listNodes.get(i))) {
                return true;
            }
        }
        return false;

    }

    public Node getNextNode() {
        Node head = getNodeHead();
        Node nextNode = null;

        switch (direction) {
            case RIGHT:
                if (Game.noWalls && head.getCol() == Board.NUM_COLS) {
                    nextNode = new Node(head.row, head.getFirstCol(), Color.red);
                } else {
                    nextNode = new Node(head.row, head.col + 1, Color.red);
                }
                break;

            case LEFT:
                if (Game.noWalls && head.getCol() == 0) {
                    nextNode = new Node(head.row, head.getLastCol(), Color.red);
                } else {
                    nextNode = new Node(head.row, head.col - 1, Color.red);
                }
                break;

            case UP:
                if (Game.noWalls && head.getRow() == 0) {
                    nextNode = new Node(head.getLastRow(), head.col, Color.red);
                } else {
                    nextNode = new Node(head.row - 1, head.col, Color.red);
                }
                break;

            case DOWN:
                if (Game.noWalls && head.getRow() == Board.NUM_ROWS) {
                    nextNode = new Node(head.getFirstRow(), head.col, Color.red);
                } else {
                    nextNode = new Node(head.row + 1, head.col, Color.red);
                }
                break;
        }
        return nextNode;
    }

    // getNextNode classic
    /*public Node getNextNode() {
        Node head = getNodeHead();
        Node nextNode = null;

        switch (direction) {
            case RIGHT:
                nextNode = new Node(head.row, head.col + 1, Color.red);
                break;

            case LEFT:
                nextNode = new Node(head.row, head.col - 1, Color.red);
                break;

            case UP:
                nextNode = new Node(head.row - 1, head.col, Color.red);
                break;

            case DOWN:
                nextNode = new Node(head.row + 1, head.col, Color.red);
                break;
        }
        return nextNode;
    }
     */
    public void setCountGrowSnake(int countGrowSnake) {
        this.countGrowSnake = countGrowSnake;
    }

}
