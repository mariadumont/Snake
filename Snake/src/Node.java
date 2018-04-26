
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Node {

    public int row;
    public int col;
    public Color color;

    public Node(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public static boolean checkNodesHit(Node a, Node b) {
        
        if (a.col == b.col && a.row == b.row) {
            return true;
        }
        return false;
    }

}
