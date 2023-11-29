package domain.user;

public class User {

    private int userId;
    private String email;
    private String password;
    private String nickname;
    private Grade grade;

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.grade = Grade.BASIC;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public Grade getGrade() {
        return grade;
    }
}
