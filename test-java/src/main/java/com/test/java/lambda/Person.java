package com.test.java.lambda;

/**
 * 2019/1/20 cx
 */
public class Person {
    private String no;
    private String name;
    private Integer age;
    private Double price;
    private String group;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", group='" + group + '\'' +
                '}';
    }
}
