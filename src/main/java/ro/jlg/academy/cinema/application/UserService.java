package ro.jlg.academy.cinema.application;

import org.springframework.stereotype.Service;
import ro.jlg.academy.cinema.domain.User;
import ro.jlg.academy.cinema.infrastructure.UserRepositoryImpl;
import ro.jlg.academy.cinema.interfaces.dto.CreateUpdateUserDTO;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepositoryImpl userRepository;
    public UserService(final UserRepositoryImpl userRepository){
        this.userRepository=userRepository;

    }
    public void create(final CreateUpdateUserDTO dto){
        final User user=new User(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getMoney(),
                dto.getDateOfBirth()
        );
        this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public void update(final String userId, final CreateUpdateUserDTO dto) {
    final User user=this.userRepository.findById(userId);
    user.update(dto.getName(),dto.getDateOfBirth(),dto.getMoney());
    this.userRepository.save(user);

    }

    public void delete(final String userId) {
        this.userRepository.delete(userId);
    }
}
