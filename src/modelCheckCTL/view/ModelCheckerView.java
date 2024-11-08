package modelCheckCTL.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModelCheckerView extends JFrame {
    private JTextField kripkeFileField = new JTextField(20);
    private JTextField ctlFormulaField = new JTextField(20);
    private JTextField stateIdField = new JTextField(10);
    private JButton checkButton = new JButton("Check Property");
    private JTextArea resultArea = new JTextArea(10, 30);

    public ModelCheckerView() {
        setTitle("CTL Model Checker");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Kripke Structure File:"));
        inputPanel.add(kripkeFileField);
        inputPanel.add(new JLabel("CTL Formula:"));
        inputPanel.add(ctlFormulaField);
        inputPanel.add(new JLabel("State ID:"));
        inputPanel.add(stateIdField);
        inputPanel.add(checkButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        resultArea.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public String getKripkeFilePath() {
        return kripkeFileField.getText();
    }

    public String getCtlFormula() {
        return ctlFormulaField.getText();
    }

    public String getStateId() {
        return stateIdField.getText();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addCheckListener(ActionListener listener) {
        checkButton.addActionListener(listener);
    }
}
