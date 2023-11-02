package ro.jlg.academy.cinema.application;

import org.springframework.stereotype.Service;
import ro.jlg.academy.cinema.domain.Movie;
import ro.jlg.academy.cinema.domain.Room;
import ro.jlg.academy.cinema.infrastructure.MovieRepositoryImpl;
import ro.jlg.academy.cinema.infrastructure.RoomRepositoryImpl;
import ro.jlg.academy.cinema.infrastructure.UserRepositoryImpl;
import ro.jlg.academy.cinema.interfaces.UserRestController;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateRoomDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderFinalTicketDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderTicketDTO;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {
    private RoomRepositoryImpl roomRepository;
    private MovieRepositoryImpl movieRepository;
    private UserRepositoryImpl userRepository;
    public RoomService(final RoomRepositoryImpl roomRepository, final MovieRepositoryImpl movieRepository,final UserRepositoryImpl userRepository){
        this.roomRepository=roomRepository;
        this.movieRepository=movieRepository;
        this.userRepository=userRepository;
    }
    public void create(final CreateUpdateRoomDTO dto){
        final Room room=new Room(
                UUID.randomUUID().toString(),
                dto.getMovieId(),
                dto.getStartTime(),
                dto.getSeats(),
                dto.getRows(),
                dto.getColumns()

        );
        this.roomRepository.save(room);
    }

    public List<Room> getAll() {
        return this.roomRepository.findAll();
    }

    public void update(final String roomId, final CreateUpdateRoomDTO dto) {
    final Room room=this.roomRepository.findById(roomId);
    room.update(dto.getMovieId(),dto.getStartTime(),dto.getSeats(),dto.getRows(),dto.getColumns());
    this.roomRepository.save(room);
    }

    public void delete(final String roomId) {
        this.roomRepository.delete(roomId);
    }


    public boolean reserveFinalTicket(final OrderFinalTicketDTO dto) {
    final Room room=this.roomRepository.findById(dto.getRoomId());
    final boolean ticketWasFullyReserved=room.reserveTicket(dto.getMovieId(),movieRepository.findById(dto.getMovieId()),dto.getUserId(),userRepository.findById(dto.getUserId()));
   this.roomRepository.save(room);
   return ticketWasFullyReserved;
    }
}
