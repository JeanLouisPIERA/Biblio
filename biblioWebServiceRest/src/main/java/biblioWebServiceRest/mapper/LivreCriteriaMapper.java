/**
 * Interface pour la gestion du mapping MapStruct entre le critère de recherche Livre et son DTO
 */
 
package biblioWebServiceRest.mapper;

import org.mapstruct.Mapper;


import biblioWebServiceRest.criteria.LivreCriteria;
import biblioWebServiceRest.dto.CategorieDTO;
import biblioWebServiceRest.dto.LivreCriteriaDTO;
import biblioWebServiceRest.entities.Categorie;

/**
 * @author jeanl
 *
 */
@Mapper(componentModel="spring")
public interface LivreCriteriaMapper {
	
	
	LivreCriteriaDTO livreCriteriaToLivreCriteriaDTO(LivreCriteria entity);
	LivreCriteria livreCriteriaDTOToLivreCriteria(LivreCriteriaDTO dto);
	
	CategorieDTO categorieToCategorieDTO(Categorie entity);
	Categorie categorieDTOToCategorie(CategorieDTO dto);
}