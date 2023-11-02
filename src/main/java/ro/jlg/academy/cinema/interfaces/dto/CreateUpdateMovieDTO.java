package ro.jlg.academy.cinema.interfaces.dto;

public class CreateUpdateMovieDTO {
        private String name;
        private String genre;
        private int ticketPrice;


        public String getName() {
            return this.name;
        }

        public String getGenre() {
            return this.genre;
        }

        public int getTicketPrice() {
            return this.ticketPrice;
        }
    }

