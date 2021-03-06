/**
 * Classe d'instanciation du jeu de données au lancement de l'application
 */
package biblioWebServiceRest.dao;


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import biblioWebServiceRest.entities.Categorie;
import biblioWebServiceRest.entities.Livre;
import biblioWebServiceRest.entities.Pret;
import biblioWebServiceRest.entities.PretStatut;
import biblioWebServiceRest.entities.Role;
import biblioWebServiceRest.entities.RoleEnum;
import biblioWebServiceRest.entities.User;
import biblioWebServiceRest.metier.IUserMetier;


/*
 * Cette classe permet de créer et de persister un jeu de données démo au lancement de l'application
 */

public class LanceurDB {
/**
@Component
public class LanceurDB implements CommandLineRunner {

	@Autowired
	private ILivreRepository livreRepository;
	@Autowired
	private IPretRepository pretRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private ICategorieRepository categorieRepository;
	@Autowired
	private IUserMetier userMetier;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public LanceurDB(ILivreRepository livreRepository, IPretRepository pretRepository, IUserRepository userRepository,
			IRoleRepository roleRepository, ICategorieRepository categorieRepository) {
		super();
		this.livreRepository = livreRepository;
		this.pretRepository = pretRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.categorieRepository = categorieRepository;
	}
	
	
	//Cette méthode permet de créer un jeu de données Utilisateur dans le Main au moment du lancement de l'appli 
	
	public User createUser(String username, String password) {
		User user = new User(username);
		Role role = roleRepository.findByName(RoleEnum.USER);
		user.setAdresseMail(username.concat("@hotmail.com"));
		user.setRole(role);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(user);
		return user;
	}

	
	//Cette méthode permet de créer un administrateur dans le Main au moment du lancement de l'appli
	
	public User createAdmin(String username, String password) {
		User user = new User(username);
		Role r = roleRepository.findByName(RoleEnum.ADMIN);
		user.setAdresseMail(username.concat("@hotmail.com"));
		user.setRole(r);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		userRepository.save(user);
		
		
		return user;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Role admin = new Role(RoleEnum.ADMIN);
		Role user = new Role(RoleEnum.USER);
		roleRepository.save(admin);
		roleRepository.save(user);
		
		User user1 = this.createUser("Jean-Charles", "jeancharles");
		User user2 = this.createUser("Charlemagne", "charlemagne");
		User user3 = this.createUser("Alexandre", "alexandre");
		User admin10 = this.createAdmin("Admin10", "admin10"); 
		User user4  = this.createUser("UserBatch", "userBatch"); 
				
				
		
		Categorie categorie1 = new Categorie("Roman");
		Categorie categorie2 = new Categorie("Essai scientifique");
		Categorie categorie3 = new Categorie("Manuel scolaire");
		Categorie categorie4 = new Categorie("Theatre");
    	Categorie categorie5 = new Categorie("Memoire");
    	Categorie categorie6 = new Categorie("Poesie");
    	Categorie categorie7 = new Categorie("Heroic Fantasy");
    	Categorie categorie8 = new Categorie("Bande Dessinee");
    	Categorie categorie9 = new Categorie("Policier");
		categorieRepository.save(categorie1);
		categorieRepository.save(categorie2);
		categorieRepository.save(categorie3);
    	categorieRepository.save(categorie4);
		categorieRepository.save(categorie5);
		categorieRepository.save(categorie6);
		categorieRepository.save(categorie7);
		categorieRepository.save(categorie8);
		categorieRepository.save(categorie9);
		
		
		Livre livre1 = new Livre("Le Pere Goriot", "Balzac", 1,1,categorie1);
		Livre livre2 = new Livre("Comment je vois le monde", "Einstein", 2,0, categorie2);
		Livre livre3 = new Livre("Mathematiques au college", "Collectif", 3,2, categorie3);
		Livre livre4 = new Livre("Physiologie des cloportes", "Boudard", 1, 1,categorie9);
		livreRepository.save(livre1);
		livreRepository.save(livre2);
		livreRepository.save(livre3);
		livreRepository.save(livre4);
		livreRepository.save(new Livre("La guerre de Troie n'aura pas lieu", "Jean Anouilh", 1, 1, categorie4));
        livreRepository.save(new Livre("Memoire d'un clown", "Achille Zavatta", 2, 0, categorie5));
        livreRepository.save(new Livre("La Legende des Siecles", "Victor Hugo", 3, 2, categorie6));
        livreRepository.save(new Livre("Le Seigneur de l'Anneau", "JRR Tolkien", 5, 5, categorie7));
        livreRepository.save(new Livre("Asterix Le Gaulois", "Uderzo et Goscinny", 10, 10,categorie8));
        livreRepository.save(new Livre("Metamorphose des cloportes", "Alphonse Boudard", 1, 1, categorie9));
        livreRepository.save(new Livre("San Antonio a de la memoire", "Frederic Dard", 3, 1,categorie9));
        livreRepository.save(new Livre("San Antonio fume les cloportes", "Frederic Dard", 1, 0,categorie9));
        livreRepository.save(new Livre("Le Gorille joue au clown", "Antoine Dominique", 2, 0,categorie9));
        livreRepository.save(new Livre("Tintin et le mystèrez de l'oreille cassée", "Herge", 6,0, categorie8));
        livreRepository.save(new Livre("Alcools", "Apollinaire", 1, 1,categorie6));
		
		pretRepository.save(new Pret(LocalDate.of(2020, Month.JULY, 5), LocalDate.of(2020, Month.AUGUST, 5), PretStatut.ECHU, user1, livre1));
		pretRepository.save(new Pret(LocalDate.of(2020, Month.JUNE, 29), LocalDate.of(2020, Month.AUGUST, 29), PretStatut.PROLONGE, user2, livre2));
		pretRepository.save(new Pret(LocalDate.of(2020,  Month.JULY, 29), LocalDate.of(2020,  Month.AUGUST, 29), PretStatut.ENCOURS, user3, livre3)); 
		pretRepository.save(new Pret(LocalDate.of(2020,  Month.MAY, 29), LocalDate.of(2020,  Month.JUNE, 29), PretStatut.CLOTURE, user3, livre4)); 
		pretRepository.save(new Pret(LocalDate.of(2020,  Month.JUNE, 29), LocalDate.of(2020,  Month.JULY, 29), PretStatut.ENCOURS, user2, livre3)); 
	
	

	}

**/

}
	
	
	

            
       
