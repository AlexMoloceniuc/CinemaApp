package ro.jlg.academy.cinema.domain;

import java.time.LocalDateTime;

public class User {
    private String id;
    private String name;
    private int money;
    private LocalDateTime dateOfBirth;

    public User(final String id,final String name,final int money, final LocalDateTime dateOfBirth){
        this.id=id;
        this.dateOfBirth=dateOfBirth;
        this.money=money;
        this.name=name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public LocalDateTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void update(final String name, final LocalDateTime dateOfBirth, final int money) {
    this.name=name;
    this.dateOfBirth=dateOfBirth;
    this.money=money;
    }
}
