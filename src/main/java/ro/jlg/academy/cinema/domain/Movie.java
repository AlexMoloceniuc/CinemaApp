package ro.jlg.academy.cinema.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String name;
    private String genre;
    private int ticketPrice;
    private List<String> usersIds=new ArrayList<>();

    public Movie(final String id,final String name,final String genre, final int ticketPrice){
        this.id=id;
        this.genre=genre;
        this.name=name;
        this.ticketPrice=ticketPrice;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getTicketPrice() {
        return this.ticketPrice;
    }

    public void update(final String name, final String genre,final  int ticketPrice) {
this.name=name;
this.ticketPrice=ticketPrice;
this.genre=genre;
    }


    public boolean reserveTicket(final String userId, final User user) {
        boolean ticketWasPartiallySold=false;
        final LocalDateTime now=LocalDateTime.now();
        final int ageOver18=now.getYear()-user.getDateOfBirth().getYear();
        final boolean isOverEighteen=ageOver18>=18;
        final boolean enoughMoneyForTicket=this.getTicketPrice()<user.getMoney();
        if(isOverEighteen && enoughMoneyForTicket){
            ticketWasPartiallySold=true;
            this.usersIds.add(userId);
        }
        return ticketWasPartiallySold;
    }

    }

