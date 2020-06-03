package biblioWebServiceRest.metier;

import java.util.List;

import biblioWebServiceRest.criteria.LivreCriteria;
import biblioWebServiceRest.entities.Livre;


public interface ILivreMetier {
	
	/**
	 * Recherche multicritères des livres enregistrés
	 * @param livreCriteria
	 * @return
	 */
	List<Livre> searchByCriteria(LivreCriteria livreCriteria);
	
	/**
	 * Creation d'un nouveau livre à referencer 
	 * La creation d'une référence se fait sur la base d'un seul exemplaire
	 * L'enregistrement de plusieurs exemplaires présent à la création se fait par simple mise à jour en suivant
	 * @param titre
	 * @param auteur
	 * @param numCategorie
	 * @return
	 * @throws Exception
	 */
	Livre createLivre(String titre, String auteur, Long numCategorie) throws Exception;
	
	/**
	 * Enregistrement d'un ou plusieurs nouveaux exemplaires pour une reference de livre déjà enregistree
	 * @param numLivre
	 * @param nombreNouveauxExemplaires
	 * @return
	 */
	Livre createExemplaire(Long numLivre, Integer nombreNouveauxExemplaires);
	
	/**
	 * Suppression d'un ou plusieurs exemplaires pour une reference de livre déjà enregistrée
	 * @param numLivre
	 * @param nombreExemplairesASupprimer
	 * @return
	 */
	Livre deleteExemplaire(Long numLivre, Integer nombreExemplairesASupprimer);
	
	/**
	 * Cette méthode permet de changer un livre de categorie en cas de modification de l'organisation des categories de livres
	 * Par exemple suppression d'une categorie ou nouvelle categorie plus adaptee
	 * @param numLivre
	 * @param nomCategorie
	 * @return
	 */
	Livre changeCategorie(Long numLivre, String nomCategorie);
	
	/**
	 * Suppression d'une reference de livre 
	 * @param numLivre
	 */
	void deleteLivre(Long numLivre); 
	
}