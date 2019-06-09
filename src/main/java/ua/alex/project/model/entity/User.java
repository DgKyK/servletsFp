package ua.alex.project.model.entity;

import ua.alex.project.model.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {

    }

    public User(long id, String login, String password, String email, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(long id) {
            User.this.id = id;

            return this;
        }

        public Builder setLogin(String login) {
            User.this.login = login;

            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;

            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;

            return this;
        }

        public Builder setRole(Role role) {
            User.this.role = role;

            return this;
        }

        public User build() {
            return User.this;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
