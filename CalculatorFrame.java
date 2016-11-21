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
		setSize(500, 300);   //  setting width = 500 and height = 300
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //  The window will exit when the close button will be clicked on
		design();    
	}
	
	public void design(){
		
		/*
		 * 
		 * First, create the component objects
		 * Add each object in the panel. Set the position of the components in panel using GridBagConstrains
		 * Add ActionListener in buttons
		 * Finally, add the panel in frame
		 * 
		 */
		
		panel = new JPanel(new GridBagLayout());    //   panel will contain all components 
		panel.setBackground(Color.PINK);
		GridBagConstraints c = new GridBagConstraints();    // this object will be used to set the position of each component
		
		firstLabel = new JLabel("First number: ");
		firstTextField = new JTextField(10);        //  this text field can contain 10 characters/columns (if we don't pass argument 10, a little text field will be created
		
		secondLabel = new JLabel("Second number: ");
		secondTextField = new JTextField(10);
		
		resultLabel = new JLabel("Result: ");
		resultTextField = new JTextField(10);
		resultTextField.setEditable(false);     //  because the result text field should not be edited by the user
		
		c.insets = new Insets(10,10,10,10);    //  each component will be surrounded by 10 pixel space (top, left, bottom, right)
		
		c.anchor = GridBagConstraints.WEST;    //  Left-alignment. If you want center-alignment, just comment it out
		
		c.gridx= 0;
		c.gridy = 0;
		panel.add(firstLabel, c);   //  adding firstLabel at 0,0 position of panel
		
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
		addButton.addActionListener(this);   //  passing the current button to the method
		
		c.anchor = GridBagConstraints.CENTER;    //  Aligning the buttons at center (optional)
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(addButton, c);
		
		subtractButton = new JButton("SUBTRACT");
		subtractButton.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(subtractButton, c);
		
		add(panel);    // IMPORTANT!! If you miss this line, the panel will not be visible inside frame
	
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		int a = Integer.parseInt(firstTextField.getText());   // The input of text field is String, so conversion is mandatory
		int b = Integer.parseInt(secondTextField.getText());
		int result;
		
		if(event.getSource()==addButton){   // Button-click is an event and here we're checking which button has been clicked on
			result = a+b;
		}
		else{
			result = a-b;
		}
		
		
		resultTextField.setText(Integer.toString(result));   // The output of text field must be String
	
		/*
		 * Alternative:
		 * 
		 * resultTextField.setText(result+"");
		 */
		
	}

}
