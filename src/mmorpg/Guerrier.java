package mmorpg;

import java.util.Scanner;

/**
 * 
 * Classe Guerrier.
 * Elle permer d'instancier un guerrier en fonction des criteres 
 * du cahier des charges.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */


public class Guerrier extends Combattant{
	private String type="Guerrier";

	public Guerrier() {
		super();
		this.setTypeCombattant("guerrier");
	}

	public Guerrier(String nom, int f, int d, int i, int c, int e, int v, String type ,int tailleTab) {
		super(nom, f, d, i, c, e, v, "guerrier",tailleTab);
	}

	/**
	 * 
	 * Instancie un guerrier qui sera attribue a un Combattant grace au polymorphisme.
	 * Ce guerrier repond a tout les criteres du cahier des charges grace
	 * a l'attribution controle des points de caracteristique.
	 * 
	 * @return Le guerrier instancie lors de l'appel de cette methode.
	 */
	
	public static Guerrier creerGuerrier(){

		Guerrier g=new Guerrier();
		@SuppressWarnings("resource") // ligne générée par eclipse pour eteindre warning Scanner sc car non fermé
		Scanner sc=new Scanner(System.in);
		int somme=101; //correspond au nombre de points caracteristique total a attribuer.
		boolean detecErreur= false;
		System.out.println("Saisissez le nom de votre Guerrier");
		g.setNom(sc.nextLine());

		String saisie="";

		do{
			detecErreur=false;
			somme=101;
			g.setExperience(1);

			System.out.println("\nSaisie des caractéristique de "+ g.getNom() +":\n"
					+"\nSaisissez une lettre au cours de la saisie des attributs pour la recommencer.\n"
					+"Un guerrier est un combattant qui brille plus par sa force physique que par son intelligence."
					+"Les contraintes suivantes sont imposées à tous les guerriers:\n"
					+"\nCONTRAINTES: FOR >= (DEX + 10) >= (INT + 10) >= CON\n");


			do{ //Saisie FORCE
				detecErreur=false;
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("\nSaisissez la valeur de la force de " + g.getNom());
				saisie=sc.nextLine();
				try{
					g.setForce(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
				}
				catch(Exception e){
					System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début\n\n\n.");
					detecErreur=true;
				}

				if(g.getForce()<10){
					System.out.println("La force ne peut être inférieure à 10.");
					detecErreur=true;
				}

			}while(detecErreur==true);
			somme=somme-g.getForce();	//correspond au nombre de points caracteristique restant a attribuer.

			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}


			if(detecErreur==false){ //Saisie DEXTERITE
				System.out.println("\nCONTRAINTE: " +g.getForce() + " >= (DEX + 10) >= (INT + 10) >= CON");
				if(somme<g.getForce())
					System.out.println("DEX maximale: " + somme);
				else
					System.out.println("DEX maximale: " + (g.getForce()-10));
				do{
					System.out.println("\nNombre de points caracteristique à attribuer: "+somme);
					System.out.println("\nSaisissez la valeur de la dexterite de " + g.getNom());
					saisie=sc.nextLine();
					try{
						g.setDexterite(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
						detecErreur=true;
					}
					if(g.getDexterite()<0)
						System.out.println("La dexterité ne peut être une valeur négative.");
				}while(g.getDexterite()<0);
				somme=somme-g.getDexterite();	//correspond au nombre de points caracteristique restant a attribuer.
			}

			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}

			if(g.getForce()<g.getDexterite()+10 && detecErreur==false){
				System.out.println("ERREUR: Contrainte non respectée.\n"+ g.getForce()+"<"+g.getDexterite()+"+10");
				detecErreur=true;
			}


			if(detecErreur==false){ //Saisie INTELLIGENCE
				System.out.println("\nCONTRAINTE: " +g.getForce() + " >= ("+g.getDexterite() +"+ 10) >= (INT + 10) >= CON");
				if(somme<g.getDexterite())
					System.out.println("INT maximale: " + somme);
				else
					System.out.println("INT maximale: " + g.getDexterite());
				do{
					System.out.println("\nNombre de points caracteristique à attribuer: "+somme);
					System.out.println("\nSaisissez la valeur de l'intelligence de " + g.getNom());
					saisie=sc.nextLine();
					try{
						g.setIntelligence(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
						detecErreur=true;
					}
					if(g.getIntelligence()<0)
						System.out.println("L'intelligence ne peut être une valeur négative.");
				}while(g.getIntelligence()<0);
				somme=somme-g.getIntelligence();	//correspond au nombre de points caracteristique restant a attribuer.
			} 

			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("Nombre de points caracteristique à attribuer: "+somme);
				System.out.println("ERREUR: Trop de points ont été attribués.");
				detecErreur=true;
			}

			if(g.getDexterite()+10<g.getIntelligence()+10 && detecErreur==false){
				System.out.println("ERREUR: Contrainte non respectée.\nDEX="+g.getDexterite()+"\nINT="+g.getIntelligence()+"\nDEX+10<INT+10");
				detecErreur=true;
			}


			if(detecErreur==false){ //Saisie CONCENTRATION
				System.out.println("\nCONTRAINTE: " +g.getForce() + " >= ("+g.getDexterite() +"+ 10) >= ("+ g.getIntelligence() +"+ 10) >= CON");
				if(somme<(g.getIntelligence()+10))
					System.out.println("CON maximale: " + somme);
				else
					System.out.println("CON maximale: " + (g.getIntelligence()+10));
				do{
					System.out.println("\nNombre de points caracteristique à attribuer: "+somme);
					System.out.println("\nSaisissez la valeur de la concentration de " + g.getNom());
					saisie=sc.nextLine();
					try{
						g.setConcentration(Integer.parseInt(saisie));	//Saisie des int sous forme de String puis conversion: facile le controle et la saisie.
					}
					catch(Exception e){
						System.out.println("ERREUR: Saisie erronée. Veuillez réessayer depuis le début.\n\n\n");
						detecErreur=true;
					}
					if(g.getConcentration()<0)
						System.out.println("La concentration ne peut être une valeur négative.");
				}while(g.getConcentration()<0);
				somme=somme-g.getConcentration();	//correspond au nombre de points caracteristique restant a attribuer.
			}

			if(g.getIntelligence()+10<g.getConcentration() && detecErreur==false){
				System.out.println("ERREUR: Contrainte non respectée.\nINT="+g.getIntelligence()+"\nCON="+g.getConcentration()+"\nINT+10<CON");
				detecErreur=true;
			}


			if(somme>0 && detecErreur == false){ //verifie somme
				System.out.println("ERREUR: Tout les points n'ont pas été attribués.");}
			if(somme<0 && detecErreur==false){ //verifie somme
				System.out.println("ERREUR: Trop de points ont été attribués.");}

			g.setVitalite(200-(g.getForce()+g.getDexterite()+g.getIntelligence()+g.getConcentration())+(g.getExperience()*3));

		}while(somme != 0 
				|| ((g.getForce()
						+g.getDexterite()
						+g.getIntelligence()
						+g.getConcentration())>100+g.getExperience())

				|| (g.getForce()<g.getDexterite()+10)
				|| (g.getForce()<g.getIntelligence()+10)
				|| (g.getForce()<g.getConcentration())
				|| (g.getDexterite()+10<g.getIntelligence()+10)
				|| (g.getDexterite()+10<g.getConcentration())
				|| (10+g.getIntelligence()<g.getConcentration())
				|| detecErreur==true
				);
		System.out.println("\nCONTRAINTES REMPLIES \n\nPERSONNAGE CREE\n\n\n");
		return g;
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





