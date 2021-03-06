/**
 * Classe de sérialization JPA des roles pour le Mapping ORM avec une extension Specification de l'API Criteria
 */
package biblioWebServiceRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioWebServiceRest.entities.Role;
import biblioWebServiceRest.entities.RoleEnum;

public interface IRoleRepository extends JpaRepository <Role, Long>{
	
	Role findByName(RoleEnum name);
	
}
