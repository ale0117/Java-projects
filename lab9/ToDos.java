package labs.lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ToDos extends JFrame{
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 400;
	private static final int ITEM_FIELD_WIDTH = 22;
	private static final int PRIORITY_FIELD_WIDTH = 12;
	private static final int NOTES_WIDTH = 22;
	private static final int NOTES_HEIGHT = 3;
	private static final int MONTH_WIDTH = 10;
	private static final int MONTH_HEIGHT = 1;
	private static final int DAY_WIDTH = 3;
	private static final int DAY_HEIGHT = 1;
	private static final int YEAR_WIDTH = 5;
	private static final int YEAR_HEIGHT = 1;
	
	private JMenuItem exitItem;
	private JList<String> taskList;
	private JButton doneButton;
	private JButton deleteButton;
	private JTextField itemField;
	private JTextField priorityField;
	private JCheckBox deadlineCheckBox;
	private JComboBox<String> monthBox;
	private JComboBox<Integer> dayBox;
	private JComboBox<Integer> yearBox;
	private JTextArea notesArea;
	private JButton saveButton;
	private JButton newButton;
	private HashMap<String, Task> tasks;
	
	private class Task implements Comparable{
		private String name;
		private int priority;
		private int weighted_priority;
		private String month;
		private int day;
		private int year;
		private String notes;
		private boolean completed;
		public Task(String name, int priority, String month, int day, int year, String notes) {
			this.name = name;
			this.priority = priority;
			this.month = month;
			this.day = day;
			this.year = year;
			this.notes = notes;
			this.completed = false;
		}
		public String getName() {
			return name;
		}
		public int getPriority() {
			return priority;
		}
		public String getMonth() {
			return month;
		}
		public int getDay() {
			return day;
		}
		public int getYear() {
			return year;
		}
		public String getNotes() {
			return notes;
		}
		public boolean isCompleted() {
			return completed;
		}
		public void setCompletion(boolean b) {
			completed = b;
		}
		public int compareTo(Object otherObj) {
			Task other = (Task) otherObj;
			if (completed && !other.completed) {
				return 1;
			}
			if (!completed && other.completed) {
				return -1;
			}
			int temp =  priority - other.priority;
			if (temp == 0) {
				return name.compareTo(other.name);
			}
			else {
				return temp;
			}
		}
	}
	
	public ToDos() {
		// This constructs menu
		tasks = new HashMap<String, Task>();		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		// This constructs UI panel
		createUIPanel();

		ListSelectionListener taskListener = new TaskListener();
		taskList.addListSelectionListener(taskListener);
		
		ActionListener doneListener = new DoneListener();
		doneButton.addActionListener(doneListener);
		
		ActionListener deleteListener = new DeleteListener();
		deleteButton.addActionListener(deleteListener);
		
		ActionListener exitListener = new ExitItemListener();
		exitItem.addActionListener(exitListener);
		
		ActionListener deadlineListener = new DeadlineListener();
		deadlineCheckBox.addActionListener(deadlineListener);
		
		ActionListener dateListener = new DateListener();
		monthBox.addActionListener(dateListener);
		yearBox.addActionListener(dateListener);
		
		ActionListener saveListener = new SaveListener();
		saveButton.addActionListener(saveListener);
		
		ActionListener newListener = new NewListener();
		newButton.addActionListener(newListener);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	class ExitItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	class TaskListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			String selectedTask = taskList.getSelectedValue();
			if (selectedTask == null) {
				return;
			}
			if (selectedTask.length() > 14 && selectedTask.substring(0, 14).equals("<html><strike>")) {
				selectedTask = selectedTask.substring(14, selectedTask.length()-15);
			}
			Task temp = tasks.get(selectedTask);
			itemField.setText(temp.getName());
			priorityField.setText(Integer.toString(temp.getPriority()));
			notesArea.setText(temp.getNotes());
			if (temp.getMonth().length() == 0) {
				deadlineCheckBox.setSelected(false);
				monthBox.setSelectedItem("January");
				yearBox.setSelectedItem(2022);
				dayBox.removeAllItems();
				addDays();
				dayBox.setSelectedItem(1);
				monthBox.setEnabled(false);
				yearBox.setEnabled(false);
				dayBox.setEnabled(false);
			}
			else {
				deadlineCheckBox.setSelected(true);
				monthBox.setSelectedItem(temp.getMonth());
				yearBox.setSelectedItem(temp.getYear());
				dayBox.removeAllItems();
				addDays();
				dayBox.setSelectedItem(temp.getDay());
				monthBox.setEnabled(true);
				yearBox.setEnabled(true);
				dayBox.setEnabled(true);
			}
		}
	}
	
	class DoneListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String selectedTask = taskList.getSelectedValue();
			if (selectedTask == null) {
				return;
			}
			if (selectedTask.length() > 14 && selectedTask.substring(0, 14).equals("<html><strike>")) {
				selectedTask = selectedTask.substring(14, selectedTask.length()-15);
			}
			Task temp = tasks.get(selectedTask);
			if (temp.isCompleted()) {
				temp.setCompletion(false);
				changeTaskList(selectedTask);
			}
			else {
				temp.setCompletion(true);
				changeTaskList("<html><strike>"+selectedTask+"</strike><html>");
			}
		}
	}
	
	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String selectedTask = taskList.getSelectedValue();
			if (selectedTask == null) {
				return;
			}
			if (selectedTask.length() > 14 && selectedTask.substring(0, 14).equals("<html><strike>")) {
				selectedTask = selectedTask.substring(14, selectedTask.length()-15);
			}
			tasks.remove(itemField.getText());
			itemField.setText("");
			priorityField.setText("");
			notesArea.setText("");
			deadlineCheckBox.setSelected(false);
			monthBox.setSelectedItem("January");
			yearBox.setSelectedItem(2022);
			dayBox.removeAllItems();
			addDays();
			dayBox.setSelectedItem(1);
			monthBox.setEnabled(false);
			yearBox.setEnabled(false);
			dayBox.setEnabled(false);
			taskList.clearSelection();
			changeTaskList("");
		}
	}
	
	class DeadlineListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (deadlineCheckBox.isSelected()) {
				monthBox.setEnabled(true);
				yearBox.setEnabled(true);
				dayBox.setEnabled(true);
			}
			else {
				monthBox.setEnabled(false);
				yearBox.setEnabled(false);
				dayBox.setEnabled(false);
			}
		}
	}
	
	
	class DateListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int selectedDate = (int) dayBox.getSelectedItem();
			dayBox.removeAllItems();
			int highestDate = addDays();
			if (selectedDate > highestDate) {
				dayBox.setSelectedItem(highestDate);
			}
			else {
				dayBox.setSelectedItem(selectedDate);
			}
		}
	}
	
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (itemField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (priorityField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!isInteger(priorityField.getText())) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (Integer.parseInt(priorityField.getText()) < 1) {
				JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String selectedTask = taskList.getSelectedValue();
			if (selectedTask == null) {
				if (tasks.containsKey(itemField.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					if (deadlineCheckBox.isSelected()) {
						tasks.put(itemField.getText(), new Task(itemField.getText(), Integer.parseInt(priorityField.getText()), (String) monthBox.getSelectedItem(), (int) dayBox.getSelectedItem(), (int) yearBox.getSelectedItem(), notesArea.getText()));
					}
					else {
						tasks.put(itemField.getText(), new Task(itemField.getText(), Integer.parseInt(priorityField.getText()), "", 0, 0, notesArea.getText()));
					}
				}
			}
			else {
				if (tasks.containsKey(itemField.getText()) && !selectedTask.equals(itemField.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					tasks.remove(selectedTask);
					if (deadlineCheckBox.isSelected()) {
						tasks.put(itemField.getText(), new Task(itemField.getText(), Integer.parseInt(priorityField.getText()), (String) monthBox.getSelectedItem(), (int) dayBox.getSelectedItem(), (int) yearBox.getSelectedItem(), notesArea.getText()));
					}
					else {
						tasks.put(itemField.getText(), new Task(itemField.getText(), Integer.parseInt(priorityField.getText()), "", 0, 0, notesArea.getText()));
					}
				}
			}
			changeTaskList(itemField.getText());
			JOptionPane.showMessageDialog(null, "Item saved!", "Success", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			itemField.setText("");
			priorityField.setText("");
			notesArea.setText("");
			deadlineCheckBox.setSelected(false);
			monthBox.setSelectedItem("January");
			yearBox.setSelectedItem(2022);
			dayBox.removeAllItems();
			addDays();
			dayBox.setSelectedItem(1);
			monthBox.setEnabled(false);
			yearBox.setEnabled(false);
			dayBox.setEnabled(false);
			taskList.clearSelection();
		}
	}
	
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		return menu;
	}
	
	private void createUIPanel() {
		JPanel UIPanel = new JPanel();
		UIPanel.setLayout(new GridLayout(1,2));
		UIPanel.add(createLeftPanel());
		UIPanel.add(createRightPanel());
		add(UIPanel, BorderLayout.CENTER);
	}
	
	private JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(), "ToDo List"));
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(createTaskPanel(), BorderLayout.CENTER);
		leftPanel.add(createButtonPanel1(), BorderLayout.EAST);
		return leftPanel;
	}
	
	private JPanel createTaskPanel() {
		JPanel taskPanel = new JPanel();
		taskPanel.setLayout(new BorderLayout());
		taskList = new JList<String>();
		taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(taskList);
		taskPanel.add(scrollPane, BorderLayout.CENTER);
		return taskPanel;
	}
	
	private JPanel createButtonPanel1() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(12,1,1,6));
		doneButton = new JButton("Toggle Done");
		deleteButton = new JButton("Delete");
		for (int i = 0; i < 5; i++) {
			buttonPanel.add(new JPanel());
		}
		buttonPanel.add(doneButton);
		buttonPanel.add(deleteButton);
		for (int i = 0; i < 5; i++) {
			buttonPanel.add(new JPanel());
		}
		return buttonPanel;
	}
	
	private JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(5,1));
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(), "Item"));
		rightPanel.add(createItemPanel());
		rightPanel.add(createPriorityPanel());
		rightPanel.add(createDeadlinePanel());
		rightPanel.add(createNotesPanel());
		rightPanel.add(createButtonPanel2());
		return rightPanel;
	}
	
	private JPanel createItemPanel() {
		JPanel itemPanel = new JPanel();
		JLabel itemLabel = new JLabel("Item: ");
		itemField = new JTextField(ITEM_FIELD_WIDTH);
		itemField.setText("");
		itemPanel.add(itemLabel);
		itemPanel.add(itemField);	
		return itemPanel;
	}
	
	private JPanel createPriorityPanel() {
		JPanel priorityPanel = new JPanel();
		JLabel priorityLabel = new JLabel("Priority: ");
		priorityField = new JTextField(PRIORITY_FIELD_WIDTH);
		priorityField.setText("");
		priorityPanel.add(priorityLabel);
		priorityPanel.add(priorityField);
		return priorityPanel;
	}
	
	private JPanel createDeadlinePanel() {
		JPanel deadlinePanel = new JPanel();
		deadlineCheckBox = new JCheckBox("Deadline");
		JLabel monthLabel = new JLabel("Month: ");
		monthBox = new JComboBox<String>();
		monthBox.setSize(MONTH_WIDTH, MONTH_HEIGHT);
		addMonths();
		monthBox.setEnabled(false);
		JLabel yearLabel = new JLabel("Year: ");
		yearBox = new JComboBox<Integer>();
		yearBox.setSize(YEAR_WIDTH, YEAR_HEIGHT);
		addYears();
		yearBox.setEnabled(false);
		JLabel dayLabel = new JLabel("Day: ");
		dayBox = new JComboBox<Integer>();
		dayBox.setSize(DAY_WIDTH, DAY_HEIGHT);
		addDays();
		dayBox.setEnabled(false);
		deadlinePanel.add(deadlineCheckBox);
		deadlinePanel.add(monthLabel);
		deadlinePanel.add(monthBox);
		deadlinePanel.add(dayLabel);
		deadlinePanel.add(dayBox);
		deadlinePanel.add(yearLabel);
		deadlinePanel.add(yearBox);
		return deadlinePanel;
	}
	
	private JPanel createNotesPanel() {
		JPanel notesPanel = new JPanel();
		JLabel notesLabel = new JLabel("Notes: ");
		notesArea = new JTextArea(NOTES_HEIGHT, NOTES_WIDTH);
		notesArea.setText("");
		JScrollPane scrollPane = new JScrollPane(notesArea);
		notesPanel.add(notesLabel);
		notesPanel.add(scrollPane);
		return notesPanel;
	}
	
	private JPanel createButtonPanel2() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		saveButton = new JButton("Save Item");
		newButton = new JButton("New Item");
		buttonPanel.add(saveButton);
		buttonPanel.add(newButton);
		return buttonPanel;
	}
	
	private void addMonths() {
		monthBox.addItem("January");
		monthBox.addItem("February");
		monthBox.addItem("March");
		monthBox.addItem("April");
		monthBox.addItem("May");
		monthBox.addItem("June");
		monthBox.addItem("July");
		monthBox.addItem("August");
		monthBox.addItem("September");
		monthBox.addItem("October");
		monthBox.addItem("November");
		monthBox.addItem("December");
	}
	
	private int addDays() {
		HashSet<String> thirty_ones = new HashSet<String>();
		thirty_ones.add("January");
		thirty_ones.add("March");
		thirty_ones.add("May");
		thirty_ones.add("July");
		thirty_ones.add("August");
		thirty_ones.add("October");
		thirty_ones.add("December");
		HashSet<String> thirties = new HashSet<String>();
		thirties.add("April");
		thirties.add("June");
		thirties.add("September");
		thirties.add("November");
		String selectedMonth = (String) monthBox.getSelectedItem();
		int selectedYear = (int) yearBox.getSelectedItem();
		if (thirty_ones.contains(selectedMonth)) {
			for (int i = 1; i <= 31; i++) {
				dayBox.addItem(i);
			}
			return 31;
		}
		else if (thirties.contains(selectedMonth)) {
			for (int i = 1; i <= 30; i++) {
				dayBox.addItem(i);
			}
			return 30;
		}
		else if (selectedMonth.equals("February") && (selectedYear == 2024 || selectedYear == 2028)) {
			for (int i = 1; i <= 29; i++) {
				dayBox.addItem(i);
			}
			return 29;
		}
		else {
			for (int i = 1; i <= 28; i++) {
				dayBox.addItem(i);
			}
			return 28;
		}
	}
	
	private void addYears() {
		yearBox.addItem(2022);
		yearBox.addItem(2023);
		yearBox.addItem(2024);
		yearBox.addItem(2025);
		yearBox.addItem(2026);
		yearBox.addItem(2027);
		yearBox.addItem(2028);
		yearBox.addItem(2029);
		yearBox.addItem(2030);
		yearBox.addItem(2031);
	}
	
	private void changeTaskList(String s) {
		PriorityQueue<Task> tempPQueue = new PriorityQueue<Task>();
		for (Task e: tasks.values()) {
			tempPQueue.add(e);
		}
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		while (!tempPQueue.isEmpty()) {
			Task temp = tempPQueue.remove();
			if (temp.isCompleted()) {
				listModel.addElement("<html><strike>"+temp.getName()+"</strike><html>");
			}
			else {
				listModel.addElement(temp.getName());
			}
		}
		taskList.setModel(listModel);
		if (s.length() == 0) {
			taskList.clearSelection();
		}
		else {
			taskList.setSelectedValue(s, true);
		}
	}
	
	private boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		JFrame frame = new ToDos();
		frame.setTitle("An Le - 26801474");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
