package ro.jlg.academy.cinema.infrastructure;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.academy.cinema.domain.Room;

import java.util.List;

@Repository
public class RoomRepositoryImpl {
    private MongoTemplate mongoTemplate;
    public RoomRepositoryImpl(final MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }
    public void save(Room room){
        this.mongoTemplate.save(room);
    }

    public List<Room> findAll() {
        return this.mongoTemplate.findAll(Room.class);
    }

    public Room findById(final String roomId) {
        return this.mongoTemplate.findById(roomId, Room.class);
    }

    public void delete(final String roomId) {
        final Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(roomId));
        this.mongoTemplate.remove(query, Room.class);
    }
}
