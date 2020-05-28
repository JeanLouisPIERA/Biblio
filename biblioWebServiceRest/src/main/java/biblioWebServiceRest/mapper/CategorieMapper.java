/**
 * 
 */
package biblioWebServiceRest.mapper;

import org.mapstruct.Mapper;

import biblioWebServiceRest.dto.CategorieDTO;
import biblioWebServiceRest.entities.Categorie;

/**
 * @author jeanl
 *
 */

@Mapper(componentModel="spring")
public interface CategorieMapper {
	
	
	CategorieDTO categorieToCategorieDTO(Categorie entity);
	Categorie categorieDTOToCategorie(CategorieDTO dto);

}