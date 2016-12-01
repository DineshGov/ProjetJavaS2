package mmorpg;

import java.util.Scanner;

/**
 * 
 * Classe Chasseur.
 * Elle permer d'instancier un chasseur en fonction des criteres 
 * du cahier des charges.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */


public class Chasseur extends Combattant{
	private String type="Chasseur";

	public Chasseur() {
		super();
		this.setTypeCombattant("chasseur");
	}

	public Chasseur(String nom, int f, int d, int i, int c, int e, int v, String type ,int tailleTab) {
		super(nom, f, d, i, c, e, v, "chasseur",tailleTab);
	}
	
	/**
	 * 
	 * Instancie un Chasseur qui sera attribue a un Combattant grace au polymorphisme.
	 * Ce Chasseur repond a tout les criteres du cahier des charges grace
	 * a l'attribution controle des points de caracteristique.
	 * 
	 * @return Le Chasseur instancie lors de l'appel de cette methode.
	 */
	
	public static Chasseur creerChasseur(){
		
		Chasseur c=new Chasseur();
		@SuppressWarnings("resource") // ligne générée par eclipse pour eteindre warning Scanner sc car non fermé
		Scanner sc=new Scanner(System.in);
		int somme=101;	//correspond au nombre de points caracteristique total a attribuer.
		System.out.println("Saisissez le nom de votre Chasseur");
		c.setNom(sc.nextLine());
		boolean detecErreur= false;
		
		String saisie="";
		
		do{
			
			System.out.println("\nSaisie des caractéristique de "+ c.getNom() +":\n"
					+"\nSaisissez une lettre au cours de la saisie des attributs pour la recommencer.\n"
					+"Un chasseur est un combattant assez complet capable aussi bien de manier l’épée que la magie, mais à chaque fois sans être aussi spécialiste qu’un mage ou un guerrier.\n"
					+"Les contraintes suivantes sont imposées à tous les chasseurs:\n"
					+"CONTRAINTES: FOR >= 20\n"
					+"             DEX >= 20\n"
					+"             INT >= 20\n"
					+"             CON >= 20\n");
			detecErreur= false;
			somme=101;
			c.setExperience(1);
			
			if(detecErreur==false){
				do{
					detecErreur=false;
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("\nSaisissez la valeur de la force de " + c.getNom());
					saisie=sc.nextLine();
					try{
						c.setForce(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
						detecErreur=true;
					}
					if(c.getForce()<20 && detecErreur==false){
						System.out.println("ERREUR: La force ne peut être inférieure à 20.\n");
						detecErreur=true;
					}
				}while(detecErreur==true);
				
				somme=somme-c.getForce();	//correspond au nombre de points caracteristique restant a attribuer.
				}
			
				if(somme<0 && detecErreur==false){ //verifie somme
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("ERREUR: Trop de points ont été attribués.");
					detecErreur=true;
				}
				
				
				if(detecErreur==false){ //Saisie DEXTERITE
					do{
						System.out.println("Nombre de points caracteristique à attribuer: "+somme);
						System.out.println("\nSaisissez la valeur de la dexterite de " + c.getNom());
						saisie=sc.nextLine();
						try{
							c.setDexterite(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
						}
						catch(Exception e){
							System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
							detecErreur=true;
						}
						if(c.getDexterite()<20 && detecErreur==false){
							System.out.println("ERREUR: La dextérité ne peut être inférieure à 20.\n");
							detecErreur=true;
						}
						
					}while(c.getDexterite()<0);
					
					somme=somme-c.getDexterite();	//correspond au nombre de points caracteristique restant a attribuer.
				}
				
				if(somme<0 && detecErreur==false){ //verifie somme
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("ERREUR: Trop de points ont été attribués.");
					detecErreur=true;
				}
				
				
				if(detecErreur==false){ //Saisie INTELLIGENCE
					do{
						System.out.println("\nNombre de points caracteristique à attribuer: "+somme);
						System.out.println("\nSaisissez la valeur de l'intelligence de " + c.getNom());
						saisie=sc.nextLine();
						try{
							c.setIntelligence(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
						}
						catch(Exception e){
							System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
							detecErreur=true;
						}
						if(c.getIntelligence()<20 && detecErreur==false){
							System.out.println("ERREUR: La intelligence ne peut être inférieure à 20.\n");
							detecErreur=true;
						}
						
					}while(c.getIntelligence()<0);
					
					somme=somme-c.getIntelligence();	//correspond au nombre de points caracteristique restant a attribuer.
				} 
				
				if(somme<0 && detecErreur==false){ //verifie somme
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("ERREUR: Trop de points ont été attribués.");
					detecErreur=true;
				}
				
				
				if(detecErreur==false){ //Saisie CONCENTRATION
					do{
						System.out.println("Nombre de points caracteristique à attribuer: "+somme);
						System.out.println("\nSaisissez la valeur de la concentration de " + c.getNom());
						saisie=sc.nextLine();
						try{
							c.setConcentration(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
						}
						catch(Exception e){
							System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
							detecErreur=true;
						}
						if(c.getConcentration()<20 && detecErreur==false){
							System.out.println("ERREUR: La concentration ne peut être inférieure à 20.\n");
							detecErreur=true;
						}
						
					}while(c.getConcentration()<0);
					
					somme=somme-c.getConcentration();	//correspond au nombre de points caracteristique restant a attribuer.
				}
				
				if(somme>0 && detecErreur == false)
					System.out.println("ERREUR: Tout les points n'ont pas été attribués.");
				if(somme<0 && detecErreur == false)
					System.out.println("ERREUR: Trop de points ont été attribués.");
				
				c.setVitalite(200-(c.getForce()+c.getDexterite()+c.getIntelligence()+c.getConcentration())+(c.getExperience()*3));
		
			}while(somme != 0 
				|| ((c.getForce()
					+c.getDexterite()
					+c.getIntelligence()
					+c.getConcentration())>100+c.getExperience())
				
				||c.getForce()<20
				||c.getDexterite()<20
				||c.getIntelligence()<20
				||c.getConcentration()<20
				|| detecErreur==true
				);
		System.out.println("\nCONTRAINTES REMPLIES \n\nPERSONNAGE CREE\n\n\n");
		return c;
	}
	
	
	public String toString() {
		String s = this.type+" " + this.getNom() 
		+ ":\nForce: " + this.getForce()
		+ "\nDexterite: " + this.getDexterite()
		+ "\nIntelligence: " + this.getIntelligence() 
		+ "\nConcentration: " + this.getConcentration() 
		+ "\nVitalite: " + this.getVitalite()
		+ "\nExperience: " + this.getExperience()
		+"\n";
		
		String a="";
		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null)
				a=a+"Capacite "+(i+1)+" = "+this.technique[i]+"\n";
		}
		return s+a;
	}






}
	
	


