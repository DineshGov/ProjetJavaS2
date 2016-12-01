
package mmorpg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Classe principale du projet de M2107  
 * de Dinesh Govindaradjane et Jeremy Dos Santos
 * du groupe C3.
 * Le code comprends des commentaires au sein des methodes afin d'ameliorer sa comprehension.
 * Les accents ne sont pas pris en compte dans la javadoc, c'est pourquoi beaucoup de fautes
 * d'orthographes sont presentes.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */

public class Combattant {

	/**
	 * Nom du combattant
	 */

	private String nom;

	private int force;
	private int dexterite;
	private int intelligence;
	private int concentration;

	private int experience;
	private int vitalite;

	/**
	 * Type du combattant, cet attribut aura comme valeur: "guerrier", "chasseur" ou" mage"
	 */
	private String typeCombattant;

	/**
	 * Tableau de Capacite regroupant toutes les capacites du combattant (Epee, Ecu...), 
	 * attribut servant a l'implementation implicite de la classe Capacite
	 */
	protected Capacite[] technique;

	/**
	 * <b>Constructeur par defaut</b>
	 */

	public Combattant() {
		this.nom = "Defaut";

		this.force = 0;
		this.dexterite = 0;
		this.intelligence = 0;
		this.concentration = 0;

		this.experience = 1;
		this.vitalite = 0;

		this.typeCombattant="Non defini";

		this.technique = new Capacite[10];
	}

	/**
	 * 
	 * @param nom
	 * nom du personnage
	 * @param force
	 * force du personnage
	 * @param dexterite
	 * dexterite du personnage
	 * @param intelligence
	 * intelligence du personnage
	 * @param concentration
	 * concentration du personnage
	 * @param experience
	 * experience du personnage
	 * @param vitalite
	 * vitalite du personnage
	 * @param typeCombattant
	 * attribut egal a: "guerrier", "chasseur", ou "mage"
	 * @param tailleTab
	 * taille du tableau de capacite du personnage, egal a 10 par defaut.
	 * 
	 * <p><b>Constructeur champ a champ ayant servi pour les tests.</b></p>
	 * 
	 */

	public Combattant(String nom, int force, int dexterite, int intelligence, int concentration, int experience,int vitalite, String typeCombattant,int tailleTab) {
		this.nom = new String(nom);

		this.force = force;
		this.dexterite = dexterite;
		this.intelligence = intelligence;
		this.concentration = concentration;

		this.experience= experience;
		this.vitalite = vitalite;

		this.typeCombattant= new String(typeCombattant);

		this.technique = new Capacite[tailleTab];
	}


	public String getNom() {
		return this.nom;
	}

	public int getForce() {
		return this.force;
	}

	public int getDexterite() {
		return this.dexterite;
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	public int getConcentration() {
		return this.concentration;
	}

	public int getExperience() {
		return this.experience;
	}

	public int getVitalite() {
		return this.vitalite;
	}

	public String getTypeCombattant() {
		return this.typeCombattant;
	}


	public void setNom(String nom) {
		this.nom = new String(nom);
	}

	public void setForce(int force) {
		this.force = force;
	}

	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}

