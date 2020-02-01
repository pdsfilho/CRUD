package br.com.loginapp.LoginApp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.com.loginapp.dao.UsuarioDAO;
import br.com.loginapp.model.Usuario;


/**
 * Hello world!
 *
 */
public class App 
{
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("LoginApp");
    public static void main( String[] args )
    {
    
    	
    }
}
