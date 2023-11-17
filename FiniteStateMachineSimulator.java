import java.util.Scanner;
public class FiniteStateMachineSimulator {
 
        public static void main(String[] args) {
            // Create a Machine
            Scanner myScanner = new Scanner(System.in);
            boolean exitCondition = false;
            System.out.println("WELCOME TO FINITE STATE MACHINE SIMULATOR");
            System.out.println("To get started, enter your machine state names in following format: \n StateA, StateB, StateC, StateD, StateE");
            String input = myScanner.nextLine();
           
            Machine myMachine = new Machine(input);
            
            System.out.println("Now specify transitions between states and the inputs to invoke them, once you're done just type finish: \n Example:\n StateA->StateB,input1\n" + //
                    "StateB->StateC,input2 \n" + //
                    "StateB->StateD,input3 \n" + //
                    "StateC->StateE,input4 \n" + //
                    "finish");
            
                    // Set up state connections
            String inputString = "";
            while(!input.equals("finish")){
                 System.out.println("------");
                 input = myScanner.nextLine();
                  System.out.println(input);
                 inputString = inputString + input + "\n";
            }
            myMachine.setStateConnections(inputString);
    
            // Start the machine
            myMachine.startMachine();
            System.out.println("Machine has started! Provide inputs");
            
            while(!exitCondition){
                input = myScanner.nextLine();

                if(input.equalsIgnoreCase("exit")){
                    exitCondition = true;
                }else{
                    simulateMachine(myMachine, input);
                }
            }
           
        }
    
        public static void simulateMachine(Machine machine, String input) {
            System.out.println("Current State: " + machine.active.stateName);
    
          
                machine.setMachineState(input);
    
            // Print the updated state
            System.out.println("Input: " + input);
            System.out.println("New State: " + machine.active.stateName);
            System.out.println("------------");
        }
    
    
}