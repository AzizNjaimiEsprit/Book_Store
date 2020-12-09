package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.*;
import Utils.DataSource;
import Utils.Global;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicesWishList implements IServiceWishList <WishList> {
	Connection cnx = DataSource.getInstance().getCnx();
	CrudBook cb = new CrudBook();

	public void ajouter(WishList wl) {
		try {
			String req = "INSERT INTO WISHLIST VALUES (? , ?)";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1,wl.getUser().getId());
			st.setInt(2,wl.getBook().getId());
			st.executeUpdate();
			System.out.println("WishList ajouté!");
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
		
	}

	}
	
	public void supprimer(WishList wl) {
		try {
			
			String req = "DELETE FROM WISHLIST WHERE user_id=? AND book_id=? ";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1, wl.getUser().getId());
			st.setInt(2, wl.getBook().getId());
			st.executeUpdate();
			System.out.println("WishList supprimé!");
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
		
	}
	}
		
	
		/*public List<WishList> afficher() {
			List<WishList> List = new ArrayList<>();
			try {
				
				String req = "SELECT * FROM WISHLIST ";
				PreparedStatement st = cnx.prepareStatement(req);
				ResultSet res = st.executeQuery();
				while(res.next()) {
					List.add(new WishList(new User(res.getInt("user_id")), new Book(res.getInt("book_id"))));
					
				}
				System.out.println("WishList réccupérée!");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
			return List;
		
		
	}*/
		public ObservableList<WishList> getWishListOfUser(int userId){
			ObservableList<WishList> res= FXCollections.observableArrayList();
			try{

				String req = "Select * FROM WISHLIST WHERE user_id=? ";
				PreparedStatement st = cnx.prepareStatement(req);
				st.setInt(1, userId);
				ResultSet rs = st.executeQuery();
				while (rs.next()){
					int bookid = rs.getInt("book_id");
					Book book = cb.RecupererLivreByID(bookid);
					User user= Global.getCurrentUser();
					res.add(new WishList(user,book));
				}
				rs.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			return res;

		}

	public Book getDetailsBook(int id){
		Book book=new Book();
		try{

			String req = "Select title,author,status, nb_page  FROM BOOK WHERE id=? ";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				String title = rs.getString("title");
				String status = rs.getString("status");
				String author = rs.getString("author");
				int nombre_pages = rs.getInt("nb_page");
				 book.setTitle(title);
				 book.setAuthor(author);
				 book.setStatus(status);
				 book.setNombre_pages(nombre_pages);

			}
			rs.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return book;

	}

}
