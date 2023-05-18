import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private final int BROWSE_MODE = 1; // default mode
	private final int ADD_MODE = 2;
	private final int DELETE_MODE = 4;
	private final int EDIT_MODE = 8;
	private final int PRINT_MODE = 16;
	
	private int APP_MODE;
	
	JPanel header_panel, data_panel, nav_panel, crud_panel, printsave_panel, buttons_panel;
	JPanel navsep_panel;
	//controls
	JLabel first_label;
	JTextField first_field;
	
	JLabel middle_label;
	JTextField middle_field;

	JLabel last_label;
	JTextField last_field;
	
	ButtonGroup gender_group;
	JLabel gender_label;
	JRadioButton male_radio, female_radio;
	
	JLabel dob_label;
	JComboBox<String> month_combo;
	JComboBox<Integer> day_combo, year_combo;
	 
	//save/cancel buttons
	JButton save_button, cancel_button;
	
	// navigation controls\
	JButton first_button, next_button;
	JButton prior_button, last_button;
	
	// crud controls
	JButton add_button, edit_button;
	JButton delete_button, print_button;
	
	// ArrayList DATA
	private static PersonList persons;
	private static PersonFile personfile;
	
	private Person current_person;
	private int current_index;
	
	MainFrame() throws IOException{
		super("People Database");
		
		APP_MODE = BROWSE_MODE;
		
		persons = new PersonList();
		personfile = new PersonFile();
		
		loadData();
		
		current_person = new Person();
		current_index = 0;
		
//		BorderLayout layout = new BorderLayout();
//		testGenerator();
		header_panel = new JPanel();
		BorderLayout header_layout = new BorderLayout();
		header_panel.setLayout(header_layout);
		
		JLabel header_label = new JLabel("Personal Information");
		header_label.setPreferredSize(new Dimension(100, 50));
		header_label.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Arial", Font.BOLD+Font.ITALIC, 20);
		header_label.setFont(font);
		
		
		header_panel.add(header_label, BorderLayout.CENTER);
		header_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		
		data_panel = new JPanel();
		crud_panel = new JPanel();
		printsave_panel = new JPanel();
		nav_panel = new JPanel();
		buttons_panel = new JPanel();
		
		Dimension dim = new Dimension();
		
		first_label = new JLabel("First:");
		dim = first_label.getPreferredSize();
		first_label.setPreferredSize(new Dimension(80, dim.height));
		first_field = new JTextField();
		first_field.setPreferredSize(new Dimension(200, 20));
		first_field.setText("Enter first name");
		first_field.selectAll();
		
		middle_label = new JLabel("Middle:");
		middle_label.setPreferredSize(new Dimension(80, dim.height));
		middle_field = new JTextField();
		middle_field.setPreferredSize(new Dimension(200, 20));
		middle_field.setText("Enter middle name");
		middle_field.selectAll();
		
		last_label = new JLabel("Last:");
		last_label.setPreferredSize(new Dimension(80, dim.height));
		last_field = new JTextField();
		last_field.setPreferredSize(new Dimension(200, 20));
		last_field.setText("Enter last name");
		last_field.selectAll();
		
		data_panel.add(first_label, BorderLayout.WEST);
		data_panel.add(first_field, BorderLayout.EAST);
		data_panel.add(middle_label, BorderLayout.WEST);
		data_panel.add(middle_field, BorderLayout.EAST);
		data_panel.add(last_label, BorderLayout.WEST);
		data_panel.add(last_field, BorderLayout.EAST);
		
		gender_group = new ButtonGroup();
		gender_label = new JLabel("Sex:");
		gender_label.setPreferredSize(new Dimension(80, dim.height));
		male_radio = new JRadioButton("Male");
		male_radio.setPreferredSize(new Dimension(100, dim.height));
		female_radio = new JRadioButton("Female");
		female_radio.setPreferredSize(new Dimension(100, dim.height));
		gender_group.add(male_radio);
		gender_group.add(female_radio);
		
		data_panel.add(gender_label);
		data_panel.add(male_radio);
		data_panel.add(female_radio);
		
		dob_label = new JLabel("Birthdate:");
		dob_label.setPreferredSize(new Dimension(80, dim.height));
		
		month_combo = new JComboBox<String>();
		month_combo.addItem("January");
		month_combo.addItem("February");
		month_combo.addItem("March");
		month_combo.addItem("April");
		month_combo.addItem("May");
		month_combo.addItem("June");
		month_combo.addItem("July");
		month_combo.addItem("August");
		month_combo.addItem("September");
		month_combo.addItem("October");
		month_combo.addItem("November");
		month_combo.addItem("December");
		
		day_combo = new JComboBox<Integer>();
		for (int i = 1; i<=31; i++) {
			day_combo.addItem(i);
		}
		
		year_combo = new JComboBox<Integer>();
		for (int i = 1900; i<=3000; i++) {
			year_combo.addItem(i);
			if(i==1980) {
				year_combo.setSelectedItem(i);
			}
		}
		
		data_panel.add(dob_label);
		data_panel.add(month_combo);
		data_panel.add(day_combo);
		data_panel.add(year_combo);
		
		//nav buttons
		first_button = new JButton("<<");
		first_button.setPreferredSize(new Dimension(80,25));
		prior_button = new JButton("<");
		prior_button.setPreferredSize(new Dimension(80,25));
		next_button = new JButton(">");
		next_button.setPreferredSize(new Dimension(80,25));
		last_button = new JButton(">>");
		last_button.setPreferredSize(new Dimension(80,25));
		
		//crud buttons
		add_button = new JButton("New");
		add_button.setPreferredSize(new Dimension(80,25));
		edit_button = new JButton("Edit");
		edit_button.setPreferredSize(new Dimension(80,25));
		delete_button = new JButton("Delete");
		delete_button.setPreferredSize(new Dimension(80,25));
		print_button = new JButton("Print");
		print_button.setPreferredSize(new Dimension(80,25));
		
		//save/cancel button
		save_button = new JButton("Save");
		save_button.setPreferredSize(new Dimension(80,25));
		cancel_button = new JButton("Cancel");
		cancel_button.setPreferredSize(new Dimension(80,25));
		
		crud_panel.add(add_button);
		crud_panel.add(edit_button);
		crud_panel.add(delete_button);
		
		printsave_panel.add(print_button);
		printsave_panel.add(save_button);
		printsave_panel.add(cancel_button);
		
		navsep_panel = new JPanel();
		
		nav_panel.add(first_button);
		nav_panel.add(prior_button);
		nav_panel.add(next_button);
		nav_panel.add(last_button);
		
	
		BorderLayout navsep_layout = new BorderLayout();
		navsep_panel.setLayout(navsep_layout);
		
		navsep_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		navsep_panel.add(nav_panel, navsep_layout.SOUTH);
		
		BorderLayout buttons_layout = new BorderLayout();
		
		buttons_panel.setLayout(buttons_layout);
		buttons_panel.add(crud_panel, buttons_layout.NORTH);
		buttons_panel.add(printsave_panel, buttons_layout.CENTER);
		buttons_panel.add(navsep_panel, buttons_layout.SOUTH);
		
		add(header_panel, BorderLayout.NORTH);
		add(data_panel, BorderLayout.CENTER);
		add(buttons_panel, BorderLayout.SOUTH);
		
		setSize(380, 380);
		setMinimumSize(new Dimension(380, 380));
		setPreferredSize(new Dimension(380, 380));
		setVisible(true);
		setResizable(!false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0,0);
		
		addActionListeners();
		enableButtons();
		enableControls();	
	}
	
	public void addActionListeners() {
		
		first_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				current_index = 0;
				go(current_index);
			}
		});
		
		last_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				current_index = persons.count()-1;
				go(current_index);
			}
		});
		
		prior_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(current_index>0) {
					current_index--;
					go(current_index);
				}
			}
		});
		
		next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(current_index<persons.count()-1) {
					current_index++;
					go(current_index);
				}
			}
		});
		
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setAddMode();
				enableButtons();
				enableControls();
				
				first_field.setText("Enter first name");
				first_field.selectAll();
				middle_field.setText("Enter middle name");
				middle_field.selectAll();
				last_field.setText("Enter last name");
				last_field.selectAll();
				
				male_radio.setSelected(false);
				female_radio.setSelected(false);
				
				month_combo.setSelectedIndex(0);
				day_combo.setSelectedIndex(0);
				year_combo.setSelectedItem(1980);
				
			}
		});
		

		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isAddMode()) {
					Person person = new Person();
					person.setFirst(first_field.getText());
					person.setMiddle(middle_field.getText());
					person.setLast(last_field.getText());
					
					int year = year_combo.getItemAt(year_combo.getSelectedIndex());
					int month = month_combo.getSelectedIndex()+1;
					int day = day_combo.getSelectedIndex()+1;
					
					person.setDob(LocalDate.of(year, month, month));
					person.setSex(male_radio.isSelected() ? Sex.MALE : Sex.FEMALE);
					
					// add to list
					persons.add(person);
				} else if (isEditMode()){
					current_person = persons.get(current_index);
					
					current_person.setFirst(first_field.getText());
					current_person.setMiddle(middle_field.getText());
					current_person.setLast(last_field.getText());
					
					Sex sex = female_radio.isSelected()? Sex.MALE : Sex.FEMALE;
					current_person.setSex(sex);
					
					int year = (int) year_combo.getSelectedItem()+1;
					int month = month_combo.getSelectedIndex()+1;
					int day = day_combo.getSelectedIndex()+1;
					
					current_person.setDob(LocalDate.of(year, month, day));
					
				}
				
				setBrowseMode();
				enableButtons();
				enableControls();
			}
		});
		
		cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBrowseMode();
				enableButtons();
				enableControls();
			}
		});
		

		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				boolean delete = JOptionPane.showOptionDialog(delete_button.getParent(), "Are you sure?", "Confirm Delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null)==JOptionPane.OK_OPTION;
					if(delete) {
						persons.delete(current_index);
						if(current_index==0) {
							first_button.doClick();
						} else if(current_index>=persons.count()) {
							current_index = persons.count()-1;
							last_button.doClick();
						} else {
							prior_button.doClick();
							next_button.doClick();
						}
					}
						
			}
		});
		
		edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditMode();
				
				enableButtons();
				enableControls();
			}
		});
		
		print_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPrintMode();
				print();
			}
		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				MainFrame.this.setTitle("Saving Records. Please wait...");
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				MainFrame.saveData();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void print() {
		JDialog print_dialog = new JDialog();
		print_dialog.setTitle("Print Records");
		print_dialog.setResizable(false);
		print_dialog.setModal(true);
		
		JPanel print_panel = new JPanel();
		JButton print_record = new JButton("Proceed with Printing");
		JTextArea print_canvas = new JTextArea(8, 55);
		
		JScrollPane print_scroll = new JScrollPane(print_canvas,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		print_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					print_canvas.print();
					print_dialog.setVisible(false);
				} catch(PrinterException e) {
					JOptionPane.showMessageDialog(print_canvas, e);
				}
			}
		});
		Font font = new Font("Roboto Mono", Font.BOLD, 12);
		print_canvas.setFont(font);
		
		int count = 0;
		for(Person person:persons.getPersons()) {
			print_canvas.append(StringUtils.repC((char) 0x2015, 30) + "\n");
			print_canvas.append("Personal Information" + String.format(" #%04d", count+1)+"\n");
			print_canvas.append(StringUtils.repC((char) 0x2015, 30)+"\n");
			print_canvas.append(" Name: " +
								person.getFirst()+" "+
								person.getMiddle().charAt(0)+". "+
								person.getLast()+"\n"
			);
			print_canvas.append(" Birth: " + person.getDob()+"\n");
			print_canvas.append(" Sex: " + person.getSex()+"\n");
			print_canvas.append("\n");
			count++;
		}
		print_canvas.append(StringUtils.repC((char) 0x2015, 80) + "\n");
		print_canvas.append("People Database version 1.0.0\n");
		print_canvas.append("Rundate: " + LocalDate.now()+"\n");
		
		print_canvas.setEditable(false);
		
		print_panel.add(print_scroll);
		print_panel.add(print_record);
		
		print_dialog.add(print_panel);
		print_dialog.setSize(648, 230);
		print_dialog.setVisible(true);
	}
	
	public void setBrowseMode() {
		APP_MODE = BROWSE_MODE;
	}
	
	public void setAddMode() {
		APP_MODE = ADD_MODE;
	}
	
	public void setDeleteMode() {
		APP_MODE = DELETE_MODE;
	}
	
	public void setEditMode() {
		APP_MODE = EDIT_MODE;
	}
	
	public void setPrintMode() {
		APP_MODE = PRINT_MODE;
	}
	
	public boolean isBrowseMode() {
		return((APP_MODE & BROWSE_MODE) > 0);
	}
	
	public boolean isAddMode() {
		return((APP_MODE & ADD_MODE) > 0);
	}
	
	public boolean isEditMode() {
		return((APP_MODE & EDIT_MODE) > 0);
	}
	
	public boolean isDeleteMode() {
		return((APP_MODE & DELETE_MODE) > 0);
	}
	
	public boolean isPrintMode() {
		return((APP_MODE & PRINT_MODE) > 0);
	}
	
	public boolean isListEmpty() {
		return persons.count()==0;
	}
	
	public void enableButtons() {
		first_button.setEnabled((!isListEmpty()) && isBrowseMode());
		prior_button.setEnabled((!isListEmpty()) && isBrowseMode());
		next_button.setEnabled((!isListEmpty()) && isBrowseMode());
		last_button.setEnabled((!isListEmpty()) && isBrowseMode());
		
		add_button.setEnabled(isBrowseMode());
		edit_button.setEnabled((!isListEmpty()) && isBrowseMode());
		delete_button.setEnabled((!isListEmpty()) && isBrowseMode());
		print_button.setEnabled((!isListEmpty()) && isBrowseMode());
		
		save_button.setEnabled(isEditMode() || isAddMode());
		cancel_button.setEnabled(isEditMode() || isAddMode());
	}
	
	public void enableControls() {
		first_field.setEditable(isAddMode() || isEditMode());
		middle_field.setEditable(isAddMode() || isEditMode());
		last_field.setEditable(isAddMode() || isEditMode());
		male_radio.setEnabled(isAddMode() || isEditMode());
		female_radio.setEnabled(isAddMode() || isEditMode());
		month_combo.setEnabled(isAddMode() || isEditMode());
		day_combo.setEnabled(isAddMode() || isEditMode());
		year_combo.setEnabled(isAddMode() || isEditMode());
	}
	
	public void go(int index) {
		current_person = persons.get(index);
		
		first_field.setText(current_person.getFirst());
		middle_field.setText(current_person.getMiddle());
		last_field.setText(current_person.getLast());
		if(current_person.getSex()==Sex.MALE) {
			male_radio.setSelected(true);
			male_radio.doClick();
		} else {
			female_radio.setSelected(true);
			female_radio.doClick();
		}
		month_combo.setSelectedIndex(current_person.getDob().getMonthValue()-1);
		day_combo.setSelectedIndex(current_person.getDob().getDayOfMonth()-1);
		year_combo.setSelectedItem(current_person.getDob().getYear());
		
	}
	
	public static void testGenerator() {
		PersonList personList = new PersonList();
		PersonGenerator p = new PersonGenerator();
		
		loadData();
		personList = persons;
		
		for(int i = 1; i<=10; i++) {
			personList.add(p.next());
		}
		
		int count = 0;
		for(Person person: personList.getPersons()) {
			System.out.println(String.format("%08d", (count + 1))+ " " + person);
			count++;
		}
		
		persons = personList;
		saveData();
	}
	
	public static void loadData() {
		personfile.load(persons);
	}
	
	public static void saveData() {
		personfile.save(persons);
	}
}

