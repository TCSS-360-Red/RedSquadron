import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TaskWindow extends JFrame {
    private JPanel contentPane;
    private JTextField projectNameField;
    private JTextField budgetField;
    private JTextField dueDateField;
    private JTextField currentExpenseField;
    private JTextField currentDayField;
    private JTextField taskNumberField;
    private JTextField expensesField;
    private JButton newFileButton;
    private JButton saveFileButton;
    private JButton editButton;
    private JButton addTaskButton;
    private JLabel pieChartLabel;

    private TaskList taskList;

    public TaskWindow(TaskList taskList) {
        this.taskList = taskList;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Budget Balancer 3000");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Project Name field
        JLabel projectNameLabel = new JLabel("Project Name:");
        projectNameLabel.setBounds(10, 10, 100, 25);
        contentPane.add(projectNameLabel);

        projectNameField = new JTextField();
        projectNameField.setBounds(120, 10, 200, 25);
        contentPane.add(projectNameField);

        // Budget field
        JLabel budgetLabel = new JLabel("Budget:");
        budgetLabel.setBounds(10, 40, 100, 25);
        contentPane.add(budgetLabel);

        budgetField = new JTextField();
        budgetField.setBounds(120, 40, 200, 25);
        contentPane.add(budgetField);

        // Due Date field
        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setBounds(10, 70, 100, 25);
        contentPane.add(dueDateLabel);

        dueDateField = new JTextField();
        dueDateField.setBounds(120, 70, 200, 25);
        contentPane.add(dueDateField);

        // Current Expense field
        JLabel currentExpenseLabel = new JLabel("Current Expense:");
        currentExpenseLabel.setBounds(10, 100, 100, 25);
        contentPane.add(currentExpenseLabel);

        currentExpenseField = new JTextField();
        currentExpenseField.setBounds(120, 100, 200, 25);
        contentPane.add(currentExpenseField);

        // Current Day field
        JLabel currentDayLabel = new JLabel("Current Day:");
        currentDayLabel.setBounds(10, 130, 100, 25);
        contentPane.add(currentDayLabel);

        currentDayField = new JTextField();
        currentDayField.setBounds(120, 130, 200, 25);
        contentPane.add(currentDayField);

        // Pie chart label
        pieChartLabel = new JLabel();
        pieChartLabel.setBounds(450, 10, 300, 200);
        contentPane.add(pieChartLabel);

        // Task Number field
        JLabel taskNumberLabel = new JLabel("Task 1:");
        taskNumberLabel.setBounds(10, 190, 100, 25);
        contentPane.add(taskNumberLabel);

        taskNumberField = new JTextField();
        taskNumberField.setBounds(120, 190, 200, 25);
        contentPane.add(taskNumberField);

        // Expenses field
        JLabel expensesLabel = new JLabel("Expenses:");
        expensesLabel.setBounds(10, 220, 100, 25);
        contentPane.add(expensesLabel);

        expensesField = new JTextField();
        expensesField.setBounds(120, 220, 200, 25);
        contentPane.add(expensesField);

        // New File button
        newFileButton = new JButton("New File");
        newFileButton.setBounds(450, 250, 100, 25);
        contentPane.add(newFileButton);

        // Save File button
        saveFileButton = new JButton("Save File");
        saveFileButton.setBounds(560, 250, 100, 25);
        contentPane.add(saveFileButton);

        // Edit button
        editButton = new JButton("Edit");
        editButton.setBounds(670, 250, 100, 25);
        contentPane.add(editButton);

        // Add Task button
        addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(10, 250, 100, 25);
        contentPane.add(addTaskButton);
    }
}