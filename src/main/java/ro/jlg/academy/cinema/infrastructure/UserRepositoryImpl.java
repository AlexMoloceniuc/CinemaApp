package ro.jlg.academy.cinema.infrastructure;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.academy.cinema.domain.User;

import java.util.List;

@Repository
public class UserRepositoryImpl {
    private MongoTemplate mongoTemplate;
    private UserRepositoryImpl userRepository;

    public UserRepositoryImpl(final MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;

    }

    public void save(final User user) {
        this.mongoTemplate.save(user);
    }

    public List<User> findAll() {
        return this.mongoTemplate.findAll(User.class);
    }

    public User findById(final String userId) {
        return this.mongoTemplate.findById(userId,User.class);
    }

    public void delete(final String userId) {
       final Query query=new Query();
       query.addCriteria(Criteria.where("_id").is(userId));
       this.mongoTemplate.remove(query, User.class);
    }
}
