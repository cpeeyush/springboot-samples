package com.peeyush.api.dtos;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserRequest {
    //@NotEmpty
    @Pattern(regexp = "^(?!\\s*$).+", message = "must not be blank")
    private String id;
    @Pattern(regexp = "^(?!\\s*$).+", message = "must not be blank")
    @Size(min = 1, max = 10)
    private String name;
    @Positive
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return id.equals(that.id) && name.equals(that.name) && age.equals(that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
