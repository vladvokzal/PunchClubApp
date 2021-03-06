package ru.nsu.lightweight.punchclub.profile;

public class Profile {
    private String name;
    private int age;
    private String city;
    private String sex;
    private int imageLink;

    public int getImageLink() {
        return imageLink;
    }

    public void setImageLink(int imageLink) {
        this.imageLink = imageLink;
    }

    public Profile(String name, int age, String city, String sex) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
