import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessGUI extends JPanel {

    JFrame frame = new JFrame("N-Queens");
    Image img;

    ChessGUI(int n) {
        try {
            img = ImageIO.read(getClass().getResource("resources/queen.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.yellow);
        frame.setLayout(new GridLayout(n, n));
        makeChessBoard(n);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private void makeChessBoard(int n) {
        for (int i = 0;i < n; i++) {
            for (int j = 0;j < n; j++) {
                JButton b = new JButton();
                if (j%2 == 0) {
                    b.setBackground(Color.white);
                } else {
                    b.setBackground(Color.black);
                }
                ImageIcon queen = new ImageIcon(img);
                b.setIcon(queen);
                b.setSize(100, 100);
                this.frame.getContentPane().add(b);
            }
        }
    }

    public static void main(String[] args) {
        ChessGUI chess = new ChessGUI(4);
    }

}