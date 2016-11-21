import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CalculatorFrame extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel firstLabel, secondLabel, resultLabel;
	JTextField firstTextField, secondTextField, resultTextField;
	JButton addButton, subtractButton;
	
	public CalculatorFrame(String title){
		super(title);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		design();
	}
	
	public void design(){
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.PINK);
		GridBagConstraints c = new GridBagConstraints();
		
		firstLabel = new JLabel("First number: ");
		firstTextField = new JTextField(10);
		
		secondLabel = new JLabel("Second number: ");
		secondTextField = new JTextField(10);
		
		resultLabel = new JLabel("Result: ");
		resultTextField = new JTextField(10);
		resultTextField.setEditable(false);
		
		c.insets = new Insets(10,10,10,10);
		
		c.anchor = GridBagConstraints.WEST;
		
		c.gridx= 0;
		c.gridy = 0;
		panel.add(firstLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(firstTextField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(secondLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(secondTextField, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(resultLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(resultTextField, c);

		
		addButton = new JButton("ADD");
		addButton.addActionListener(this);
		
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(addButton, c);
		
		subtractButton = new JButton("SUBTRACT");
		subtractButton.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(subtractButton, c);
		
		add(panel);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		int a = Integer.parseInt(firstTextField.getText());
		int b = Integer.parseInt(secondTextField.getText());
		int result;
		
		if(event.getSource()==addButton){
			result = a+b;
		}
		else{
			result = a-b;
		}
		
		
		resultTextField.setText(Integer.toString(result));
	
		/*
		 * Alternative:
		 * 
		 * resultTextField.setText(result+"");
		 */
		
	}

}
