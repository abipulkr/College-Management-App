package com.splash.user.first;

public class Question {

    public static final String DIFFICULTY_EASY="Easy";
    public static final String DIFFICULTY_MEDIUM="Medium";
    public static final String DIFFICULTY_HARD="Hard";

    public static final String CATEGORY_QUANTITATIVE="Quantitative";
    public static final String CATEGORY_LOGICAL="Logical";
    public static final String CATEGORY_VERBAL="Verbal";
    public static final String CATEGORY_COMPUTER_PROGRAMMING="Computer Programming";

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private String difficulty;
    private String category;

    public Question(){}

    public Question(String question, String option1, String option2, String option3, String option4, int answerNr,String difficulty,String category) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.difficulty=difficulty;
        this.category=category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllDifficultyLevels(){
        return new String[]{
                DIFFICULTY_EASY,
                DIFFICULTY_MEDIUM,
                DIFFICULTY_HARD
        };
    }

    public static String[] getAllCategories(){
        return new String[]{
                CATEGORY_QUANTITATIVE,
                CATEGORY_LOGICAL,
                CATEGORY_VERBAL,
                CATEGORY_COMPUTER_PROGRAMMING
        };
    }
}
