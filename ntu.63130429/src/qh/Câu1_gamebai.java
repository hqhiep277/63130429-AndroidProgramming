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