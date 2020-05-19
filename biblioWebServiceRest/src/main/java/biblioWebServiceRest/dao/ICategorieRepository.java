package biblioWebServiceRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biblioWebServiceRest.entities.Categorie;


@Repository
public interface ICategorieRepository extends JpaRepository<Categorie, Long>, JpaSpecificationExecutor<Categorie> {

	@Query("select c from Categorie c where c.nomCategorie like %?1")
	Categorie findByNomCategorie(String nomCategorie);
	
}
