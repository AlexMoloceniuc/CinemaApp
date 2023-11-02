package ro.jlg.academy.cinema.infrastructure;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.academy.cinema.domain.Movie;

import java.util.List;
import java.util.Queue;

@Repository
public class MovieRepositoryImpl {
    private MongoTemplate mongoTemplate;
    public MovieRepositoryImpl(final MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }
    public void save(final Movie movie){
        this.mongoTemplate.save(movie);
    }

    public List<Movie> findAll() {
        return this.mongoTemplate.findAll(Movie.class);
    }

    public Movie findById(final String movieId) {
    return this.mongoTemplate.findById(movieId, Movie.class);
    }

    public void delete(final String movieId) {
        final Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(movieId));
        this.mongoTemplate.remove(query, Movie.class);
    }
}
