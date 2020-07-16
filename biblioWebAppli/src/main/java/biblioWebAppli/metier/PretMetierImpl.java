/**
 * 
 */
package biblioWebAppli.metier;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import biblioWebAppli.criteria.PretCriteria;
import biblioWebAppli.dto.LivreDTO;
import biblioWebAppli.dto.PretDTO;
import biblioWebAppli.exceptions.BookNotAvailableException;
import biblioWebAppli.exceptions.EntityNotFoundException;
import biblioWebAppli.objets.Livre;
import biblioWebAppli.objets.Pret;


/**
 * @author jeanl
 *
 */
@Service
public class PretMetierImpl implements IPretMetier{
	
	@Autowired
    private RestTemplate restTemplate;
    
    //public final String uRL = "http://localhost:8080/prets";
    @Value("${application.uRLPret}")
	private String uRL;

	/**
	 * @param pretDTO
	 * @return
	 * @throws EntityNotFoundException
	 * @throws BookNotAvailableException
	 */
	@Override
	public Pret createPret(PretDTO pretDTO) {
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);

    	HttpEntity<PretDTO> requestEntity = new HttpEntity<>(pretDTO, headers);
    	ResponseEntity<Pret> response = restTemplate.exchange(uRL, HttpMethod.POST, requestEntity, Pret.class);
			System.out.println(response.getStatusCodeValue());
			
    	return response.getBody();
	}

	/**
	 * @param numPret
	 * @return
	 * @throws EntityNotFoundException
	 * @throws BookNotAvailableException
	 */
	@Override
	public Pret prolongerPret(Long numPret){
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	
    	HttpEntity<?> requestEntity = 
       	     new HttpEntity<>(headers);
		
		String url = uRL+"/prolongation/"+numPret;
    	
		ResponseEntity<Pret> response = restTemplate.exchange(url , HttpMethod.PUT, requestEntity, Pret.class);
		
		System.out.println("response:"+ response.toString()); 
		
		return response.getBody(); 
	}

	/**
	 * @param numPret
	 * @return
	 * @throws EntityNotFoundException
	 */
	@Override
	public Pret cloturerPret(Long numPret){
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	
    	HttpEntity<?> requestEntity = 
       	     new HttpEntity<>(headers);
		
		String url = uRL+"/cloture/"+numPret;
    	
		ResponseEntity<Pret> response = restTemplate.exchange(url , HttpMethod.PUT, requestEntity, Pret.class);
		
		System.out.println("response:"+ response.toString()); 
		
		return response.getBody(); 
	}

	/**
	 * @param pretCriteria
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Pret> searchByCriteria(PretCriteria pretCriteria, Pageable pageable) {
		HttpHeaders headers = new HttpHeaders();
    	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uRL)
    	        .queryParam("numPret", pretCriteria.getNumPret())
    	        .queryParam("username", pretCriteria.getUsername())
    	        .queryParam("userId", pretCriteria.getUserId())
    	        .queryParam("numLivre", pretCriteria.getNumLivre())
    	        .queryParam("titre", pretCriteria.getTitre())
    	        .queryParam("auteur", pretCriteria.getAuteur())
    	        .queryParam("nomCategorieLivre", pretCriteria.getNomCategorieLivre())
    	        .queryParam("page", pageable.getPageNumber())
    	        .queryParam("size", pageable.getPageSize());
    	
    	System.out.println("uri:"+ builder.toUriString());
    	
    	HttpEntity<?> entity = new HttpEntity<>(headers);
    	
    	ResponseEntity<RestResponsePage<Pret>> prets = restTemplate.exchange
    			(builder.toUriString(), 
				HttpMethod.GET,
				entity,
    			new ParameterizedTypeReference<RestResponsePage<Pret>>(){});
        Page<Pret> pagePret = prets.getBody();
        
            	
        return pagePret;
	}
	
	

}
