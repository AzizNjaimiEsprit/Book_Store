package Services;

import java.util.List;

public interface IServicesCategory<T> {
	public void ajouter(T t);
	public void modifier(T t);
	public void supprimer(T t);
	public T getCategoryByName(T t);
	public List <T> afficher ();
}
