public class Question {
    private String questionText = "";
    private String questionAnswer = "";
    private int questionDifficulty = 1;

    public Question(String questionText,String questionAnswer,int questionDifficulty){
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
        this.questionDifficulty = questionDifficulty;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

}
