/**
 * Classe de sérialization des utilisateurs pour le Mapping DTO 
 */
package biblioWebServiceRest.dto;



/**
 * @author jeanl
 *
 */
public class UserDTO {
	
	private Long idUser;
	private String username;
	private String adresseMail;
	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the adresseMail
	 */
	public String getAdresseMail() {
		return adresseMail;
	}
	/**
	 * @param adresseMail the adresseMail to set
	 */
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

	
	
	
	
	

}
