import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;
import java.time.LocalDate;
class AgeCalc extends JFrame{
	private JTextField yrText;
	private JTextField moText;
	private JTextField dtText;
	private Display display;
	private int yr;
	private int mo;
	private int dt;
	
	AgeCalc(){
		setSize(500,600);
		setTitle("iCET| AGE CALCULATOR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel titlePanel=new JPanel();
		JLabel title=new JLabel("AGE CALCULATOR",JLabel.CENTER);
		title.setFont(new Font("Copperplate Gothic Bold",1,35));
		titlePanel.add(title);
		titlePanel.setBackground(Color.CYAN);
		
		add("North",titlePanel);
		
		JPanel subPanel=new JPanel(new BorderLayout());
		add("Center",subPanel);
		
		JPanel panelForFields=new JPanel(new GridLayout(6,1));
		panelForFields.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 0));
		
		JPanel yrPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel yrLabel=new JLabel("YEAR");
		yrLabel.setFont(new Font("",1,20));
		yrPanel.add(yrLabel);
		
		JPanel moPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel moLabel=new JLabel("MONTH");
		moLabel.setFont(new Font("",1,20));
		moPanel.add(moLabel);
		
		JPanel dtPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel dtLabel=new JLabel("DATE");
		dtLabel.setFont(new Font("",1,20));
		dtPanel.add(dtLabel);
		
		panelForFields.add(yrPanel);
		panelForFields.add(moPanel);
		panelForFields.add(dtPanel);
		
		JPanel panelForText=new JPanel(new GridLayout(6,1));
		panelForText.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 0));
		
		JPanel yrTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		yrText=new JTextField(15);
		yrTPanel.add(yrText);
		
		JPanel moTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		moText=new JTextField(15);
		moTPanel.add(moText);
		
		JPanel dtTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dtText=new JTextField(15);
		dtTPanel.add(dtText);
		
		panelForText.add(yrTPanel);
		panelForText.add(moTPanel);
		panelForText.add(dtTPanel);
		
		subPanel.add("Center",panelForText);
		subPanel.add("West",panelForFields);
		
		JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPanel.setBackground(Color.CYAN);
		JButton calBtn=new JButton("CALCULATE");
		btnPanel.add(calBtn);
		btnPanel.add(new JLabel("      "));
		subPanel.add("South",btnPanel);
		
		calBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				yr=Integer.valueOf(yrText.getText());
				mo=Integer.valueOf(moText.getText());
				dt=Integer.valueOf(dtText.getText());
				boolean isValid=Controller.validBirthday(yr,mo,dt);
				if(!isValid){
					Controller.inform();
				}else{
				if(display==null){
					display=new Display();
				}
					display.setVisible(true);
				}
			}
		});
		}
		class Display extends JFrame{
			
			Display(){
				setSize(500,600);
				setTitle("iCET| AGE DISPLAY WINDOW");
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setLocationRelativeTo(null);
				setResizable(false);
				//setTextEditable(false);
				
				JPanel titlePanel=new JPanel();
				JLabel title=new JLabel("AGE DISPLAY",JLabel.CENTER);
				title.setFont(new Font("Copperplate Gothic Bold",1,35));
				titlePanel.add(title);
				titlePanel.setBackground(Color.CYAN);
				
				add("North",titlePanel);
				
				
				Controller.ageCalculator(yr,mo,dt);
				int yrs=Controller.yrs;
				int months=Controller.mon;
				int days=Controller.dys;
				
				
				JPanel subPanel=new JPanel(new BorderLayout());
				add("Center",subPanel);
		
				JPanel panelForFields=new JPanel(new GridLayout(6,1));
				panelForFields.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 0));
		
				JPanel yrPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel yrLabel=new JLabel("YEARS");
				yrLabel.setFont(new Font("",1,20));
				yrPanel.add(yrLabel);
		
				JPanel moPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel moLabel=new JLabel("MONTHS");
				moLabel.setFont(new Font("",1,20));
				moPanel.add(moLabel);
		
				JPanel dtPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel dtLabel=new JLabel("DAYS");
				dtLabel.setFont(new Font("",1,20));
				dtPanel.add(dtLabel);
		
				panelForFields.add(yrPanel);
				panelForFields.add(moPanel);
				panelForFields.add(dtPanel);
		
				JPanel panelForText=new JPanel(new GridLayout(6,1));
				panelForText.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 0));
		
				JPanel yrTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				yrText=new JTextField(15);
				yrText.setText(String.valueOf(yrs));
				yrTPanel.add(yrText);
		
				JPanel moTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				moText=new JTextField(15);
				moText.setText(String.valueOf(months));
				moTPanel.add(moText);
		
				JPanel dtTPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				dtText=new JTextField(15);
				dtText.setText(String.valueOf(days));
				dtTPanel.add(dtText);
		
				panelForText.add(yrTPanel);
				panelForText.add(moTPanel);
				panelForText.add(dtTPanel);
				
				subPanel.add("Center",panelForText);
				subPanel.add("West",panelForFields);
				
				JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
				btnPanel.setBackground(Color.CYAN);
				JButton cancelBtn=new JButton("CANCEL");
				btnPanel.add(cancelBtn);
				btnPanel.add(new JLabel("      "));
				subPanel.add("South",btnPanel);
				
				cancelBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						dispose();
					}
				});
			}
		}
		
	}

