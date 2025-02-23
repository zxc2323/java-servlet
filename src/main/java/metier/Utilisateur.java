package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Utilisateur")
public class Utilisateur {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="IdUtil")
		private int idUtil; 
		
		@Column(name="prenomUtil")
		private String prenomUtil;
		
		@Column(name="nomUtil")
		private String nomUtil;
		
		@Column(name="adresseUtil")
		private String adresseUtil;
		
		@Column(name="mailUtil", nullable = false, unique = true)
		private String mailUtil;
		
		@Column(name="motDePasseUtil", nullable = false)
		private String motDePasseUtil; 
		
		@Column(name="rôleUtil", nullable = false)
		private Role role;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="CodeMag")
		private Magasin magasinTravail;
		
		@OneToMany(mappedBy="utilisateur")
		private Set<Commande> commandes = new HashSet<>();
		
		@OneToMany(mappedBy="preparateur")
		private Set<Commande> commandesPrepare = new HashSet<>();
		
		@OneToMany(mappedBy="utilisateur")
		private Set<ListeCourse> liste_courses = new HashSet<>();
		
		public Utilisateur() {}
		
		public Utilisateur(String prenom, String nom, String adresse, String mail, String mdp) {
			this.prenomUtil = prenom; 
			this.nomUtil = nom; 
			this.adresseUtil = adresse; 
			this.mailUtil = mail; 
			this.motDePasseUtil = mdp;
		}
		
		// Getter et Setter pour idUtil
		public int getIdUtil() {
		    return idUtil;
		}

		public void setIdUtil(int idUtil) {
		    this.idUtil = idUtil;
		}

		// Getter et Setter pour prenomUtil
		public String getPrenomUtil() {
		    return prenomUtil;
		}

		public void setPrenomUtil(String prenomUtil) {
		    this.prenomUtil = prenomUtil;
		}

		// Getter et Setter pour nomUtil
		public String getNomUtil() {
		    return nomUtil;
		}

		public void setNomUtil(String nomUtil) {
		    this.nomUtil = nomUtil;
		}

		// Getter et Setter pour adresseUtil
		public String getAdresseUtil() {
		    return adresseUtil;
		}

		public void setAdresseUtil(String adresseUtil) {
		    this.adresseUtil = adresseUtil;
		}

		// Getter et Setter pour mailUtil
		public String getMailUtil() {
		    return mailUtil;
		}

		public void setMailUtil(String mailUtil) {
		    this.mailUtil = mailUtil;
		}

		// Getter et Setter pour motDePasseUtil
		public String getMotDePasseUtil() {
		    return motDePasseUtil;
		}

		public void setMotDePasseUtil(String motDePasseUtil) {
		    this.motDePasseUtil = motDePasseUtil;
		}
		
		public Role getRole() {
			return this.role;
		}
		
		public void setRole(Role role) {
			this.role = role;
		}

		// Getter et Setter pour commandes
		public Set<Commande> getCommandes() {
		    return commandes;
		}

		public void setCommandes(Set<Commande> commandes) {
		    this.commandes = commandes;
		}

		// Méthode pour ajouter une commande
		public void addCommande(Commande commande) {
		    this.commandes.add(commande);
		    commande.setUtilisateur(this);
		}

		// Méthode pour supprimer une commande
		public void removeCommande(Commande commande) {
		    this.commandes.remove(commande);
		    commande.setUtilisateur(null);
		}
		
		// Getter et Setter pour commandes
				public Set<Commande> getCommandesPrepare() {
				    return this.commandesPrepare;
				}

				public void setCommandesPrepare(Set<Commande> commandes) {
				    this.commandesPrepare = commandes;
				}

				// Méthode pour ajouter une commande
				public void addCommandePrepare(Commande commande) {
				    this.commandesPrepare.add(commande);
				    commande.setUtilisateur(this);
				}

				// Méthode pour supprimer une commande
				public void removeCommandePrepare(Commande commande) {
				    this.commandesPrepare.remove(commande);
				    commande.setUtilisateur(null);
				}
		
		public Magasin getMagasinTravail() {
			return this.magasinTravail;
		}
		
		public void setMagasinTravail(Magasin mag) {
			this.magasinTravail = mag;
		}

		// Getter et Setter pour liste_courses
		public Set<ListeCourse> getListeCourses() {
		    return liste_courses;
		}

		public void setListeCourses(Set<ListeCourse> liste_courses) {
		    this.liste_courses = liste_courses;
		}

		// Méthode pour ajouter une liste de courses
		public void addListeCourse(ListeCourse listeCourse) {
		    this.liste_courses.add(listeCourse);
		    listeCourse.setUtilisateur(this);
		}

		// Méthode pour supprimer une liste de courses
		public void removeListeCourse(ListeCourse listeCourse) {
		    this.liste_courses.remove(listeCourse);
		    listeCourse.setUtilisateur(null);
		}

		// Méthode toString pour afficher les informations de l'utilisateur
		@Override
		public String toString() {
		    return "Utilisateur{" +
		            "id=" + idUtil +
		            ", prenom='" + prenomUtil + '\'' +
		            ", nom='" + nomUtil + '\'' +
		            ", adresse='" + adresseUtil + '\'' +
		            ", mail='" + mailUtil + '\'' +
		            ", nombre de commandes=" + (commandes != null ? commandes.size() : 0) +
		            ", nombre de listes de courses=" + (liste_courses != null ? liste_courses.size() : 0) +
		            '}';
		}
		
}
