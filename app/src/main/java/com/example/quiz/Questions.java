package com.example.quiz;

public class Questions {
    public int question;
    public boolean isCorrect;

    public Questions(boolean isCorrect, int question) {
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

}
