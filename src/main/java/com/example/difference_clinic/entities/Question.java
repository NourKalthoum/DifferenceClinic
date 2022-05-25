package com.example.difference_clinic.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "question")
@Document(indexName = "question", type = "question", shards = 1)
public class Question {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questionText;
    private String answer;
    private boolean common;
    @JsonIgnoreProperties(value = {"question"},allowSetters = true)
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;


    public Question() {
    }

    public Question(Long id, String questionText, String answer, boolean common, UserEntity user) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
        this.common = common;
        this.user = user;
    }

    public Question(Long id, String questionText, String answer) {
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

    public boolean isCommon() {
        return this.common;
    }

    public boolean getCommon() {
        return this.common;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Question id(Long id) {
        setId(id);
        return this;
    }

    public Question questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public Question answer(String answer) {
        setAnswer(answer);
        return this;
    }

    public Question common(boolean common) {
        setCommon(common);
        return this;
    }

    public Question user(UserEntity user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Question)) {
            return false;
        }
        Question questionEntity = (Question) o;
        return Objects.equals(id, questionEntity.id) && Objects.equals(questionText, questionEntity.questionText) && Objects.equals(answer, questionEntity.answer) && common == questionEntity.common && Objects.equals(user, questionEntity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answer, common, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", questionText='" + getQuestionText() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", common='" + isCommon() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
   
}
