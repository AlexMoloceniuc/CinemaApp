package ro.jlg.academy.cinema.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.academy.cinema.application.RoomService;
import ro.jlg.academy.cinema.domain.Room;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateRoomDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderFinalTicketDTO;
import ro.jlg.academy.cinema.interfaces.dto.OrderTicketDTO;

import java.util.List;

@RestController
public class RoomRestController {
    private RoomService roomService;
    public RoomRestController(final RoomService roomService){
        this.roomService=roomService;
    }
    @PostMapping ("/rooms")
    public ResponseEntity<Void> create(final @RequestBody CreateUpdateRoomDTO dto){
        System.out.println(dto.getMovieId());
        System.out.println(dto.getStartTime());
        System.out.println(dto.getSeats());
        System.out.println(dto.getRows());
        System.out.println(dto.getColumns());
        this.roomService.create(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAll(){
        return ResponseEntity.ok(this.roomService.getAll());
    }
    @PatchMapping("/rooms/{roomId}")
    public ResponseEntity<Void> update(final @PathVariable String roomId, final @RequestBody CreateUpdateRoomDTO dto){
        this.roomService.update(roomId,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<Void> delete(final @PathVariable String roomId){
        this.roomService.delete(roomId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/rooms/finalReservations")
    public ResponseEntity<Boolean> reserve(final @RequestBody OrderFinalTicketDTO dto){
        return ResponseEntity.ok(this.roomService.reserveFinalTicket(dto));
    }
}
