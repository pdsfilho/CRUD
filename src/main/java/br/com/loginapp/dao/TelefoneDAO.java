package br.com.loginapp.dao;
import javax.persistence.NoResultException;
import br.com.loginapp.model.Telefone;
import br.com.loginapp.model.Usuario;

public class TelefoneDAO extends GenericoDAO<Telefone> {
	public TelefoneDAO() {
		super(Telefone.class);
	}
	
	public Telefone findByCdUsuario(int cdUsuario) {
		Telefone telefone;
		
		try {
			telefone= createNamedQuery("Usuario.findByCdUsuario").setParameter("CD_USUARIO", cdUsuario).getSingleResult();
			
			return telefone;
		}
		catch(NoResultException e) {
			return null;
		}
	}
	public Telefone findByNumero(String dsNumero) {
		Telefone telefone;
		
		try {
			telefone= createNamedQuery("Usuario.findByNumero").setParameter("DS_NUMERO", dsNumero).getSingleResult();
			
			return telefone;
		}
		catch(NoResultException e) {
			return null;
		}
	}
}
