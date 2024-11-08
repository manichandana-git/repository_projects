package modelCheckCTL.model;

import java.util.Set;

public class State {
    private String id;
    private Set<String> atoms;

    public State(String id, Set<String> atoms) {
        this.id = id;
        this.atoms = atoms;
    }

    public String getId() {
        return id;
    }

    public Set<String> getAtoms() {
        return atoms;
    }
}
