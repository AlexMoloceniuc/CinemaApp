package ro.jlg.academy.cinema.application;

import org.springframework.stereotype.Service;
import ro.jlg.academy.cinema.domain.Movie;
import ro.jlg.academy.cinema.infrastructure.MovieRepositoryImpl;
import ro.jlg.academy.cinema.infrastructure.UserRepositoryImpl;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateMovieDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderTicketDTO;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    private MovieRepositoryImpl movieRepository;
    private UserRepositoryImpl userRepository;

    public MovieService(final MovieRepositoryImpl movieRepository, final UserRepositoryImpl userRepository){
        this.movieRepository=movieRepository;
        this.userRepository=userRepository;
    }

    public void create(final CreateUpdateMovieDTO dto) {
        final Movie movie=new Movie(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getGenre(),dto.getTicketPrice()
        );
        this.movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    public void update(final String movieId, final CreateUpdateMovieDTO dto) {
    final Movie movie=this.movieRepository.findById(movieId);
    movie.update(dto.getName(),dto.getGenre(),dto.getTicketPrice());
    this.movieRepository.save(movie);
    }

    public void delete(final String movieId) {
        this.movieRepository.delete(movieId);
    }


    public boolean ReserveTicket(final OrderTicketDTO dto) {
        final Movie movie=this.movieRepository.findById(dto.getMovieId());
        final boolean ticketWasPartiallySold=movie.reserveTicket(dto.getUserId(), userRepository.findById(dto.getUserId()));
    this.movieRepository.save(movie);
    return ticketWasPartiallySold;
    }
}
