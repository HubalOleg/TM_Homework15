package oleg.hubal.com.tm_homework15;

/**
 * Created by User on 29.03.2016.
 */
public class User {
    private String password, login, name, surname;

    public User(String login, String password,String name,String surname) {
        this.password = password;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}