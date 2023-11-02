package ro.jlg.academy.cinema.domain;

import ro.jlg.academy.cinema.interfaces.dto.OrderTicketDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String id;
    private String movieId;
    private LocalDateTime startTime;
    private List<List<String>> seats;
    private int rows;
    private int columns;
    private List<String> movieIds=new ArrayList<>();

    public Room(final String id, final String movieId, final LocalDateTime startTime, final List<List<String>> seats, final int rows, final int columns) {
        this.id = id;
        this.movieId = movieId;
        this.startTime = startTime;
        this.seats = seats;
        this.rows = rows;
        this.columns = columns;

    }

    public String getId() {
        return this.id;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public List<List<String>> getSeats() {
        return this.seats;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void update(final String movieId, final LocalDateTime startTime, final List<List<String>> seats, final int rows, final int columns) {
        this.movieId = movieId;
        this.startTime = startTime;
        this.seats = seats;
        this.rows = rows;
        this.columns = columns;
    }


    public boolean reserveTicket(final String movieId, final Movie movie, final String userId, final User user) {
   boolean ticketWasFullyReserved=false;
   final LocalDateTime now=LocalDateTime.now();
        final int ageOver18=now.getYear()-user.getDateOfBirth().getYear();
        final boolean isOverEighteen=ageOver18>=18;
        final boolean enoughMoneyForTicket=movie.getTicketPrice()<user.getMoney();
   final boolean movieDidNotStartYet=this.startTime.getDayOfMonth()>now.getDayOfMonth();
    if(movieDidNotStartYet && movie.getGenre()!="horror" && enoughMoneyForTicket){
        ticketWasFullyReserved=true;
        this.movieIds.add(movieId);
    }else if(movieDidNotStartYet && enoughMoneyForTicket && movie.getGenre()=="horror" && isOverEighteen){
        ticketWasFullyReserved=true;
    }else{
        ticketWasFullyReserved=false;
    }
    return ticketWasFullyReserved;
    }

}