	public void setVitalite(int vitalite) {
		this.vitalite = vitalite;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setTypeCombattant(String typeCombattant) {
		this.typeCombattant = new String(typeCombattant);
	}

	/**
	 * <p>Cette methode va, par le biais d'autres methodes qui seront appellees,
	 * afficher et attribuer des capacites telles que Epee ou Ecu a un combattant.</p>
	 * 
	 */

	public void afficheCapaciteDispo(){ 
		int nbreCapDispo=2;
		@SuppressWarnings("resource")
		Scanner scat= new Scanner(System.in); // ligne générée par eclipse pour eteindre warning Scanner sc car non fermé
		String s="";
		String choixType="";
		boolean detecErreur=false; //boolean valant true utilisé pour recommencer une boucle do-while tout au long du programme.

		if (this.getExperience()>=4 && this.getExperience()<=20)
			nbreCapDispo=1; 	//En cas de de gain d'experience, on ajoute une seule capacité a un combattant d'ou le 1.

		for(int i=0;i<nbreCapDispo;i++){

			System.out.println("Vous avez le droit a "+ (nbreCapDispo-i) +" capacités.");

			System.out.println("Saisissez une catégorie de capacité: Arme / Bouclier / Sort / Objet.");

			s= scat.nextLine();
			s=s.toLowerCase();		 //on convertit la chaine saisie en minuscule pour faciliter le controle.

			if( s.equals("arme") || s.equals("bouclier") || s.equals("sort") || s.equals("objet") ){
				System.out.println(s + " disponibles:");
				afficheDiffCap(s); 		// Si la saisie corresont a un type de capacite, on affiche tout les capacites correspondant a ce type.
			}	
			else{	// si la saisie ne correspond pas a un type de capacite.
				do{
					System.out.println("Votre saisie ne correspond pas à une catégorie de capacité");
					System.out.println("Vous avez le droit a "+ (nbreCapDispo-i) +" capacités.");
					System.out.println("Saisissez une catégorie de capacité: Arme / Bouclier / Sort / Objet.");
					s= scat.nextLine();
					s=s.toLowerCase();
				}while(!s.equals("arme") && !s.equals("bouclier") && !s.equals("sort") && !s.equals("objet"));
				System.out.println(s + " disponibles:");
				afficheDiffCap(s);		
			}
			choixType=s; //la chaine saisie est enregistree dans choixType

			do{
				detecErreur=false;
				System.out.println("Choisissez votre "+ choixType + " en tapant son nom.\n"
						+ "Vous pouvez annuler votre saisie précédante en tapant: 'Annuler'\n");
				s= scat.nextLine();
				s= s.toLowerCase();		//s doit correspondre au nom d'une capacite ou annuler afin de saisir un nouveau type de capacite.

				if(s.equals("annuler")){
					do{
						System.out.println("Annulation.\n"
								+"Vous avez le droit a "+ (nbreCapDispo-i) +" capacités.");
						System.out.println("Saisissez une catégorie de capacité: Arme / Bouclier / Sort / Objet.");
						s= scat.nextLine();
						s=s.toLowerCase();
						if (!s.equals("arme") && !s.equals("bouclier") && !s.equals("sort") && !s.equals("objet")){
							detecErreur=true;
							System.out.println("Saisie de la catégorie de capacité incorrecte. Réessayez.");
						}
					}while(detecErreur==true);

					System.out.println(s + " disponibles:");
					afficheDiffCap(s);	

					choixType=s;	//La nouvelle saisie (apres annulation) est enregistree dans choixType
					detecErreur=true;	//permet de recommencer la boucle do-while afin de saisir le nom d'une capacite ou d'annuler a nouveau.
				}
				else if(choixType.equals("arme") && detecErreur==false){
					if (!s.equals("epee") && !s.equals("hache") && !s.equals("galaxynote4") && !s.equals("galaxy note 4")){
						System.out.println(choixType + " inexistante");	
						detecErreur=true;
					}
				}
				else if(choixType.equals("bouclier") && detecErreur==false){
					if (!s.equals("ecu") && !s.equals("antiemeute")){
						System.out.println(choixType + " inexistant");	
						detecErreur=true;	
					}
				}
				else if(choixType.equals("sort") && detecErreur==false){
					if((s.equals("sortdesoin") || s.equals("sort de soin")) && this.getTypeCombattant().equals("guerrier") ){
						System.out.println("Un guerrier ne peut pas utiliser de sort de soin.\n");		//contrainte du cahier des charges.
						detecErreur=true;
					}
					else if (!s.equals("sort d'attaque") && !s.equals("sort de defense") && !s.equals("sort de soin") 
							&& !s.equals("sortd'attaque")  && !s.equals("sortattaque") && !s.equals("sort attaque")
							&& !s.equals("sortdedefense") && !s.equals("sortdesoin")){
						System.out.println(choixType + " inexistant");	
						detecErreur=true;
					}
				}
				else if(choixType.equals("objet") && detecErreur==false){
					if (!s.equals("remede")){
						System.out.println(choixType + " inexistant");		
						detecErreur=true;	
					}
				}
				else{
					System.out.println("Saisie incorrecte. Veuillez réessayer.\n");
					detecErreur=true;
				}

			}while( detecErreur==true);

			this.ajouteCapacite(s);		//on ajoute finalement la capacite saisie a l'inventaire du combattant.

			s=s.toUpperCase();
			System.out.println(s + " a ete ajoute a l'inventaire.");
		}
	}

	/**
	 * <p>Cette methode affiche simplement les capacites disponible
	 *  en fonction du type de capacite passe en parametres.</p>
	 * 
	 * @param s Type de capacites(arme, bouclier, sort, objet).
	 */

	public void afficheDiffCap(String s){		//Affiche les capacités disponibles en fonction du type de capacité contenu dans le String s

		//Methode appelee par afficheCapaciteDispo()

		if( s.equals("arme") ){
			System.out.println(new Epee( this.getDexterite(), this.getForce() ));	
			System.out.println(new Hache( this.getDexterite(), this.getForce() ));	
			System.out.println(new GalaxyNote4( this.getDexterite(), this.getForce() ));
		}

		else if( s.equals("bouclier") ){
			System.out.println(new Ecu(this.getDexterite(), this.getForce()));	
			System.out.println(new AntiEmeute(this.getDexterite(), this.getForce()));	
		}

		else if( s.equals("sort") ){
			System.out.println(new SortAttaque(this.getIntelligence(), this.getConcentration() ));	
			System.out.println(new SortDeDefense(this.getIntelligence(), this.getConcentration() ));		
			if( !this.getTypeCombattant().equals("guerrier") )
				System.out.println(new SortDeSoin(this.getIntelligence(), this.getConcentration() ));	
		}

		else if( s.equals("objet") ){
			System.out.println(new Remede(this.getDexterite(), this.getForce() ));	
		}
	}

	/**
	 * <p>Cette methode prend en parametre un String correspondant a une capacite 
	 * specifique qui sera ajoutee a l'inventaire du combattant.</p>
	 * 
	 * @param s Nom d'une capacite specifique (epee, hache, antiemeute...).
	 */

	public void ajouteCapacite(String s){
		s=s.toLowerCase();
		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]==null){
				if(s.equals("epee")){
					this.technique[i] = new Epee( this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("hache")){
					this.technique[i] = new Hache( this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("galaxynote4") || s.equals("galaxy note 4")){
					this.technique[i] = new Hache( this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("ecu")){
					this.technique[i] = new Ecu( this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("antiemeute")){
					this.technique[i] = new AntiEmeute( this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("sort d'attaque") || s.equals("sortd'attaque") || s.equals("sortattaque")){
					this.technique[i] = new SortAttaque( this.getIntelligence(), this.getConcentration() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("sort de defense") || s.equals("sortdedefense")){
					this.technique[i] = new SortDeDefense(this.getIntelligence(), this.getConcentration() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if((s.equals("sort de soin") || s.equals("sortdesoin")) && !this.getTypeCombattant().equals("guerrier")){
					this.technique[i] = new SortDeSoin(this.getIntelligence(), this.getConcentration() );
					i=(this.technique.length)+1; //pour sortir du for
				}
				if(s.equals("remede")){
					this.technique[i] = new Remede(this.getDexterite(), this.getForce() );
					i=(this.technique.length)+1; //pour sortir du for
				}
			}
		}

	}

	/**
	 * <p>Methode servant a ajouter une capacite a l'inventaire d'un combattant
	 * en cas de gain d'experience a la fin d'un combat.</p>
	 */

	public void nouvelleCapaciteLevelUp(){
		this.setExperience(this.getExperience()+1);
		if(this.getExperience()%2==0 && (this.getExperience()>=4 && this.getExperience()<=20)){
			System.out.println("\n\nUNE NOUVELLE CAPACITE EST DISPONIBLE POUR "+ this.getNom());
			this.afficheCapaciteDispo();
		}
	}


	/**
	 * 
	 * Cette methode propose a un joueur le choix d'attaquer, de se soigner ou d'abandonner.
	 * Si le joueur decide d'attaquer ou de defendre sans capacite adequate, son tour saute
	 * et la main passe a l'adversaire.
	 * Ce n'est pas le cas s'il decide de se soigner sans capacite curative, un message d'erreur s'affiche
	 * et le joueur garde la main.
	 * 
	 * @param p correspond a l'adversaire en cas d'attaque.
	 * @return La valeur de retour correspond a l'efficacite offensive en cas d'attaque. En cas d'abandon ou de soin, elle vaut 0.
	 */

	public float combat(Combattant p){

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		boolean detecErreur= false;
		boolean capSoinDispo;

		do{
			do{
				detecErreur=false;
				System.out.println("\n\nAu tour de " +this.getNom()+ ", PV " + this.getVitalite() + ":\n\n"
						+ "Que souhaitez vous faire:\n"
						+ "Sauvegarder votre personnage?\n"
						+ "Attaquer "+p.getNom() +"\n"
						+ "Soin\n"
						+ "Abandonner\n\n"
						+ "Saisissez 'Sauvegarder', 'Attaquer', 'Soin' ou 'Abandonner' pour continuer.\n");

				//On peut aussi utiliser les mots 'sauvegarde', 'attaque', 'soigner'

				choix=sc.nextLine();
				choix=choix.toUpperCase(); //La conversion du String en majuscule ou en minuscule facilite le controle et la saisie.

				if(!choix.equals("ATTAQUER") && !choix.equals("ATTAQUE")
						&& !choix.equals("SOIGNER") && !choix.equals("SOIN")
						&& !choix.equals("SAUVEGARDER") && !choix.equals("SAUVEGARDE")
						&& !choix.equals("ABANDONNER") && !choix.equals("ABANDON")){
					System.out.println("Saisie incorrecte veuillez réessayer.");
					detecErreur=true;
				}

				if(choix.equals("SAUVEGARDER") || choix.equals("SAUVEGARDE")){
					this.sauvegarde();
					detecErreur=true; //pour pouvoir attaquer, se soigner, abandonner apres la sauvegarde.
				}


			}while(detecErreur==true);

			if(choix.equals("ATTAQUER") || choix.equals("ATTAQUE")){
				float resultatAttaque= this.attaqueImmediate();
				return resultatAttaque;
			}



			if(choix.equals("SOIGNER") || choix.equals("SOIN")){
				capSoinDispo=this.soin();
				if (capSoinDispo==false)	//Si le combattant ne possede pas de capacite curative, il peut a nouveau choisir d'attaquer etc.
					detecErreur=true;
				else
					return 0;
			}


			if(choix.equals("ABANDONNER") || choix.equals("ABANDON")){
				System.out.println(this.getNom()+" abandonne.");
				this.setVitalite(0);
				return 0;
			}


		}while(detecErreur==true);

		return 0;
	}

	/**
	 * 
	 * Cette methode propose au joueur attaqué de se defendre immediatement ou d'attendre
	 * de connaitre l'efficacite offensive (passee en parametre) pour defendre ou encaisser et contre-attaquer.
	 * De plus, cette methode modifie la vitalite des combattant en fonction des choix defensif du joueur attaqué.
	 * 
	 * @param effAttAdversaire correspond a l'efficacite offensive selon le choix de l'adversaire
	 * 
	 * @param p correspond au joueur adverse. Necessaire en cas de contre attaque.
	 */


	public void choixDefense(float effAttAdversaire, Combattant p){		

		//Cette méthode retire des points de vie à la suite des attaques. 
		//	Il est nécesaire de controler la vitalité des personnages avant de continuer le duel.

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		boolean detecErreur= false;
		float degatSubis;

		System.out.println("A "+this.getNom() + " de jouer:\n");	

		do{
			detecErreur=false;
			System.out.println("Votre adversaire vous a attaqué ou s'est soigné.");

			System.out.println("\nSouhaitez vous défendre immédiatement? (1)\n"
					+"Souhaitez vous connaitre la puissance "
					+ "de l'attaque de votre adversaire "
					+ "pour defendre ou encaisser puis attaquer? (2)\n");


			choix= sc.nextLine();	//Saisie de 1 ou 2 sous forme de chaine de caractere pour faciliter le controle.
			if(!choix.equals("1") && !choix.equals("2"))
				detecErreur=true;

		}while(detecErreur==true);




		if(choix.equals("1")){
			System.out.println("Vous avez choisi de défendre immediatement.");
			degatSubis= this.defenseImmediate(effAttAdversaire); 
			//Si la defense est reussie, effAttAdversaire est reduit de l'efficacite defensive de la capacite du combattant attaqué. Sinon elle reste la meme.
			System.out.println("PV de " + this.getNom() + " avant attaque: " + this.getVitalite()
			+ "PV après attaque: " + (this.getVitalite()-degatSubis)
			+"\n");
			this.setVitalite( (int) (this.getVitalite()-degatSubis));
		}

		if(choix.equals("2")){
			System.out.println("Vous avez choisi d'évaluer la puissance "
					+ "de l'attaque avant de prendre une décision\n" 
					+ "Puissance de l'attaque de " + p.getNom() + ": " + effAttAdversaire);

			//On affiche l'efficacite de la capacite offensive de l'adversaire.
			//On peut ensuite choisir de defendre ou d'encaisser et contre-attaquer.

			if(effAttAdversaire==0)
				System.out.println("Votre adversaire a raté son attaque! Vous ne recevez aucun dégat.");	


			do{
				detecErreur=false;
				System.out.println("Souhaitez vous défendre (1) ou encaisser et contre-attaquer (2)?");

				choix= sc.nextLine();
				if(!choix.equals("1") && !choix.equals("2"))
					detecErreur=true;

			}while(detecErreur==true);

			if(choix.equals("1")){
				System.out.println("Vous avez choisi de défendre en décalé.");
				degatSubis= this.defenseDecalee(effAttAdversaire);
				System.out.println("PV de " + this.getNom() + " avant attaque: " + this.getVitalite()
				+ "PV après attaque: " + (this.getVitalite()-degatSubis));
				this.setVitalite( (int) (this.getVitalite()-degatSubis));
			}

			if(choix.equals("2")){
				System.out.println("Vous avez choisi d'encaisser et contre-attaquer.");

				System.out.println("PV de " + this.getNom() + " avant attaque: " + this.getVitalite()
				+ "PV après attaque: " + (this.getVitalite()-effAttAdversaire));

				this.setVitalite( (int) (this.getVitalite()-effAttAdversaire));
				degatSubis= this.attaqueDecalee();
				p.setVitalite( (int) (p.getVitalite()-degatSubis));
			}
		}
	}

	/**
	 * 
	 * Methode utilisee pour choisir une capacite avec laquelle le joueur procedera a l'attaque.
	 * Le tirage d'un nombre aleatoire est necessaire pour determiner la reussite de l'attaque
	 * en fonction de la probabilite de reussite de la capacite.
	 * 
	 * @return l'efficacite offensive (initiale) de la capacite choisie par le joueur attaquant.
	 */

	public float attaqueImmediate(){
		String a="";
		boolean armeTrouvee=false;
		boolean detecErreur= false;
		int indiceRetenu=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		Random r=new Random();


		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null && (this.technique[i].getCategorieAtt() == true))
				a=a+"Capacite "+(i+1)+" = "+this.technique[i]+"\n";		//On parcourt le tableau de capacite du combattant pour trouver les capacites offensives.
		}

		if(!a.equals(""))
			System.out.println("Capacité offensive disponible:\n"+a); //On affiche les capacites trouvees.
		else{
			System.out.println("Aucune capacité offensive disponible. \n"
					+ "Attaque échouée. Vous devriez abandonner.");	
			return 0;

			//Cette partie peut sembler cruelle mais le joueur aurait du faire attention aux capacites qu'il avait choisi.
			//Puis finalement, il n'a aucune chance de gagner sans capacite offensive. C'est pourquoi son tour s'arrete ici.
		}

		do{
			detecErreur=false;
			armeTrouvee=false;
			System.out.println("Choissisez une capacité, saisissez son nom.\n");

			choix=sc.nextLine();
			choix=choix.toUpperCase();
			//On choisit une capacite offensive.
			System.out.println("CHOIX: "+ choix +"\n" );
			for(int i=0;i<this.technique.length;i++)
			{
				if(this.technique[i] != null && choix.equals(this.technique[i].getNom().toUpperCase()) && this.technique[i].getCategorieAtt()==true){
					indiceRetenu=i;		//Si la saisie correspond a une capacite offensive, on retient son indice.
					armeTrouvee=true;
				}
				if(i==(this.technique.length-1) && armeTrouvee==false)
					System.out.println("Votre saisie n'a pas pu être exploitée. Merci de réessayer.\n");
			}
		}while(detecErreur==true || armeTrouvee==false);

		System.out.println("Vous avez choisi d'attaquer avec: "+ this.technique[indiceRetenu].getNom()+"\n");

		float probabilite= r.nextFloat(); //On tire un nombre aleatoire compris entre 0 et 1
		probabilite=probabilite+0.001f; 

		/*POUR LA PRESENTATION: nous allons fixer la probabilite a 0.000001f
		pour que toutes les attaques et les defenses soient réussies.*/
		
		//probabilite=0.000001f;
		
		//Si ce nombre tiré est inferieur ou egal a la probabilite de reussite de la capacite, alors l'attaque est reussie.
		if(probabilite>=0 && probabilite<=this.technique[indiceRetenu].getPbaAtt()){
			return this.technique[indiceRetenu].getEffAtt();	//<-- effAtt si reussie sinon 0
		}
		else{
			return 0;		
		}
	}


	/**
	 * 
	 * Methode utilisee dans le cadre d'une contre-attaque. Elle est identique a la methode
	 * attaqueImmediate() sauf au niveau de l'affichage des statistiques des capacites
	 * qui sont reduites d'un quart.
	 * 
	 * @return l'efficacite offensive reduite du quart de l'efficacite initiale 
	 * de la capacite choisie par le joueur attaquant.
	 */

	public float attaqueDecalee(){ //Le fonctionnement est identique a attaqueImmediate sauf au point commenté.
		String a="";
		boolean armeTrouvee=false;
		boolean detecErreur= false;
		int indiceRetenu=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		Random r=new Random();


		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null && (this.technique[i].getCategorieAtt() == true)){
				a=a+"Capacite "+(i+1)+" = "+this.technique[i].afficheCapaciteAvecCoeffReduit()+"\n";
				//On ajoute au 'String a' l'état de la capacite avec les coeff reduits d'un quart comme indiqué sur le cahier des charges.
			}
		}

		if(!a.equals(""))
			System.out.println("Capacité offensive disponible:\n"+a);
		else{
			System.out.println("Aucune capacité offensive disponible. \n"
					+ "Attaque échouée. Vous devriez abandonner.");	
			return 0;
		}

		do{
			detecErreur=false;
			armeTrouvee=false;
			System.out.println("Choissisez une capacité, saisissez son nom.\n");

			choix=sc.nextLine();
			choix=choix.toUpperCase();
			System.out.println("CHOIX: "+ choix +"\n" );
			for(int i=0;i<this.technique.length;i++)
			{
				if(this.technique[i] != null && choix.equals(this.technique[i].getNom().toUpperCase()) && this.technique[i].getCategorieAtt()==true){
					indiceRetenu=i;
					armeTrouvee=true;
				}
				if(i==(this.technique.length-1) && armeTrouvee==false)
					System.out.println("Votre saisie n'a pas pu être exploitée. Merci de réessayer.\n");
			}
		}while(detecErreur==true || armeTrouvee==false);

		System.out.println("Vous avez choisi d'attaquer avec: "+ this.technique[indiceRetenu].getNom()+"\n");

		float probabilite= r.nextFloat();
		probabilite=probabilite+0.001f;

		/*POUR LA PRESENTATION: nous allons fixer la probabilite a 0.000001f
		pour que toutes les attaques et les defenses soient réussies.*/
		
		//probabilite=0.000001f;
		
		if(probabilite>=0 && probabilite<=(this.technique[indiceRetenu].getPbaAtt()*0.75f)){
			System.out.println("Attaque réussie!\n");
			return this.technique[indiceRetenu].getEffAtt()*0.75f;	//<-- effAtt si reussie sinon 0
		}
		else{
			System.out.println("Attaque ratée.\n");
			return 0;		
		}


	}


	/**
	 * 
	 * Methode utilisee pour choisir une capacite avec laquelle le joueur procedera a la defense.
	 * Le tirage d'un nombre aleatoire est necessaire pour determiner la reussite de la defense
	 * en fonction de la probabilite de reussite de la capacite.
	 * 
	 * 
	 * @param effAttAdversaire Correspond a l'efficacite offensive de l'attaque adverse.
	 * @return Les degats subis par le combattant attaqué. Ils peuvent etre reduits selon
	 * la defense du joueur attaqué.
	 */

	public float defenseImmediate(float effAttAdversaire){
		String a="";
		boolean armeTrouvee=false;
		boolean detecErreur= false;
		int indiceRetenu=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		Random r=new Random();

		float degatSubis;

		if(effAttAdversaire==0){
			System.out.println("Votre adversaire a raté son attaque! Vous ne recevez aucun dégat.\n");
			return 0.0f;
		}

		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null && (this.technique[i].getCategorieDef() == true))
				a=a+"Capacite "+(i+1)+" = "+this.technique[i]+"\n";		
			//On ajoute au 'String a' l'état des capacites defensives.
		}

		if(!a.equals(""))
			System.out.println("Capacité défensive disponible:\n"+a);
		else{
			System.out.println("Aucune capacité défensive disponible. Defense echouée, l'abandon est conseillé.\n");	
			return effAttAdversaire;
		}


		do{
			detecErreur=false;
			armeTrouvee=false;
			System.out.println("Choissisez une capacité, saisissez son nom.\n");

			choix=sc.nextLine();
			choix=choix.toUpperCase();
			System.out.println("CHOIX: "+ choix +"\n" );
			for(int i=0;i<this.technique.length;i++)
			{
				if(this.technique[i] != null && choix.equals(this.technique[i].getNom().toUpperCase()) && this.technique[i].getCategorieDef()==true){
					indiceRetenu=i;
					armeTrouvee=true;
				}
				if(i==(this.technique.length-1) && armeTrouvee==false)
					System.out.println("Votre saisie n'a pas pu être exploitée. Merci de réessayer.\n");
			}
		}while(detecErreur==true || armeTrouvee==false);


		System.out.println("Vous avez choisi de défendre avec: "+ this.technique[indiceRetenu].getNom());

		float probabilite= r.nextFloat();
		probabilite=probabilite+0.001f;

		/*POUR LA PRESENTATION: nous allons fixer la probabilite a 0.000001f
		pour que toutes les attaques et les defenses soient réussies.*/
		
		//probabilite=0.000001f;
		
		if(probabilite>=0 && probabilite<=this.technique[indiceRetenu].getPbaDef()){
			System.out.println("Défense réussie!\n");
			degatSubis=effAttAdversaire-this.technique[indiceRetenu].getEffDef();	//	//<-- effAtt si reussie sinon 0

			if(degatSubis<0)
				degatSubis=0; //si l'efficacite defensive est superieure a l'efficacite offensive, les degats sont ramenés a 0 pour ne pas restaurer de la vie.

			return degatSubis;
		}
		else{
			System.out.println("Défense ratée.\n");
			return effAttAdversaire;		
		}

	}

