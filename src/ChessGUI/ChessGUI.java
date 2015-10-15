package ChessGUI;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import Board.Board;

public class ChessGUI extends JPanel {

    JFrame frame = new JFrame("N-Queens");
    Image img;

    public ChessGUI(Board board) {
        try {
            img = ImageIO.read(getClass().getResource("/resources/queen.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.yellow);
        frame.setLayout(new GridLayout(board.length(), board.length()));
        makeChessBoard(board);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private void makeChessBoard(Board n) {
        for (int i = 0;i < n.length(); i++) {
            for (int j = 0;j < n.length(); j++) {
                JButton b = new JButton();
                if (i%2 == 0) {
                    if (j%2 == 0) {
                        b.setBackground(Color.white);
                    } else {
                        b.setBackground(Color.black);
                    }
                } else {
                    if (j%2 == 0) {
                        b.setBackground(Color.black);
                    } else {
                        b.setBackground(Color.white);
                    }
                }
                if(n.locHasQueen(i, j)) {
                    ImageIcon queen = new ImageIcon(img);
                    b.setIcon(queen);
                }
                b.setSize(100, 100);
                this.frame.getContentPane().add(b);
            }
        }
    }
}