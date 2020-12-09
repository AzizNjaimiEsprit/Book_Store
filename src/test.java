import Beans.Book;
import Beans.Category;
import Beans.OnlineBook;
import Beans.User;
import Services.CrudBook;
import Services.ReptureStock;

import java.util.Date;

public class test {
    public static void main(String[] args)  {
     /*    CrudAuthor ca = new CrudAuthor();
        CrudBook cb = new CrudBook();
        CrudCategory cc = new CrudCategory();
        CrudAuthorBook cab = new CrudAuthorBook();
        CrudOnlineBook co = new CrudOnlineBook();

        //***********************

        //**********************************
       cc.AjouterCategorie(c1);
        cc.AjouterCategorie(c2);
        System.out.println("les category sont ajouter ");
        cb.AjouterLivre(b1);
        cb.AjouterLivre(b2);
        System.out.println("les livres sont ajouter ");
        ca.AjouterAuthor(a1);
        ca.AjouterAuthor(a2);
        ca.AjouterAuthor(a3);
        System.out.println("les auteur sont ajouter ");
        cb.AjouterLivre(b1);
        //cab.AjouuterAuteurALivre(a1,b1);
        // System.out.println(cb.RecupererLivre(b1).toString());
       CrudComment ccc = new CrudComment();
       Comment r = new Comment(2,"666",b1,u);
       ccc.SupprimerComment(r);
*/

     // System.out.println(co.RecupererLivreEnLigneByid(4));
       // cb.AjouterLivre(b3);
        Category c1 = new Category(5,"ma category 1");
        Category c2 = new Category(2,"ma category 2");
        Date d = new Date();
        java.sql.Date dd = new java.sql.Date (d.getTime()) ;
        Book b2 = new Book(56,"livre 2",1.1 ,"bbb","bbbbbb",dd,0,"bbbbb",c2,"bbbbb",1,"cddddd");
        Book b3 = new Book(3,"livre 2",1.1 ,"bbb","bbbbbb",dd,11,"bbbbb",c2,"bbbbb",1,"sssss");

        User u = new User(1,"Aziz Njaimi ","mohamedaziz.njaimi@esprit.tn");
        OnlineBook o = new OnlineBook(4,"livre 2",1.1 ,"bbb","bbbbbb",dd
                ,0,"bbbbb",c2,"bbbbb",1,"eeeeee","sssssss");

        CrudBook cb = new CrudBook();
        ReptureStock.VerificationStock(b2);


    }
    }


