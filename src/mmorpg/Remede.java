package mmorpg;
/**
 * 
 * Cette classe est la capacite Remede. Elle permet aux combattants de se soigner.
 * Sa probabilite de reussite depend de la dexterite du combattant
 * et son efficacite depend de la force du combattant.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public class Remede extends Sort {

	private static String nom="Remede";
	private float effAtt;
	private float pbaAtt;
	private float effDef;
	private float pbaDef;
	private static float pui = 50.0f;
	private static float fac = 50.0f;
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
	
	public Remede() {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = 0;
		this.effDef = 0;
	}

	public Remede(int dexterite,int force) {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = dexterite*fac/10000;
		this.effDef = force*pui/100;
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
	
	public String getNom(){
		return Remede.nom;
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
		return Remede.nom
				+"\n	Probabilité de réussite: " + this.pbaDef 
				+"\n	Efficacité: " + this.effDef
				+"\n	Puissance: " + Remede.pui 
				+"\n	Facilite: " + Remede.fac;
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
		return Remede.nom
				+"\n	Probabilités et Efficacités réduite d'un quart!"
				+"\n	Probabilité de réussite: " + this.pbaDef *0.75
				+"\n	Efficacité: " + this.effDef*0.75
				+"\n	Puissance: " + Remede.pui 
				+"\n	Facilite: " + Remede.fac;
	}
	

}
