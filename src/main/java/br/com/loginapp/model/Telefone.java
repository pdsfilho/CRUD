package br.com.loginapp.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TELEFONE")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Telefone.findByCdUsuario", query = "SELECT t FROM TELEFONE t WHERE t.CD_USUARIO = :CD_USUARIO"),
    @NamedQuery(name = "Usuario.findByNumero", query = "SELECT t FROM TELEFONE t WHERE t.DS_NUMERO = :DS_NUMERO")})
public class Telefone {
	@Id
	@Column(name="CD_TELEFONE", unique = true)
	private int cdTelefone;
	
	@OneToOne
	@JoinColumn (name="CD_USUARIO")
	private Usuario usuario;
	
	@Column(name="NR_DDD")
	private int nrDdd;
	
	@Column(name="DS_NUMERO")
	private String dsNumero;
	
	@Column(name="DS_TIPO")
	private String dsTipo;

	public int getCdTelefone() {
		return cdTelefone;
	}

	public void setCdTelefone(int cdTelefone) {
		this.cdTelefone = cdTelefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getNrDdd() {
		return nrDdd;
	}

	public void setNrDdd(int nrDdd) {
		this.nrDdd = nrDdd;
	}

	public String getDsNumero() {
		return dsNumero;
	}

	public void setDsNumero(String dsNumero) {
		this.dsNumero = dsNumero;
	}

	public String getDsTipo() {
		return dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

}
