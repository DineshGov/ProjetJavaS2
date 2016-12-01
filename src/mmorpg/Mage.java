package mmorpg;

import java.util.Scanner;

/**
 * 
 * Classe Mage.
 * Elle permer d'instancier un mage en fonction des criteres 
 * du cahier des charges.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */


public class Mage extends Combattant {
	private String type="Mage";


	public Mage() {
		super();
		this.setTypeCombattant("mage");
	}

	public Mage(String nom, int f, int d, int i, int c, int e, int v, String type ,int tailleTab) {
		super(nom, f, d, i, c, e, v, "mage",tailleTab);
	}

	/**
	 * 
	 * Instancie un Mage qui sera attribue a un Combattant grace au polymorphisme.
	 * Ce Mage repond a tout les criteres du cahier des charges grace
	 * a l'attribution controle des points de caracteristique.
	 * 
	 * @return Le Mage instancie lors de l'appel de cette methode.
	 */
	
	public static Mage creerMage(){
		
		Mage m=new Mage();
		@SuppressWarnings("resource") // ligne générée par eclipse pour eteindre warning Scanner sc car non fermé
		Scanner sc=new Scanner(System.in);
		int somme=101;	//correspond au nombre de points caracteristique total à attribuer.
		boolean detecErreur= false;
		System.out.println("Saisissez le nom de votre Mage");
		m.setNom(sc.nextLine());
		
		String saisie="";
		
		int mi;
		int mc;
		
		do{
			System.out.println("\nSaisie des caractéristique de "+ m.getNom() +":\n"
					+"\nSaisissez une lettre au cours de la saisie des attributs pour la recommencer.\n"
					+"la force d’un magicien réside dans sa capacité à faire de la magie, au détriment de sa force physique.\n"
					+"Les contraintes suivantes sont imposées à tous les magiciens:\n\n"
					+"CONTRAINTES: \nINT >= max(FOR, DEX) + 15\n"
					+"CON >= max(FOR, DEX) + 15\n");
			detecErreur= false;
			somme=101;
			m.setExperience(1);
			
			
			if(detecErreur==false){ //Saisie FORCE
				do{
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("Saisissez la valeur de la force de " + m.getNom());
					saisie=sc.nextLine();
					try{
						m.setForce(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.");
						detecErreur=true;
					}
					if(m.getForce()<0)
						System.out.println("La force ne peut être une valeur négative.");
				}while(m.getForce()<0);
				somme=somme-m.getForce();	//correspond au nombre de points caracteristique restant à attribuer.
			}
		
			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}
			
			
			if(detecErreur==false){ //Saisie DEXTERITE
				do{
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("Saisissez la valeur de la dexterite de " + m.getNom());
					saisie=sc.nextLine();
					try{
						m.setDexterite(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.");
						detecErreur=true;
					}
					if(m.getDexterite()<0)
						System.out.println("La dexterité ne peut être une valeur négative.");
				}while(m.getDexterite()<0);
				somme=somme-m.getDexterite();	//correspond au nombre de points caracteristique restant à attribuer.
			}
			
			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}
			
			
			if(m.getForce()>m.getDexterite()){
				mi=m.getForce();
				mc=m.getForce();
			}
			else{
				mi=m.getDexterite();
				mc=m.getDexterite();
			}
			
			if(detecErreur==false){
				System.out.println("MAX(FOR, DEX)= "+mi+"\n"
						+"CONTRAINTES: \nINT >= " + (mi+15) +"\n"
						+"CON >= " + (mi+15) +"\n");
			}
			
			if(detecErreur==false){ //Saisie INTELLIGENCE
				do{
					System.out.println("\nNombre de points caracteristique à attribuer: "+somme);
					System.out.println("Saisissez la valeur de l'intelligence de " + m.getNom());
					saisie=sc.nextLine();
					try{
						m.setIntelligence(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.");
						detecErreur=true;
					}
					
					if(m.getIntelligence()<0)
						System.out.println("L'intelligence ne peut être une valeur négative.");
				}while(m.getIntelligence()<0);
				
				if(m.getIntelligence()<(mi+15)){
					System.out.println("CONTRAITE NON RESPECTEE: "+ m.getIntelligence()+"<"+(mi+15));
					detecErreur=true;
				}
				
				somme=somme-m.getIntelligence();	//correspond au nombre de points caracteristique restant à attribuer.
			} 
			
			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}
			
			if(detecErreur==false){ //Saisie CONCENTRATION
				do{
					System.out.println("Nombre de points caracteristique à attribuer: "+somme);
					System.out.println("Saisissez la valeur de la concentration de " + m.getNom());
					saisie=sc.nextLine();
					try{
						m.setConcentration(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.");
						detecErreur=true;
					}
					if(m.getConcentration()<0)
						System.out.println("La concentration ne peut être une valeur négative.");
				}while(m.getConcentration()<0);
				
				if(m.getConcentration()<(mi+15)){
					System.out.println("CONTRAITE NON RESPECTEE: "+ m.getConcentration()+"<"+(mi+15));
					detecErreur=true;
				}
				
				somme=somme-m.getConcentration();	//correspond au nombre de points caracteristique restant à attribuer.
			}
			
			if(somme>0 && detecErreur==false)
				System.out.println("ERREUR: Tout les points n'ont pas été attribués.");
			if(somme<0 && detecErreur==false)
				System.out.println("ERREUR: Trop de points ont été attribués.");
			
			m.setVitalite(200-(m.getForce()+m.getDexterite()+m.getIntelligence()+m.getConcentration())+(m.getExperience()*3));
	
			
		}while(somme != 0 
				|| ((m.getForce()
					+m.getDexterite()
					+m.getIntelligence()
					+m.getConcentration())>100+m.getExperience())
				
				|| m.getIntelligence()<mi
				|| m.getConcentration()<mc
				
				|| detecErreur==true
				);
		System.out.println("\nCONTRAINTES REMPLIES \n\nPERSONNAGE CREE\n\n\n");
		return m;
	}


	public String toString() {
		String s = this.type+" " + this.getNom()  + ":"
		+ "\nForce: " + this.getForce()
		+ "\nDexterite: " + this.getDexterite()
		+ "\nIntelligence: " + this.getIntelligence() 
		+ "\nConcentration: " + this.getConcentration() 
		+ "\nVitalite: " + this.getVitalite()
		+ "\nExperience: " + this.getExperience() + "\n";
		
		String a="";
		for(int i=0;i<this.technique.length;i++)
		{
			if(this.technique[i]!=null)
				a=a+"Capacite "+(i+1)+" = "+this.technique[i]+"\n";
		}
		return s+a;
	}

	



}


