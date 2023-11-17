import java.util.HashMap;
import java.util.Map;

public class State {
    String stateName;
    boolean startState = false;
    boolean finishState = false;
    Map<String, State> adj = new HashMap<>();

    public State(String stateName, boolean startState, boolean finishState){
        this.stateName = stateName;
        this.startState = startState;
        this.finishState = finishState;
    }  

    public void addAdj(State s, String input){
        adj.put(input, s);
    }

    public State getAdjState(String i){
        
        return adj.get(i);
    }
}