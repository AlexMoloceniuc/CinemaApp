package ro.jlg.academy.cinema.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.academy.cinema.application.UserService;
import ro.jlg.academy.cinema.domain.User;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateUserDTO;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;
    public UserRestController(final UserService userService){
        this.userService=userService;
    }
    @PostMapping("/users")
    public ResponseEntity<Void> create(final @RequestBody CreateUpdateUserDTO dto){
        System.out.println(dto.getName());
        System.out.println(dto.getDateOfBirth());
        System.out.println(dto.getMoney());
        this.userService.create(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }
    @PatchMapping("/users/{userId}")
    public ResponseEntity<Void> update(final @PathVariable String userId, final @RequestBody CreateUpdateUserDTO dto){
        this.userService.update(userId,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> delete(final @PathVariable String userId){
        this.userService.delete(userId);
        return ResponseEntity.ok().build();
    }

}
