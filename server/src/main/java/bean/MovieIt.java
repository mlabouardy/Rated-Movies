package bean;

import java.util.List;

import javax.ejb.Local;

import entity.Movie;

@Local
public interface MovieIt {

	public Movie findById(int id);
	
	public void update(int id);
	
	public List<Movie> getMovies();
}
