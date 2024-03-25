package qh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Gamebai {

    public static class CardGame extends JFrame {
        private JLabel label;
        private JTextField[] betFields;
        private JButton betButton;
        private final String[] cards = { "9", "10", "J", "Q", "K", "A"};

        public CardGame() {
            initializeUI();
        }
        private void initializeUI() {
            setTitle("Roll Dice Game");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLayout(new GridLayout(7, 2));

            label = new JLabel("Mời bạn đặt cược");
            add(label);
            betFields = new JTextField[6];
            for (int i = 0; i < 6; i++) {
                add(new JLabel(cards[i]));
                betFields[i] = new JTextField();
                add(betFields[i]);
            }
            betButton = new JButton("Cược");
            betButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rollDice();
                }
            });
            add(betButton);

            setVisible(true);
        }

        private void rollDice() {
            Map<String, Integer> results = new HashMap<>();
            for (String card : cards) {
                results.put(card, 0);
            }
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                String result = cards[random.nextInt(cards.length)];
                results.put(result, results.get(result) + 1);
            }
            StringBuilder resultStr = new StringBuilder();
            for (String card : cards) {
                resultStr.append(card).append(": ").append(results.get(card)).append("\n");
            }
            JOptionPane.showMessageDialog(this, resultStr.toString(), "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CardGame();
                }
            });
        }
    }
}