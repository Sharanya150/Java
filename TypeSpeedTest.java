import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class TypeSpeedTest extends JFrame implements ActionListener {
    private JTextArea inputArea;
    private JLabel promptLabel, timerLabel, wpmLabel, accuracyLabel;
    private JButton startButton, finishButton;
    private String promptText = "The quick brown fox jumps over the lazy dog.";
    private long startTime;
    private Timer timer;

    public TypeSpeedTest() {
        setTitle("Typing Speed Test");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        promptLabel = new JLabel("Text to type: " + promptText);
        add(promptLabel, BorderLayout.NORTH);

        inputArea = new JTextArea();
        inputArea.setEnabled(false);
        add(new JScrollPane(inputArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 1));

        timerLabel = new JLabel("Timer: 0 seconds");
        bottomPanel.add(timerLabel);

        wpmLabel = new JLabel("Words Per Minute: ");
        bottomPanel.add(wpmLabel);

        accuracyLabel = new JLabel("Accuracy: ");
        bottomPanel.add(accuracyLabel);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        finishButton = new JButton("Finish");
        finishButton.setEnabled(false);

        startButton.addActionListener(this);
        finishButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(finishButton);
        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startTest();
        } else if (e.getSource() == finishButton) {
            finishTest();
        }
    }

    private void startTest() {
        inputArea.setText("");
        inputArea.setEnabled(true);
        inputArea.requestFocus();
        startButton.setEnabled(false);
        finishButton.setEnabled(true);

        startTime = System.nanoTime();
        timer = new Timer(1000, e -> updateTimer());
        timer.start();
    }

    private void finishTest() {
        timer.stop();
        inputArea.setEnabled(false);
        finishButton.setEnabled(false);
        startButton.setEnabled(true);

        String typedText = inputArea.getText().trim();
        long timeTaken = System.nanoTime() - startTime;
        long timeInSeconds = TimeUnit.NANOSECONDS.toSeconds(timeTaken);

        int wordCount = typedText.split("\\s+").length;
        double wordsPerMinute = (wordCount / (double) timeInSeconds) * 60;
        wpmLabel.setText("Words Per Minute: " + String.format("%.2f", wordsPerMinute));

        int correctChars = 0;
        for (int i = 0; i < Math.min(promptText.length(), typedText.length()); i++) {
            if (promptText.charAt(i) == typedText.charAt(i)) {
                correctChars++;
            }
        }
        double accuracy = (correctChars / (double) promptText.length()) * 100;
        accuracyLabel.setText("Accuracy: " + String.format("%.2f", accuracy) + "%");
    }

    private void updateTimer() {
        long elapsedTime = System.nanoTime() - startTime;
        long elapsedSeconds = TimeUnit.NANOSECONDS.toSeconds(elapsedTime);
        timerLabel.setText("Timer: " + elapsedSeconds + " seconds");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TypeSpeedTest::new);
    }
}
