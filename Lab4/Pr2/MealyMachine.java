import java.util.HashMap;
import java.util.Map;

enum MealyState {
    Q1, Q2
}

class MealyMachine {
    private MealyState currentState;
    private Map<MealyState, Map<Character, MealyState>> transitions;
    private Map<MealyState, Map<Character, String>> outputs;

    public MealyMachine() {
        currentState = MealyState.Q1;
        
        transitions = new HashMap<>();
        outputs = new HashMap<>();
        
        Map<Character, MealyState> q1Trans = new HashMap<>();
        q1Trans.put('X', MealyState.Q2);
        q1Trans.put('Y', MealyState.Q1);
        transitions.put(MealyState.Q1, q1Trans);
        
        Map<Character, String> q1Out = new HashMap<>();
        q1Out.put('X', "O1");
        q1Out.put('Y', "O1");
        outputs.put(MealyState.Q1, q1Out);
        
        Map<Character, MealyState> q2Trans = new HashMap<>();
        q2Trans.put('X', MealyState.Q1);
        q2Trans.put('Y', MealyState.Q2);
        transitions.put(MealyState.Q2, q2Trans);
        
        Map<Character, String> q2Out = new HashMap<>();
        q2Out.put('X', "O2");
        q2Out.put('Y', "O2");
        outputs.put(MealyState.Q2, q2Out);
    }

    public String processInput(char input) {
        if (!transitions.get(currentState).containsKey(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        
        String output = outputs.get(currentState).get(input);
        currentState = transitions.get(currentState).get(input);
        return output;
    }

    public static void main(String[] args) {
        MealyMachine mealy = new MealyMachine();
        
        System.out.println("Input X: " + mealy.processInput('X'));
        System.out.println("Input Y: " + mealy.processInput('Y'));
    }
}