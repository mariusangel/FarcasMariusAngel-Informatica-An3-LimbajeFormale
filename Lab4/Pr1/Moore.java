import java.util.HashMap;
import java.util.Map;

enum MooreState {
    S1, S2
}

class MooreMachine {
    private MooreState currentState;
    private Map<MooreState, String> outputs;

    public MooreMachine() {
        currentState = MooreState.S1;
        outputs = new HashMap<>();
        outputs.put(MooreState.S1, "O1");
        outputs.put(MooreState.S2, "O2");
    }

    public void transition(char input) {
        switch (currentState) {
            case S1:
                if (input == 'B') currentState = MooreState.S2;
                break;
            case S2:
                if (input == 'A') currentState = MooreState.S1;
                break;
            default:
                throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    
    public String getOutput() {
        return outputs.get(currentState);
    }

    public static void main(String[] args) {
        MooreMachine moore = new MooreMachine();
        System.out.println("Initial output: " + moore.getOutput());

        moore.transition('A');
        System.out.println("After A: " + moore.getOutput());

        moore.transition('B');
        System.out.println("After B: " + moore.getOutput());
    }
}