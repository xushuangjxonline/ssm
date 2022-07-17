package com.java.user.entity;

/**
 * @author xushuang
 * @date 2020/7/9 - 15:55
 */
public class UserModel {

    private Integer uid;
    private String  username;
    private String  password;
    private String  question;
    private String  answer;
    private Integer power;

    public UserModel() {
    }

    public UserModel(Integer uid, String username, String password, String question, String answer, Integer power) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", power=" + power +
                '}';
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
