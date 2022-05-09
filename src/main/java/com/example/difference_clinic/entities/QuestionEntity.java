package com.example.difference_clinic.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questionText;
    private String answer;
    private String questionStatus;
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;

    public QuestionEntity() {
    }

    public QuestionEntity(Long id, String questionText, String answer, String questionStatus, UserEntity user) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
        this.questionStatus = questionStatus;
        this.user = user;
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

    public String getQuestionStatus() {
        return this.questionStatus;
    }

    public void setQuestionStatus(String questionStatus) {
        this.questionStatus = questionStatus;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public QuestionEntity id(Long id) {
        setId(id);
        return this;
    }

    public QuestionEntity questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public QuestionEntity answer(String answer) {
        setAnswer(answer);
        return this;
    }

    public QuestionEntity questionStatus(String questionStatus) {
        setQuestionStatus(questionStatus);
        return this;
    }

    public QuestionEntity user(UserEntity user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuestionEntity)) {
            return false;
        }
        QuestionEntity questionEntity = (QuestionEntity) o;
        return Objects.equals(id, questionEntity.id) && Objects.equals(questionText, questionEntity.questionText) && Objects.equals(answer, questionEntity.answer) && Objects.equals(questionStatus, questionEntity.questionStatus) && Objects.equals(user, questionEntity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answer, questionStatus, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", questionText='" + getQuestionText() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", questionStatus='" + getQuestionStatus() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }


}
