package bean;

import java.util.List;

import javax.ejb.Local;

import entity.Category;
import entity.Movie;

@Local
public interface CategoryIt {

	public Category findById(int id);
	
	public List<Category> getCategories();
	
	public List<Movie> findMovieByCategory(int id);
}