	/**
	 * Methode utilisee apres avoir pris connaissance de l'efficacite offensive.
	 * Elle est identique a la methode defenseImmediate() sauf au niveau de l'affichage des
	 * statistiques des capacites qui sont reduites d'un quart.
	 * 
	 * @param effAttAdversaire  Correspond a l'efficacite offensive de l'attaque adverse.
	 * @return Les degats subis par le combattant attaqué. Ils peuvent etre reduits selon
	 * la defense du joueur attaqué.
	 */

	public float defenseDecalee(float effAttAdversaire){ //Methode identique a defenseImmediate sauf changement de certains coeff pour repondre au sujet.
		String a="";
		boolean armeTrouvee=false;
		boolean detecErreur= false;
		int indiceRetenu=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		Random r=new Random();

		float degatSubis;

		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null && (this.technique[i].getCategorieDef() == true))
				a=a+"Capacite "+(i+1)+" = "+this.technique[i].afficheCapaciteAvecCoeffReduit()+"\n";	
		}

		if(!a.equals(""))
			System.out.println("Capacité défensive disponible:\n"+a);
		else{
			System.out.println("Aucune capacité défensive disponible. Defense echouée, l'abandon est conseillé.\n");	
			return effAttAdversaire;
			//Si le combattant ne dispose d'aucune capacite defensive, son tour s'arrete.
		}


		do{
			detecErreur=false;
			armeTrouvee=false;
			System.out.println("Choissisez une capacité, saisissez son nom.\n");

			choix=sc.nextLine();
			choix=choix.toUpperCase();
			System.out.println("CHOIX: "+ choix +"\n" );
			//On choisit une capacite en saisissant son nom en majuscule ou en minuscule car la saisie a été convertie en majuscule
			for(int i=0;i<this.technique.length;i++)
			{
				if(this.technique[i] != null && choix.equals(this.technique[i].getNom().toUpperCase()) && this.technique[i].getCategorieDef()==true){
					indiceRetenu=i;
					armeTrouvee=true;
				}
				if(i==(this.technique.length-1) && armeTrouvee==false)
					System.out.println("Votre saisie n'a pas pu être exploitée. Merci de réessayer.\n");
			}
		}while(detecErreur==true || armeTrouvee==false);


		System.out.println("Vous avez choisi de défendre avec: "+ this.technique[indiceRetenu].getNom());

		float probabilite= r.nextFloat();
		probabilite=probabilite+0.001f;

		/*POUR LA PRESENTATION: nous allons fixer la probabilite a 0.000001f
		pour que toutes les attaques et les defenses soient réussies.*/
		
		//probabilite=0.000001f;
		
		if(probabilite>=0 && probabilite<=(this.technique[indiceRetenu].getPbaDef()*0.75f)){
			System.out.println("Défense réussie!\n");
			degatSubis=effAttAdversaire-(this.technique[indiceRetenu].getEffDef()*0.75f);	

			if(degatSubis<0)
				degatSubis=0; //si l'efficacite defensive est superieure a l'efficacite offensive, les degats sont ramenés a 0 pour ne pas restaurer de la vie.

			return degatSubis;
		}
		else{
			System.out.println("Défense ratée.\n");
			return effAttAdversaire;		
		}

	}

	/**
	 * 
	 * Methode qui permet de se soigner. Elle est appellee par la methode combat().
	 * 
	 * @return false si le combattant ne dispose d'aucune capacite curative. Sinon elle renvoie
	 * true, que le soin ait reussi ou non.
	 * 
	 */

	public boolean soin(){
		String a="";
		boolean armeTrouvee=false;
		boolean detecErreur= false;
		int indiceRetenu=0;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choix;
		Random r=new Random();


		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null && (this.technique[i].getCategorieSoi() == true))
				a=a+"Capacite "+(i+1)+" = "+this.technique[i]+"\n";		
			//On concatene la chaine a avec l'état des capacites curative du combattant.
		}

		if(!a.equals(""))
			System.out.println("Capacité curative disponible:\n"+a);
		else{
			System.out.println("Aucune capacité curative disponible. Le tour de "+ this.getNom() +" continue.");	
			detecErreur=true;
			return false;
		}

		if(detecErreur == false){
			do{
				detecErreur=false;
				armeTrouvee=false;
				System.out.println("Choissisez une capacité, saisissez son nom.\n");

				choix=sc.nextLine();
				choix=choix.toUpperCase();
				System.out.println("CHOIX: "+ choix +"\n" );

				for(int i=0;i<this.technique.length;i++)
				{
					if(this.technique[i] != null && choix.equals(this.technique[i].getNom().toUpperCase()) && this.technique[i].getCategorieSoi()==true){
						indiceRetenu=i;
						armeTrouvee=true;
					}
					if(i==(this.technique.length-1) && armeTrouvee==false)
						System.out.println("Votre saisie n'a pas pu être exploitée. Merci de réessayer.\n");
				}
			}while(detecErreur==true || armeTrouvee==false);

			System.out.println("Vous avez choisi de vous soigner avec: "+ this.technique[indiceRetenu].getNom());

			float probabilite= r.nextFloat();
			probabilite=probabilite+0.001f;

			
			/*POUR LA PRESENTATION: nous allons fixer la probabilite a 0.000001f
			pour que toutes les attaques et les defenses soient réussies.*/
			
			//probabilite=0.000001f;
			
			
			if(probabilite>=0 && probabilite<=this.technique[indiceRetenu].getPbaDef()){
				System.out.println("Soin réussi!\n");
				System.out.println("Vitalite de "+ this.getNom() +" avant soin: " + this.getVitalite()
				+"\nVitalite de "+ this.getNom() +" après soin: " + (this.getVitalite()+this.technique[indiceRetenu].getEffDef())); //On affiche la vitalite du combattant avant et apres le soin.

				this.setVitalite( (int) (this.getVitalite() + this.technique[indiceRetenu].getEffDef() ) ); // On augmente la vitalite en fontion de l'efficacite de la capacite curative si elle reussie.
			}
			else{
				System.out.println("Soin raté.\n");		
			}
			return true;
		}

		return true;

	}


	/**
	 * 
	 * Capacite polymorphe permettant a deux combattant de n'importe quel type
	 * de s'affronter. Cette methode comprend le systeme de tour par tour permettant
	 * aux joueurs de prendre la main a la fin du tour adverse.
	 * 
	 * @param j1 Combattant du joueur 1, ce parametre peut etre un guerrier, chasseur ou un mage.
	 * @param j2 Combattant du joueur 2.
	 */

	public static void affrontement(Combattant j1 , Combattant j2){
		boolean combatContinue=true;
		String choixSauvegarde="";
		@SuppressWarnings("resource")
		Scanner sc=new Scanner (System.in);
		float resultatAttaque1=0;

		if(j1.getVitalite()<=0){
			System.out.println("Le joueur "+ j2.getNom() +" a remporté le combat");
			combatContinue=false;
		}
		else if(j2.getVitalite()<=0){
			System.out.println("Le joueur "+ j1.getNom() +" a remporté le combat");
			combatContinue=false;
		}
		else if(j1.getVitalite()<=0 && j2.getVitalite()<=0){
			System.out.println("EGALITE: Les deux personnages sont KO.\n\n");
			combatContinue=false;
		}

		do{
			
			if(combatContinue==true){

				resultatAttaque1=j1.combat(j2);
				if(j1.getVitalite()<=0){
					System.out.println("Le joueur "+ j2.getNom() +" a remporté le combat");
					combatContinue=false;
				} //Verification pour savoir si j1 a abandonné.
			}
			
			if(combatContinue==true){		//Si j1 n'a pas abandonné
				j2.choixDefense(resultatAttaque1, j1);	//On passe a la phase defensive de j2

				if(j1.getVitalite()<=0){ //En cas de contre-attaque reussie de J2
					System.out.println("Le joueur "+ j2.getNom() +" a remporté le combat");
					combatContinue=false;
				}
				else if(j2.getVitalite()<=0){ //Si l'attaque de j1 a tué j2
					System.out.println("Le joueur "+ j1.getNom() +" a remporté le combat");
					combatContinue=false;
				}
				else if(j1.getVitalite()<=0 && j2.getVitalite()<=0){ //Si l'attaque de j1 a tué j2 et que la contre-attaque de j2 a tué j1
					System.out.println("EGALITE: Les deux personnages sont KO.\n\n");
					combatContinue=false; //On imagine que j2 succombe a ses blessures après avoir contre-attaquer.
				}

			}

			
			if(combatContinue==true){

				resultatAttaque1=j2.combat(j1);
				if(j2.getVitalite()<=0){
					System.out.println("Le joueur "+ j1.getNom() +" a remporté le combat");
					combatContinue=false;	//Verification pour savoir si j2 a abandonné.
				}
			}
			
			if(combatContinue==true){		//Si j2 n'a pas abandonné
				j1.choixDefense(resultatAttaque1, j2);		//On passe a la phase defensive de j1

				if(j2.getVitalite()<=0){	//En cas de contre-attaque reussie de J1
					System.out.println("Le joueur "+ j1.getNom() +" a remporté le combat");
					combatContinue=false;
				}
				else if(j1.getVitalite()<=0){	//Si l'attaque de j2 a tué j1
					System.out.println("Le joueur "+ j2.getNom() +" a remporté le combat");
					combatContinue=false;
				}
				else if(j2.getVitalite()<=0 && j1.getVitalite()<=0){	//Si l'attaque de j2 a tué j1 et que la contre-attaque de j1 a tué j2
					System.out.println("EGALITE: Les deux personnages sont KO.\n\n");
					combatContinue=false;	//On imagine que j1 succombe a ses blessures après avoir contre-attaquer.
				}

			}
			
		}while(combatContinue==true);

		if(j2.getVitalite()<=0){
			
			if(j2.getExperience()>1)
				j2.setExperience(j2.getExperience()-1);
			
			j1.nouvelleCapaciteLevelUp();
			do{
				System.out.println("Souhaitez vous sauvegarder le "+j1.getTypeCombattant()+" "+j1.getNom()+"?"
					+ "\nRepondez par 'oui' ou 'non'.");
			choixSauvegarde=sc.nextLine();
			choixSauvegarde=choixSauvegarde.toLowerCase();
			}while(!choixSauvegarde.equals("oui") && !choixSauvegarde.equals("non"));
			
			if(choixSauvegarde.equals("oui"))
				j1.sauvegarde();

		}


		if(j1.getVitalite()<=0){
			
			if(j1.getExperience()>1)
				j1.setExperience(j1.getExperience()-1);
			
			j2.nouvelleCapaciteLevelUp();
			do{
				System.out.println("Souhaitez vous sauvegarder le "+j2.getTypeCombattant()+" "+j2.getNom()+"?"
					+ "\nRepondez par 'oui' ou 'non'.");
			choixSauvegarde=sc.nextLine();
			choixSauvegarde=choixSauvegarde.toLowerCase();
			}while(!choixSauvegarde.equals("oui") && !choixSauvegarde.equals("non"));
			
			if(choixSauvegarde.equals("oui"))
				j2.sauvegarde();

		}


		System.out.println("FIN DU COMBAT\n\n\n\n");

		System.out.println(j1);

		System.out.println(j2);
	}


	/**
	 * 
	 * Methode permettant de sauvegarder l'etat d'un combattant dans un fichier texte.
	 * Elle sauvegarde les attributs d'un combattant (force, dexterite...) mais aussi
	 * les capacites de son inventaire.
	 * 
	 */

	public void sauvegarde() {
		String saisie="";
		int convertStringEnInt=-1;
		boolean detecErreur=false;

		for(int i=0;i<6;i++){
			File f=new File("sauvegarde"+i);
			Scanner sc;
			try {
				if(f.length()!=0){
					sc = new Scanner(f);
					String s=sc.next();
					System.out.println("Le fichier sauvegarde"+i+" est occupé par un "+s);
				}
				else throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				System.out.println("Le fichier sauvegarde"+i+" est vide");
			}
		}		//La boucle for précédante permet de connaitre le type du combattant sauvegardé dans un fichier ou de savoir s'il est vide.
		try{

			do{
				detecErreur=false;
				System.out.println("Saisissez le fichier dans lequel vous souhaitez sauvegarde votre "+this.getTypeCombattant()+".\n"
						+"Saisissez un nombre entre 0 et 5 inclus.\n");
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				saisie=sc.nextLine(); //On saisit le numero du fichier dans lequel on veut sauvegarde notre combattant sous forme de String.
				try{
					convertStringEnInt=(Integer.parseInt(saisie)); //On convertit le String en int.
				}
				catch(Exception e){
					System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n"); //Le String ne contenait pas seulement un ou des chiffres.
					detecErreur=true;
				}

				if(convertStringEnInt<0 || convertStringEnInt>5)	//On verifie si le chiffre saisit correspond bien a un fichier.
					detecErreur=true;

			}while(detecErreur==true);

			File fSaisie=new File("sauvegarde"+convertStringEnInt);	//On ouvre le fichier voulu
			//S'il est vide on écrit dedans.
			//S'il n'est pas vide, on efface son contenu et on ecrit dedans.


			FileWriter fw=new FileWriter(fSaisie);
			fw.write(typeCombattant+"\n");
			fw.write(this.getNom() + "\n");
			fw.write(Integer.toString(this.getForce() ) + "\n");
			fw.write(Integer.toString(this.getDexterite() ) + "\n");
			fw.write(Integer.toString(this.getIntelligence() ) + "\n");
			fw.write(Integer.toString(this.getConcentration() ) + "\n");
			fw.write(Integer.toString(this.getExperience() ) + "\n");
			for(int i=0;i<technique.length;i++){
				if(technique[i] != null){
					fw.write(technique[i].getNom()+"\n");
					//Ecriture de l'état du combattant.
				}
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println("Erreur d'ecriture dans le fichier "+ exception.getMessage());
		}
	}


	/**
	 * 
	 * Methode permettant de charger l'etat d'un combattant a partir d'un fichier texte.
	 * Elle est appelee au debut de la partie lorsque les joueurs choissisent leur combattant.
	 * 
	 * @return false si le joueur a voulu annuler le chargement dans le cas ou aucun
	 * fichier ne correspond au type de son combattant.
	 */

	@SuppressWarnings("resource")
	public boolean charge(){

		String s;
		String typeCharge;
		String saisie="";
		int convertStringEnInt=-1;

		boolean detecErreur=false;

		for(int x=0;x<6;x++){
			File f=new File("sauvegarde"+x);
			Scanner slot;
			try {
				if(f.length()!=0){
					slot = new Scanner(f);
					String type=slot.next();
					System.out.println("La sauvegarde"+x+" est occupé par un "+type);
				}
				else throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				System.out.println("Le fichier sauvegarde"+x+" est vide");
			}
		}	//La boucle for précédante permet de connaitre le type du combattant sauvegardé dans un fichier
		//ou de savoir s'il est vide.


		do{
			try{

				do{
					detecErreur=false;
					System.out.println("\nSaisissez le numéro du slot que vous voulez chargez.\n"
							+"Saisissez 'Annuler' pour annuler le chargement.\n");	//On peut annuler le chargement si aucun fichier ne correspont au type du combattant du joueur.

					Scanner ss=new Scanner(System.in);
					saisie=ss.nextLine();
					saisie=saisie.toLowerCase();	//On saisit le numero du fichier dans lequel on veut sauvegarde notre combattant sous forme de String.


					if(saisie.equals("annuler"))
						return false;

					try{
						convertStringEnInt=(Integer.parseInt(saisie));	//On convertit le String en int.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début\n\n\n.");	//Le String ne contenait pas seulement un ou des chiffres.
						detecErreur=true;
					}

					if(convertStringEnInt<0 && convertStringEnInt>5)	//On verifie si le chiffre saisit correspond bien a un fichier.
						detecErreur=true;

				}while(detecErreur==true);


				File f=new File("sauvegarde"+convertStringEnInt);
				try {
					if(f.length()!=0){
						detecErreur=false;
					}
					else throw new FileNotFoundException();
				} catch (FileNotFoundException e) {
					System.out.println("Le fichier sauvegarde"+convertStringEnInt+" est vide.");
					detecErreur=true;
				}

				Scanner sc=new Scanner(f);

				while(true){
					try{
						typeCharge=sc.next();
						System.out.println("La sauvegarde contient un "+typeCharge);

						if(typeCharge.equals(this.typeCombattant) && detecErreur==false){	//Si le fichier n'est pas vide est que le type combattant correspond.
							this.setNom(sc.next());
							this.setForce(sc.nextInt());
							this.setDexterite(sc.nextInt());
							this.setIntelligence(sc.nextInt());
							this.setConcentration(sc.nextInt());
							this.setExperience(sc.nextInt());
							for(int i=0;i<this.technique.length;i++){
								s=sc.next();
								s=s.toLowerCase();
								if(s.equals("epee")){
									this.ajouteCapacite("epee");
								}
								if(s.equals("hache")){
									this.ajouteCapacite("hache");
								}
								if(s.equals("ecu")){
									this.ajouteCapacite("ecu");
								}
								if(s.equals("antiemeute")){
									this.ajouteCapacite("antiemeute");
								}
								if(s.equals("sortd'attaque")){
									this.ajouteCapacite("sort d'attaque");
								}
								if(s.equals("sortdedefense")){
									this.ajouteCapacite("sort de defense");
								}
								if(s.equals("sortdesoin")){
									this.ajouteCapacite("sort de soin");
								}
								if(s.equals("remede")){
									this.ajouteCapacite("remede");
								}
							}
						}
						else if(!typeCharge.equals(this.typeCombattant)){
							System.out.println("Vous avez voulu charger un " + typeCharge + " a la place d'un "+ this.typeCombattant);
							detecErreur=true;
							sc.close();
						}
					}
					catch(Exception e){
						break;
					}
				}
				sc.close();
			}
			catch ( IOException e ){
				System.out.println("Erreur de lecture dans le fichier "+ e.getMessage());
			}

		}while(detecErreur==true);
		return true;
	}

	/**
	 * 
	 * Cette methode creer simplement 6 fichiers texte s'ils n'existent pas.
	 * Ils contiendront l'etat des combattant en cas de sauvegarde.
	 * 
	 */

	@SuppressWarnings("unused")
	public static void creerFichierSauvegarde(){	//On crée 6 fichiers sauvegardes s'ils n'existent pas.

		File save0=new File("sauvegarde0");
		File save1=new File("sauvegarde1");
		File save2=new File("sauvegarde2");
		File save3=new File("sauvegarde3");
		File save4=new File("sauvegarde4");
		File save5=new File("sauvegarde5");

		FileWriter fw0;
		FileWriter fw1;
		FileWriter fw2;
		FileWriter fw3;
		FileWriter fw4;
		FileWriter fw5;

		try {
			if(!save0.exists())
				fw0 = new FileWriter(save0);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde0 n'a pas pu être crée.");
		}

		try {
			if(!save1.exists())
				fw1 = new FileWriter(save1);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde1 n'a pas pu être crée.");
		}

		try {
			if(!save2.exists())
				fw2 = new FileWriter(save2);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde2 n'a pas pu être crée.");
		}

		try {
			if(!save3.exists())
				fw3 = new FileWriter(save3);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde3 n'a pas pu être crée.");
		}

		try {
			if(!save4.exists())
				fw4 = new FileWriter(save4);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde4 n'a pas pu être crée.");
		}

		try {
			if(!save5.exists())
				fw5 = new FileWriter(save5);
		} catch (IOException e) {

			System.out.println("ERREUR: Fichier sauvegarde5 n'a pas pu être crée.");
		}
	}

	/**
	 * 
	 * Methode permettant la creation d'un guerrier et de l'attribuer a un combattant grace au
	 * polymorphisme.
	 * 
	 * @return Retourne un guerrier cree par defaut.
	 */


	public static Combattant retourneGuerrier(){
		Guerrier g=new Guerrier();
		return g;
	}

	/**
	 * 
	 * Methode permettant la creation d'un chasseur et de l'attribuer a un combattant grace au
	 * polymorphisme.
	 * 
	 * @return Retourne un chasseur cree par defaut.
	 */

	public static Combattant retourneChasseur(){
		Chasseur c=new Chasseur();
		return c;
	}

	/**
	 * 
	 * Methode permettant la creation d'un mage et de l'attribuer a un combattant grace au
	 * polymorphisme.
	 * 
	 * @return Retourne un mage cree par defaut.
	 */

	public static Combattant retourneMage(){
		Mage m=new Mage();
		return m;
	}

	/**
	 * 
	 * La methode main est le coeur du projet. Elle permet aux joueurs de
	 * saisir le type de combattant qu'ils souhaitent creer ou charger.
	 * Puis cette methode met en place le combat entre ces joueurs.
	 * 
	 * 
	 * @param args parametre String[] args propre a la methode main.
	 * 
	 */


	public static void main(String[] args) {

		System.out.println("Bienvenue dans le mmorpg de Dinesh Govindaradjane & Jeremy Dos Santos du groupe C3.\n"
				+"Ce jeu a été conçu dans le cadre du projet tutoré de M2107 2016.\n\n"
				+ "Bon jeu! :-)\n\n\n");

		creerFichierSauvegarde();

		String choixType1, choixType2, choix1, choix2;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

		Combattant j1= new Combattant();
		Combattant j2= new Combattant();


		boolean chargementTermine=false;


		//Création ou chargement du joueur 1.

		do{
			System.out.println("Joueur 1, de quel type sera votre combattant?\n"
					+ "\nSaisissez 'Guerrier' , 'Mage' ou 'Chasseur' \n");
			choixType1=sc.nextLine();
			choixType1=choixType1.toLowerCase();

		}while(!choixType1.equals("guerrier") && !choixType1.equals("mage") && !choixType1.equals("chasseur"));

		if(choixType1.equals("guerrier")){
			j1 = retourneGuerrier();
		}
		else if(choixType1.equals("mage")){
			j1 = retourneMage();
		}
		else if(choixType1.equals("chasseur")){
			j1 = retourneChasseur();
		}

		do{
			System.out.println("Souhaitez vous charger un " + choixType1
					+ " à partir d'une sauvegarde ou creer un nouveau combattant?"
					+ "\nSaisissez 'Charger' ou 'Creer' \n");
			choix1=sc.nextLine();
			choix1=choix1.toLowerCase();

		}while(!choix1.equals("creer") && !choix1.equals("charger"));


		if(choix1.equals("charger")){
			chargementTermine= j1.charge();
			if(chargementTermine==true){
				System.out.println("Le personnage "+ j1.getNom() +" a été chargé.\n");
				j1.setVitalite(200-(j1.getForce()+j1.getDexterite()+j1.getIntelligence()+j1.getConcentration())+(j1.getExperience()*3));
				System.out.println(j1);
			}
			else
				System.out.println("Le chargement a été annulé. Le "+choixType1+" sera donc un nouveau personnage.\n");
		}


		if(choix1.equals("creer") || chargementTermine==false){
			if(choixType1.equals("guerrier")){
				j1 = Guerrier.creerGuerrier();
				j1.afficheCapaciteDispo();
			}
			else if(choixType1.equals("mage")){
				j1 = Mage.creerMage();
				j1.afficheCapaciteDispo();
			}
			else if(choixType1.equals("chasseur")){
				j1 = Chasseur.creerChasseur();
				j1.afficheCapaciteDispo();
			}
		}


		//Création ou chargement du joueur 2.

		do{
			System.out.println("Joueur 2, de quel type sera votre combattant?\n"
					+ "\nSaisissez 'Guerrier' , 'Mage' ou 'Chasseur' \n");
			choixType2=sc.nextLine();
			choixType2=choixType2.toLowerCase();

		}while(!choixType2.equals("guerrier") && !choixType2.equals("mage") && !choixType2.equals("chasseur"));

		if(choixType2.equals("guerrier")){
			j2 = retourneGuerrier();
		}
		else if(choixType2.equals("mage")){
			j2 = retourneMage();
		}
		else if(choixType2.equals("chasseur")){
			j2 = retourneChasseur();
		}

		do{
			System.out.println("Souhaitez vous charger un " + choixType2
					+ " à partir d'une sauvegarde ou creer un nouveau combattant?"
					+ "\nSaisissez 'Charger' ou 'Creer' \n");
			choix2=sc.nextLine();
			choix2=choix2.toLowerCase();

		}while(!choix2.equals("creer") && !choix2.equals("charger"));


		if(choix2.equals("charger")){
			chargementTermine= j2.charge();
			if(chargementTermine==true){
				System.out.println("Le personnage "+ j2.getNom() +" a été chargé.\n");
				j2.setVitalite(200-(j2.getForce()+j2.getDexterite()+j2.getIntelligence()+j2.getConcentration())+(j2.getExperience()*3));
				System.out.println(j2);
			}
			else
				System.out.println("Le chargement a été annulé. Le "+choixType1+" sera donc un nouveau personnage.\n");
		}


		if(choix2.equals("creer") || chargementTermine==false){
			if(choixType2.equals("guerrier")){
				j2 = Guerrier.creerGuerrier();
				j2.afficheCapaciteDispo();
			}
			else if(choixType2.equals("mage")){
				j2 = Mage.creerMage();
				j2.afficheCapaciteDispo();
			}
			else if(choixType2.equals("chasseur")){
				j2 = Chasseur.creerChasseur();
				j2.afficheCapaciteDispo();
			}
		}

		affrontement(j1, j2);

	}
}

