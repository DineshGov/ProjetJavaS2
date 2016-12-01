package mmorpg;
/**
 * 
 * Cette classe est la capacite Sort de soin. Elle permet aux chasseurs et aux mages de se soigner.
 * Sa probabilite de reussite depend de l'intelligence du combattant
 * et son efficacite depend de la concentration du combattant.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public class SortDeSoin extends Sort {

	private static String nom="Sortdesoin";
	private float effAtt;
	private float pbaAtt;
	private float effDef;
	private float pbaDef;
	private static float pui = 70.0f;
	private static float fac = 30.0f;
	/**
	 * Attribut servant a connaitre l'utilite offensive de la capacite.
	 */
	public static boolean CategorieATT = false;
	/**
	 * Attribut servant a connaitre l'utilite defensive de la capacite.
	 */
	public static boolean CategorieDEF = false;
	/**
	 * Attribut servant a connaitre l'utilite curative de la capacite.
	 */
	public static boolean CategorieSOIN = true;
	
	public SortDeSoin() {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = 0;
		this.effDef = 0;
	}

	public SortDeSoin(int intelligence, int concentration) {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = intelligence * fac / 10000;
		this.effDef = concentration * pui / 100;
	}

	public String getNom(){
		return SortDeSoin.nom;
	}
	
	public boolean getCategorieAtt() {
		return false;
	}

	public boolean getCategorieDef() {
		return false;
	}
	
	public boolean getCategorieSoi() {
		return true;
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
		return SortDeSoin.nom
				+"\n	Probabilité de réussite: " + this.pbaDef 
				+"\n	Efficacité: " + this.effDef
				+"\n	Puissance: " + SortDeSoin.pui 
				+"\n	Facilite: " + SortDeSoin.fac;
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
		return SortDeSoin.nom
				+"\n	Probabilités et Efficacités réduite d'un quart!"
				+"\n	Probabilité de réussite: " + this.pbaDef *0.75
				+"\n	Efficacité: " + this.effDef*0.75
				+"\n	Puissance: " + SortDeSoin.pui 
				+"\n	Facilite: " + SortDeSoin.fac;
	}
	
}


