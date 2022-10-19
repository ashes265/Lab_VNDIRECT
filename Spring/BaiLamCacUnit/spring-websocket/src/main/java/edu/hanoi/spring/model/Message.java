package edu.hanoi.spring.model;

public class Message {
    private String content;

    public Message(){

    }
    public Message(String message) {
        this.content = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
