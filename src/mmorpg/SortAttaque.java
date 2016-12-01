package mmorpg;
/**
 * 
 * Cette classe est la capacite Sort d'attaque. Elle permet aux combattant d'attaquer.
 * Sa probabilite de reussite depend de l'intelligence du combattant
 * et son efficacite depend de la concentration du combattant.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public class SortAttaque extends Sort {

	private static String nom="Sortd'attaque";
	private float effAtt;
	private float pbaAtt;
	private float effDef;
	private float pbaDef;
	private static float pui = 65.0f;
	private static float fac = 35.0f;
	/**
	 * Attribut servant a connaitre l'utilite offensive de la capacite.
	 */
	public static boolean CategorieATT = true;
	/**
	 * Attribut servant a connaitre l'utilite defensive de la capacite.
	 */
	public static boolean CategorieDEF = false;
	/**
	 * Attribut servant a connaitre l'utilite curative de la capacite.
	 */
	public static boolean CategorieSOIN = false;
	
	public SortAttaque() {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = 0;
		this.effDef = 0;
	}

	public SortAttaque(int intelligence, int concentration) {
		this.pbaAtt = intelligence * fac / 10000;
		this.effAtt = concentration * pui / 100;
		this.pbaDef = 0;
		this.effDef = 0;
	}

	public String getNom(){
		return SortAttaque.nom;
	}
	
	public boolean getCategorieAtt() {
		return true;
	}

	public boolean getCategorieDef() {
		return false;
	}
	
	public boolean getCategorieSoi() {
		return false;
	}
	
	public float getEffAtt(){
		return this.effAtt;
	}
	
	public float getPbaAtt(){
		return this.pbaAtt;
	}
	
	public float getEffDef(){
		return this.effDef;
	}
	
	public float getPbaDef(){
		return this.pbaDef;
	}
	
	public void setEffAtt(float eff){
		this.effAtt=eff;
	}
	
	public void setPbaAtt(float pba){
		this.pbaAtt=pba;
	}
	
	public void setEffDef(float eff){
		this.effDef=eff;
	}
	
	public void setPbaDef(float pba){
		this.pbaDef=pba;
	}
	
	public String toString() {
		return SortAttaque.nom
				+"\n	Probabilité de réussite: " + this.pbaAtt 
				+"\n	Efficacité: " + this.effAtt
				+"\n	Puissance: " + SortAttaque.pui 
				+"\n	Facilite: " + SortAttaque.fac;
	}

	/**
	 * 
	 * Cette methode est identique au toString mais elle affiche les probabilites et efficacites
	 * de la capacite reduites d'un quart par rapport aux statistiques initiale.
	 * 
	 * 
	 * @return Les statistiques de la capacite reduite d'un quart par rapport aux statistiques initiales.
	 * 
	 */
	
	public String afficheCapaciteAvecCoeffReduit() {
		return SortAttaque.nom
				+"\n	Probabilités et Efficacités réduite d'un quart!"
				+"\n	Probabilité de réussite: " + this.pbaAtt*0.75 
				+"\n	Efficacité: " + this.effAtt*0.75
				+"\n	Puissance: " + SortAttaque.pui 
				+"\n	Facilite: " + SortAttaque.fac;
	}
	
}

