//Jeremy Gallardo
//10/10/21
//gallarj@pnw.edu
import java.io.File;
import java.util.Scanner;

public class DFSMex1{
   static Scanner file;   //scanner object to read file input
   static Scanner terminal;   //scanner object to read file input
   static int total_input_characters;   //total number of input symbols
   static char input_characters[];   //array of input symbols
   static int total;   //total number of states
   static int accepting[];   //array of accepting states
   static int state_transition_table[][];  
  
   //function to find the index of input symbol
   private static int indexOfSymbol(char character) {
       for(int i = 0; i < total_input_characters; i++) {
           if(input_characters[i] == character) {
               return i;
           }
       }
       return -1;
   }
  
   private static void StateTable() {
       state_transition_table = new int[total][total_input_characters];
       for(int i = 0; i < total; i++) {
           String line = file.nextLine().replaceAll(" ", "").replaceAll("\\),\\(", " ");
           line = line.replaceAll("\\(", "").replaceAll("\\)", "");
           String lines[] = line.split(" ");
           for(int j = 0; j < lines.length; j++) {
               String splits[] = lines[j].split(",");
               state_transition_table[Integer.parseInt(splits[0])][indexOfSymbol(splits[1].charAt(0))]
                       = Integer.parseInt(splits[2]);
           }
       }
   }
  
   //function to read all inputs of DFSM from file
   private static void buildDFSM() {
       try {
           file = new Scanner(new File(terminal.nextLine()));
           String line;
           line = file.nextLine();
           String lines[] = line.replaceAll(" ", "").split(",");
           total_input_characters = lines.length;
           input_characters = new char[total_input_characters];
           for(int i = 0; i < total_input_characters; i++) {
               input_characters[i] = lines[i].charAt(0);
           }
           total = Integer.parseInt(file.nextLine());
           lines = file.nextLine().replaceAll(" ", "").split(",");
           accepting = new int[lines.length];
           for(int i = 0; i < lines.length; i++) {
               accepting[i] = Integer.parseInt(lines[i]);
           }
           StateTable();
       }
       catch(Exception e) {
           e.printStackTrace();
       }
   }
  
   //function to check if the input string is accepted by the DFSM
   private static boolean checkAcceptance(String input) {
       int current_state = 0;
       char current_input_character;
       for(int i = 0; i < input.length(); i++) {
           current_input_character = input.charAt(i);
           int indx = indexOfSymbol(current_input_character);
           if(indx == -1) {
             System.out.println("Incorrect String Format try again");
             return false;
           }
           current_state = state_transition_table[current_state][indx];
       }
       for(int i = 0; i < accepting.length; i++) {
           if(current_state == accepting[i]) {
               return true;
           }
       }
       return false;
   }
  
   //main function
   public static void main(String [] args) {
       terminal = new Scanner(System.in);   //initialize scanner
       System.out.print("Enter the DFSM file name: ");
       buildDFSM();   //reading inputs from file
       String choice = "Y"; // make it auto equal to y so that the while statement intializes
       String input;
       while(choice.equals("Y") || choice.equals("y")) {
           System.out.print("Input a string: ");
           input = terminal.nextLine();   //read input string from console
           System.out.println(checkAcceptance(input));   //check and print acceptance of string
           System.out.print("Would you like to input another string? (Y/N): ");
           choice = terminal.nextLine();   //read user input for quitting
          
             
       }
       if(choice.equals("N") || choice.equals("n"))
       {
         System.out.print("Thank you now exiting....");
       }
   }
}