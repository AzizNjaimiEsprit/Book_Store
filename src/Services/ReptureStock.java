package Services;

import Beans.Book;
import Beans.User;
import api.JavaSendEmail;

public class ReptureStock {
    public void VerificationStock (Book b , User u ){
        CrudBook cb = new CrudBook();
        if (cb.RecupererQuantitéLivre(b)<=0){
            JavaSendEmail.SendMail(u.getEmail(),b , u);
        }else
            System.out.println("le stoc est superieur a 0");

    }
}
