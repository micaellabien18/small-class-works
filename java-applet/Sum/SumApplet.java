import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumApplet extends Applet implements ActionListener {
    TextField num1Field, num2Field;
    Label resultLabel;
    Button sumButton;

    public void init() {
        // Create text fields for input
        num1Field = new TextField(5);
        num2Field = new TextField(5);

        // Label for displaying result
        resultLabel = new Label("Result: ");

        // Button to perform sum
        sumButton = new Button("Add");
        sumButton.addActionListener(this);

        // Add components to applet
        add(new Label("Number 1:"));
        add(num1Field);
        add(new Label("Number 2:"));
        add(num2Field);
        add(sumButton);
        add(resultLabel);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double sum = num1 + num2;
            resultLabel.setText("Result: " + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }

    // Paint method
    public void paint(Graphics g) {
        g.drawString("Sum of two numbers", 20, 80);
    }
}
