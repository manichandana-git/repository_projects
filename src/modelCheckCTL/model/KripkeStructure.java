package modelCheckCTL.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class KripkeStructure {
    private Map<String, State> states;
    private List<Transition> transitions;

    public KripkeStructure(List<State> states, List<Transition> transitions) {
        this.states = new HashMap<>();
        for (State state : states) {
            this.states.put(state.getId(), state);
        }
        this.transitions = transitions;
    }

    public State getStateById(String id) {
        return states.get(id);
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
