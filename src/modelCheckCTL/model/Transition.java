package modelCheckCTL.model;

public class Transition {
    private State fromState;
    private State toState;

    public Transition(State fromState, State toState) {
        this.fromState = fromState;
        this.toState = toState;
    }

    public State getFromState() {
        return fromState;
    }

    public State getToState() {
        return toState;
    }
}
