package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Category;
import entity.Movie;

@Stateless
public class CategoryBean implements CategoryIt{
	
	@PersistenceContext(unitName="movie-unit")
	private EntityManager em;

	@Override
	public Category findById(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> getCategories() {
		Query query=em.createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}

	@Override
	public List<Movie> findMovieByCategory(int id) {
		Category category=findById(id);
		return category.getMovies();
	}

}
