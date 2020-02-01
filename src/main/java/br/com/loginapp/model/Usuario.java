package br.com.loginapp.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USUARIO")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.DS_NOME = :DS_NOME"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.DS_EMAIL = :DS_EMAIL")})
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CD_USUARIO", unique = true)
	private int cdUsuario;
	
	@Column (name="DS_EMAIL", nullable=false)
	private String dsEmail;
	
	@Column(name="DS_NOME", nullable = false)
	private String dsNome;
	
	@Column(name="DS_SENHA", nullable = false)
	private String dsSenha;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Telefone.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Telefone> telefoneLista;

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	
}