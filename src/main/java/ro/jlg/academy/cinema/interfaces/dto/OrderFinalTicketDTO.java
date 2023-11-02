package ro.jlg.academy.cinema.interfaces.dto;

public class OrderFinalTicketDTO {
    private String movieId;
    private String roomId;
    private String userId;

    public String getMovieId() {
        return this.movieId;
    }

    public String getRoomId() {
        return this.roomId;
    }
    public String getUserId(){
        return this.userId;
    }
}
