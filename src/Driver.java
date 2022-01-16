import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Quiz q1 = new Quiz();
        boolean running = true;

        do{
            displayMenu();
            int userInput = getValidateUserInput();
            switch (userInput){
                case 1:
                    q1.add_question();
                    break;
                case 2:
                    q1.remove_question();
                    break;
                case 3:
                    q1.modify_question();
                    break;
                case 4:
                    q1.give_quiz();
                    break;
                case 5:
                    running = false;
                    break;
            }
        }while (running);

    }
    public static void displayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add a question to the quiz.");
        System.out.println("2. Remove a question from the quiz.");
        System.out.println("3. Modify a question  in the quiz.");
        System.out.println("4. Take the quiz.");
        System.out.println("5. Quit.");
    }

    public static int getValidateUserInput(){
        Scanner sc = new Scanner(System.in);
        int userInput;
        boolean testPassed = false;

        while(!testPassed){
            if(sc.hasNextInt()){
                userInput = sc.nextInt();
                if(userInput >= 0 && userInput <= 5){
                    return userInput;
                }else{
                    System.out.println("Please enter a value between 0-5.");
                }
            }else{
                System.out.println("Please enter an integer.");
                sc.next();
            }
        }
        return -1; // This line should never execute.
    }
}
