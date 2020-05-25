package biblioWebServiceRest.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categorie")
public class Categorie implements Serializable{
	@Id
	@GeneratedValue
	private Long numCategorie;
	private String nomCategorie;
	@JsonIgnore
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection<Livre> livres;
	
	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	public Categorie(Long numCategorie, String nomCategorie, Collection<Livre> livres) {
		super();
		this.numCategorie = numCategorie;
		this.nomCategorie = nomCategorie;
		this.livres = livres;
	}

	public Long getNumCategorie() {
		return numCategorie;
	}

	public void setNumCategorie(Long numCategorie) {
		this.numCategorie = numCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	@JsonIgnore
	public Collection<Livre> getLivres() {
		return livres;
	}
	@JsonIgnore
	public void setLivres(Collection<Livre> livres) {
		this.livres = livres;
	}
	
	
	
}
