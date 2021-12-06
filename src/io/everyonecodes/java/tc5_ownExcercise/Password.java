package io.everyonecodes.java.tc5_ownExcercise;

import java.util.Objects;

public class Password {
    private String name;
    private String password;

    public Password(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(name, password1.name) && Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
