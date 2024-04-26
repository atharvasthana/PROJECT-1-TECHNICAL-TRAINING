import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorMatchingGame extends JFrame {

    private JPanel panel;
    private JButton[] buttons;
    private Color[] colors;
    private int currentColorIndex;

    public ColorMatchingGame() {
        super("Color Matching Game");

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        colors = new Color[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if (button.getBackground() == colors[currentColorIndex]) {
                        button.setBackground(Color.GREEN);
                        currentColorIndex++;
                        if (currentColorIndex == colors.length) {
                            JOptionPane.showMessageDialog(null, "You win!");
                            System.exit(0);
                        }
                    } else {
                        button.setBackground(Color.RED);
                    }
                }
            });
            panel.add(buttons[i]);
        }

        resetGame();

        add(panel);
        setSize(300, 300);
        setVisible(true);
    }

    private void resetGame() {
        currentColorIndex = 0;

        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            buttons[i].setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        new ColorMatchingGame();
    }
}