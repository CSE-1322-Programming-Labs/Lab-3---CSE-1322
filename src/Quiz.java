import java.util.ArrayList;
import java.util.Scanner;
public class Quiz {
    private ArrayList<Question> questionList = new ArrayList<>();

    public void add_question(){
        //The create question is a method that prompts the user for a new question, answer, and difficulty.
        //This method just adds the new question. The reason why I created a new method for creating a question is
        //because there is overlap between creating new questions and modifying old ones.
        questionList.add(createQuestion());
    }

    public void remove_question() {
        if(!hasQuestions()){
            System.out.println("You need to have questions in order to remove them.");
            return;
        }

        System.out.println("Which question to remove?");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println(i + "." + questionList.get(i).getQuestionText());
        }
        questionList.remove(getValidateUserInput());
    }

    public void modify_question(){
        if(!hasQuestions()){
            System.out.println("You need to have questions in order to modify them.");
            return;
        }

        System.out.println("Choose question to modify?");
        Scanner sc = new Scanner(System.in);
        for(int i= 0;i< questionList.size();i++){
            System.out.println(i+"."+questionList.get(i).getQuestionText());
        }
        int userInput = getValidateUserInput();
        questionList.set(userInput,createQuestion());
    }

    public void give_quiz(){
        if(!hasQuestions()){
            System.out.println("You need to have questions in order to take them.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int correctCounter = 0;
        for(int i=0;i<questionList.size();i++){
            System.out.println(questionList.get(i).getQuestionText());
            if((sc.nextLine().trim()).equals(questionList.get(i).getQuestionAnswer())){
                System.out.println("Correct");
                correctCounter++;
            }else{
                System.out.println("Incorrect");
            }
        }

        //This will display the end score.
        System.out.println("You got "+correctCounter+" out of "+questionList.size()+ "("+((float)correctCounter/ questionList.size() * 100)+ "%)");
    }

    //This method will create a new question by prompting the user for question text,answer, and difficulty.
    //This method also handles exceptions and returns the Question object.
    private Question createQuestion(){
        Scanner sc = new Scanner(System.in);
        int difficulty = 1;
        System.out.println("What is the question Text?");
        String questionText = sc.nextLine();
        System.out.println("What is the answer?");
        String questionAnswer = sc.nextLine();
        System.out.println("How difficult?"); //This is some input validation for difficulty to make sure that we don't get an unexpected value.
        boolean testPassed = false;
        while(!testPassed){
            if(sc.hasNextInt()){
                difficulty = sc.nextInt();
                if(difficulty >= 1 && difficulty <= 3){
                    testPassed = true;
                }else{
                    System.out.println("Please enter a value between 1-3.");
                }
            }else{
                System.out.println("Please enter an integer.");
                sc.nextLine();
            }
        }
        return new Question(questionText,questionAnswer,difficulty);
    }

    //This method just checks to make sure that the questionlist actually has questions.
    private boolean hasQuestions(){
        if(questionList.size() == 0)return false;
        else return true;
    }

    //This method is as the method name says, it gets and validates userInput. It is used for whenever we deal with the
    //questionlist and ask for a userInput as we do not want to go out of bounds.
    private int getValidateUserInput(){
        if(!hasQuestions())return-1; // if for some reason we didnt check first if the questionlist actually had questions, and it has 0 questions than we return -1;

        int length = questionList.size();
        Scanner sc = new Scanner(System.in);

        int userInput;
        boolean testPassed = false;

        while(!testPassed){
            if(sc.hasNextInt()){
                userInput = sc.nextInt();
                if(userInput >= 0 && userInput <= (length-1)){
                    return userInput;
                }else{
                    System.out.println("Please enter a value between "+0+" and "+(length-1));
                }
            }else{
                System.out.println("Please enter an integer.");
                sc.next();
            }
        }

        return -1; // This line should never execute.
    }

}
