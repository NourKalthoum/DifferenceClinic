package com.example.difference_clinic.models;

import java.util.Objects;

public class QuestionModels {
   
    private Long id;
    private String questionText;
    private String answer;


    public QuestionModels() {
    }

    public QuestionModels(Long id, String questionText, String answer) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionModels id(Long id) {
        setId(id);
        return this;
    }

    public QuestionModels questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public QuestionModels answer(String answer) {
        setAnswer(answer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuestionModels)) {
            return false;
        }
        QuestionModels questionModels = (QuestionModels) o;
        return Objects.equals(id, questionModels.id) && Objects.equals(questionText, questionModels.questionText) && Objects.equals(answer, questionModels.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answer);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", questionText='" + getQuestionText() + "'" +
            ", answer='" + getAnswer() + "'" +
            "}";
    }

}
