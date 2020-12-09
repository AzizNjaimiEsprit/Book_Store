package Services;

import java.util.List;

public interface IServiceBasket<T> {
	public void ajouter(T t);
	public void modifier(T t);
	public void supprimer(T t);
}
