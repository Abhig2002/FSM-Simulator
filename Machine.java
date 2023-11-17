import java.util.HashMap;
import java.util.Map;

public class Machine {

    Map<String, State> states = new HashMap<>();

    String startStateName;
    String finishStateName;
    State active = null;
    
    public Machine(String statesInputString){

        for (String s : statesInputString.split(",")){
            
            if(s.equals(statesInputString.split(",")[0])){

                startStateName = s.trim();
                State state = new State(startStateName, true, false);
                states.put(state.stateName, state);

            }
            else if(s.equals(statesInputString.split(",")[statesInputString.split(",").length - 1])){
                
                finishStateName = s.trim();
                State state = new State(finishStateName, false, true);
                states.put(state.stateName, state);

            } 
            else{

                State state = new State(s.trim(), false, false);
                states.put(state.stateName, state);

            }
            
        }
    }

    public void setStateConnections(String inputString) {
        for (String statement : inputString.split("\n")) {
            if (statement.equals("finish")) {
                break;
            }
            if (statement.contains("->")) {
                String connection = statement.split(",")[0];
                states.get(connection.split("->")[0].trim()).addAdj(states.get(connection.split("->")[1].trim()), statement.split(",")[1]);
            } else {
                System.out.println("Invalid transition format: " + statement);
            }
        }
    }
    

    public void startMachine(){
        active = states.get(startStateName);
    }

    public void setMachineState(String i){
       if(active.getAdjState(i) == null){
            System.out.println("No such input exists for current state");
       }
       else{
            active = active.getAdjState(i);
       }
        
    }
}