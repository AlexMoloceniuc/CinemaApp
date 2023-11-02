package ro.jlg.academy.cinema.interfaces.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CreateUpdateRoomDTO {
    private String movieId;
    private LocalDateTime startTime;
    private List<List<String>> seats;
    private int rows;
    private int columns;

    public CreateUpdateRoomDTO(final String movieId,final LocalDateTime startTime,final List<List<String>> seats, final int rows,final int columns){

        this.movieId=movieId;
        this.startTime=startTime;
        this.seats=seats;
        this.rows=rows;
        this.columns=columns;

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
}
