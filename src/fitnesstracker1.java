import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fitnesstracker1 extends JFrame {
    private JTextField stepsField;
    private JTextField distanceField;
    private JButton trackButton;
    private JLabel resultLabel;
    private JPanel backgroundPanel;

    public fitnesstracker1() {
        setTitle("Health and Fitness Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window

        // Create a background panel with an image
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("E:\\fitness  tracker/bgimg.jpg");
               // ImageIcon backgroundImage = new ImageIcon("E:\\fitness  tracker/OIP.jpeg");
// Add path to your background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning

        // Font styles
        Font labelFont = new Font("Arial", Font.BOLD, 30);
        Font inputFont = new Font("Arial", Font.PLAIN, 40); // Increase font size for text fields
        Font resultFont = new Font("Arial", Font.BOLD, 30);

        // Input fields with increased size and font
        stepsField = new JTextField(10);
        stepsField.setFont(inputFont); // Set larger font for stepsField
        stepsField.setPreferredSize(new Dimension(300, 50)); // Increase the size of the text field

        distanceField = new JTextField(10);
        distanceField.setFont(inputFont); // Set larger font for distanceField
        distanceField.setPreferredSize(new Dimension(300, 50)); // Increase the size of the text field

        // Track button
        trackButton = new JButton("Track Activity");
        trackButton.setFont(labelFont);
        trackButton.setBackground(Color.GREEN);
        trackButton.setForeground(Color.WHITE);
        trackButton.setPreferredSize(new Dimension(300, 50)); // Set size to match input fields

        // Result label
        resultLabel = new JLabel();
        resultLabel.setFont(resultFont);
        resultLabel.setForeground(Color.white);

        // Create GridBagConstraints for flexible layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to background panel
        // Steps label and field
        JLabel stepsLabel = new JLabel("Steps Taken:");
        stepsLabel.setFont(labelFont);
        stepsLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(stepsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        backgroundPanel.add(stepsField, gbc);

        // Distance label and field
        JLabel distanceLabel = new JLabel("Distance (km):");
        distanceLabel.setFont(labelFont);
        distanceLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(distanceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        backgroundPanel.add(distanceField, gbc);

        // Add button
        gbc.gridx = 1;
        gbc.gridy = 2;
        backgroundPanel.add(trackButton, gbc);

        // Add result label
        gbc.gridx = 1;
        gbc.gridy = 3;
        backgroundPanel.add(resultLabel, gbc);

        add(backgroundPanel);

        // Action listener for the Track Activity button
        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int steps = Integer.parseInt(stepsField.getText());
                    double distance = Double.parseDouble(distanceField.getText());

                    // Perform calculations to estimate calories burned
                    double caloriesBurned = calculateCaloriesBurned(steps, distance);

                    // Display the results to the user
                    resultLabel.setText("Calories Burned: " + String.format("%.2f", caloriesBurned));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }
        });
    }

    // Method to calculate estimated calories burned
    private double calculateCaloriesBurned(int steps, double distance) {
        // Simplified calculation; you can implement a more accurate formula
        double caloriesPerStep = 0.04; // Sample value, modify accordingly
        double caloriesPerDistance = 0.1; // Sample value, modify accordingly

        return (steps * caloriesPerStep) + (distance * caloriesPerDistance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new fitnesstracker1().setVisible(true);
            }
        });
    }
}



