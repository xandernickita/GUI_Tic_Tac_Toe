import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TicTacToe implements ActionListener {

    Random randomizer = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1turn;
    boolean gameOver;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25, 25, 25));
        text_field.setForeground(new Color(25, 255, 0));
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic Tac Toe!");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.ITALIC, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (!gameOver) {
                    if (player1turn) {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1turn = false;
                            text_field.setText("It is O's turn");
                            check();
                        }
                    } else {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1turn = true;
                            text_field.setText("It is X's turn");
                            check();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {
        // Add a delay (3 seconds) between title display and who plays first
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (randomizer.nextInt(2) == 0) {
            player1turn = true;
            text_field.setText("X plays");
        } else {
            player1turn = false;
            text_field.setText("O plays");
        }
    }

    public void check() {
        // Check if X wins
        if ((Objects.equals(buttons[0].getText(), "X")) &&
                Objects.equals(buttons[1].getText(), "X") &&
                Objects.equals(buttons[2].getText(), "X")) {
            xWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "X")) &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[5].getText(), "X")) {
            xWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "X")) &&
                Objects.equals(buttons[7].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")) {
            xWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) &&
                Objects.equals(buttons[3].getText(), "X") &&
                Objects.equals(buttons[6].getText(), "X")) {
            xWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "X")) &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[7].getText(), "X")) {
            xWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) &&
                Objects.equals(buttons[5].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")) {
            xWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")) {
            xWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[6].getText(), "X")) {
            xWins(2, 4, 6);
        }

        // Check if O wins
        if ((Objects.equals(buttons[0].getText(), "O")) &&
                Objects.equals(buttons[1].getText(), "O") &&
                Objects.equals(buttons[2].getText(), "O")) {
            oWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "O")) &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[5].getText(), "O")) {
            oWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "O")) &&
                Objects.equals(buttons[7].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")) {
            oWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) &&
                Objects.equals(buttons[3].getText(), "O") &&
                Objects.equals(buttons[6].getText(), "O")) {
            oWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "O")) &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[7].getText(), "O")) {
            oWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) &&
                Objects.equals(buttons[5].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")) {
            oWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")) {
            oWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[6].getText(), "O")) {
            oWins(2, 4, 6);
        }

        // Check for a tie
        if (!gameOver) {
            boolean tie = true;
            for (int i = 0; i < 9; i++) {
                if (Objects.equals(buttons[i].getText(), "")) {
                    tie = false;
                    break;
                }
            }
            if (tie) {
                gameOver = true;
                text_field.setText("It's a tie!");
                restartOrQuit();
            }
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        gameOver = true;
        text_field.setText("X wins!");
        restartOrQuit();
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        gameOver = true;
        text_field.setText("O wins!");
        restartOrQuit();
    }

    public void restartOrQuit() {
        // Add a delay (2 seconds) before showing the restart/quit options
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create a custom dialog box with the restart and quit options
        String[] options = { "Restart Game", "Quit" };
        int choice = JOptionPane.showOptionDialog(frame, "Game Over!\n", "Game Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            frame.dispose();
            new TicTacToe();
        } else if (choice == 1) {
            System.exit(0);
        }
    }
}
