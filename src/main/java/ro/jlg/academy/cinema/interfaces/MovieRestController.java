package ro.jlg.academy.cinema.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.academy.cinema.application.MovieService;
import ro.jlg.academy.cinema.domain.Movie;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateMovieDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderTicketDTO;

import java.util.List;

@RestController
public class MovieRestController {
    private MovieService movieService;

    public MovieRestController(final MovieService movieService){
        this.movieService=movieService;
    }
    @PostMapping("/movies")
    public ResponseEntity<Void> create(final @RequestBody CreateUpdateMovieDTO dto){
        System.out.println(dto.getName());
        System.out.println(dto.getTicketPrice());
        System.out.println(dto.getGenre());
        this.movieService.create(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }
    @PatchMapping("/movies/{movieId}")
    public ResponseEntity<Void> update(final @PathVariable String movieId,final @RequestBody CreateUpdateMovieDTO dto){
        this.movieService.update(movieId,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> delete(final @PathVariable String movieId){
        this.movieService.delete(movieId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/movies/partialReservation")
    public ResponseEntity<Boolean> reserve(final @RequestBody OrderTicketDTO dto){
        return ResponseEntity.ok(this.movieService.ReserveTicket(dto));
    }


}
