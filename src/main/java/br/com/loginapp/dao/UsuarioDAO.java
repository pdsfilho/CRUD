package br.com.loginapp.dao;
import javax.persistence.NoResultException;

import br.com.loginapp.model.Usuario;

public class UsuarioDAO extends GenericoDAO<Usuario> {
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario findByNome(String dsNome) {
		Usuario usuario;
		
		try {
			usuario= createNamedQuery("Usuario.findByNome").setParameter("DS_NOME", dsNome).getSingleResult();
			
			return usuario;
		}
		catch(NoResultException e) {
			return null;
		}
	}
	public Usuario findByEmail(String dsEmail) {
		Usuario usuario;
		
		try {
			usuario= createNamedQuery("Usuario.findByEmail").setParameter("DS_EMAIL", dsEmail).getSingleResult();
			
			return usuario;
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
}
