package com.example.difference_clinic.payload.request;

import java.util.Objects;

public class TextRequest {
    
   private String text;

    public TextRequest() {
    }

    public TextRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextRequest text(String text) {
        setText(text);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TextRequest)) {
            return false;
        }
        TextRequest textRequest = (TextRequest) o;
        return Objects.equals(text, textRequest.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }

    @Override
    public String toString() {
        return "{" +
            " text='" + getText() + "'" +
            "}";
    }
   
}
