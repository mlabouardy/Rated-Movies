package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Movie;

@Stateless
public class MovieBean implements MovieIt{

	@PersistenceContext(unitName="movie-unit")
	private EntityManager em;
	
	@Override
	public Movie findById(int id) {
		return em.find(Movie.class, id);
	}

	@Override
	public void update(int id) {
		Movie movie=findById(id);
		em.merge(movie);
	}

	@Override
	public List<Movie> getMovies() {
		Query query=em.createQuery("SELECT m FROM Movie m");
		return query.getResultList();
	}

}
