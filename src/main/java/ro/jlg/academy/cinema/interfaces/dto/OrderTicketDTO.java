package ro.jlg.academy.cinema.interfaces.dto;

public class OrderTicketDTO {
    private String movieId;
    private String userId;

    public String getUserId(){
        return this.userId;
    }
    public String getMovieId(){
        return this.movieId;
    }
}
