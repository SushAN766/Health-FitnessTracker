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
        setLocationRelativeTo(null); 

        
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("E:\\fitness  tracker/bgimg.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); 

        
        Font labelFont = new Font("Arial", Font.BOLD, 30);
        Font inputFont = new Font("Arial", Font.PLAIN, 40); 
        Font resultFont = new Font("Arial", Font.BOLD, 30);

        
        stepsField = new JTextField(10);
        stepsField.setFont(inputFont); 
        stepsField.setPreferredSize(new Dimension(300, 50)); 

        distanceField = new JTextField(10);
        distanceField.setFont(inputFont); 
        distanceField.setPreferredSize(new Dimension(300, 50)); 

        
        trackButton = new JButton("Track Activity");
        trackButton.setFont(labelFont);
        trackButton.setBackground(Color.GREEN);
        trackButton.setForeground(Color.WHITE);
        trackButton.setPreferredSize(new Dimension(300, 50)); 

        
        resultLabel = new JLabel();
        resultLabel.setFont(resultFont);
        resultLabel.setForeground(Color.white);

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        
        JLabel stepsLabel = new JLabel("Steps Taken:");
        stepsLabel.setFont(labelFont);
        stepsLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(stepsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        backgroundPanel.add(stepsField, gbc);

        
        JLabel distanceLabel = new JLabel("Distance (km):");
        distanceLabel.setFont(labelFont);
        distanceLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(distanceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        backgroundPanel.add(distanceField, gbc);

        
        gbc.gridx = 1;
        gbc.gridy = 2;
        backgroundPanel.add(trackButton, gbc);

        
        gbc.gridx = 1;
        gbc.gridy = 3;
        backgroundPanel.add(resultLabel, gbc);

        add(backgroundPanel);

        
        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int steps = Integer.parseInt(stepsField.getText());
                    double distance = Double.parseDouble(distanceField.getText());

                    
                    double caloriesBurned = calculateCaloriesBurned(steps, distance);

                    
                    resultLabel.setText("Calories Burned: " + String.format("%.2f", caloriesBurned));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }
        });
    }

   
    private double calculateCaloriesBurned(int steps, double distance) {
        
        double caloriesPerStep = 0.04; 
        double caloriesPerDistance = 0.1; 

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



