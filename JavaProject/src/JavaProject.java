import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaProject extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int xSpeed = 20;
    private int ySpeed = 10;
    private final int DIAMETER = 100;
    private Timer timer;

    public JavaProject() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x + xSpeed < 0 || x + xSpeed + DIAMETER > getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y + ySpeed < 0 || y + ySpeed + DIAMETER > getHeight()) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new JavaProject());
        frame.setVisible(true);
    }
}
