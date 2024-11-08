package modelCheckCTL.controller;

import modelCheckCTL.model.*;
import modelCheckCTL.view.ModelCheckerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ModelCheckerController {
    private ModelCheckerView view;
    private KripkeStructure kripkeStructure;

    public ModelCheckerController(ModelCheckerView view) {
        this.view = view;
        this.view.addCheckListener(new CheckButtonListener());
    }

    private void loadKripkeStructure(String filePath) {
        List<State> states = new ArrayList<>();
        List<Transition> transitions = new ArrayList<>();
        Map<String, State> stateMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Parse states
            line = reader.readLine();
            if (line != null) {
                String[] stateIds = line.split(", ");
                for (String stateId : stateIds) {
                    State state = new State(stateId, new HashSet<>());
                    states.add(state);
                    stateMap.put(stateId, state);
                }
            }

            // Parse transitions
            while ((line = reader.readLine()) != null && line.startsWith("t")) {
                String[] parts = line.split(": ");
                String[] transStates = parts[1].split(" - ");
                State from = stateMap.get(transStates[0]);
                State to = stateMap.get(transStates[1]);
                if (from != null && to != null) {
                    transitions.add(new Transition(from, to));
                }
            }

            // Parse propositional atoms
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                String stateId = parts[0];
                String[] atoms = parts[1].split(" ");
                State state = stateMap.get(stateId);
                if (state != null) {
                    state.getAtoms().addAll(Arrays.asList(atoms));
                }
            }
            this.kripkeStructure = new KripkeStructure(states, transitions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkProperty(String stateId, CtlFormula ctlFormula) {
        State state = kripkeStructure.getStateById(stateId);
        if (state == null || !ctlFormula.isValidSyntax()) {
            return false; 
        }
        return evaluateFormula(state, ctlFormula);
    }

    private boolean evaluateFormula(State state, CtlFormula formula) {
        return false;
    }

    class CheckButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String kripkeFile = view.getKripkeFilePath();
            String ctlFormulaStr = view.getCtlFormula();
            String stateId = view.getStateId();

            if (kripkeFile.isEmpty() || ctlFormulaStr.isEmpty() || stateId.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please fill all fields.");
                return;
            }

            loadKripkeStructure(kripkeFile);
            CtlFormula ctlFormula = new CtlFormula(ctlFormulaStr);

            boolean result = checkProperty(stateId, ctlFormula);
            view.setResult("Property " + ctlFormulaStr + (result ? " holds" : " does not hold") + " in state " + stateId);
        }
    }
}
