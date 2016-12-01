package mmorpg;
/**
 * 
 * Cette classe est la capacite Hache. Elle permet aux combattants de se defendre et surtout d'attaque.
 * Sa probabilite de reussite depend de la dexterite du combattant
 * et son efficacite depend de la force du combattant.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public class Hache extends Arme {

	private static String nom="Hache";
	private float effAtt;
	private float pbaAtt;
	private float effDef;
	private float pbaDef;
	private static float imp = 65.0f;
	private static float man = 35.0f;
	/**
	 * Attribut servant a connaitre l'utilite offensive de la capacite.
	 */
	public static boolean CategorieATT = true;
	/**
	 * Attribut servant a connaitre l'utilite defensive de la capacite.
	 */
	public static boolean CategorieDEF = true;
	/**
	 * Attribut servant a connaitre l'utilite curative de la capacite.
	 */
	public static boolean CategorieSOIN = false;

	public Hache() {
		this.pbaAtt = 0;
		this.effAtt = 0;
		this.pbaDef = 0;
		this.effDef = 0;
	}

	public Hache(int dex, int forc) {
		this.pbaAtt = dex * man / 10000;
		this.effAtt = forc * imp / 100;
		this.pbaDef = dex * man / 5000;
		this.effDef = forc * imp / 50;
	}

	public String getNom(){
		return Hache.nom;
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
		return Hache.nom
				+"\n	Probabilité de réussite d'une attaque: " + this.pbaAtt 
				+"\n	Efficacité offensive: " + this.effAtt 
				+"\n	Probabilité de réussite d'une défense: " + this.pbaDef 
				+"\n	Efficacité defensive: " + this.effDef 
				+"\n	Impact: " + Hache.imp 
				+"\n	Maniabilité: " + Hache.man;
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
		return Hache.nom
				+"\n	Probabilités et Efficacités réduite d'un quart!"
				+"\n	Probabilité de réussite d'une attaque: " + this.pbaAtt*0.75 
				+"\n	Efficacité offensive: " + this.effAtt*0.75 
				+"\n	Probabilité de réussite d'une défense: " + this.pbaDef*0.75 
				+"\n	Efficacité defensive: " + this.effDef*0.75
				+"\n	Impact: " + Hache.imp 
				+"\n	Maniabilité: " + Hache.man;
	}

	public boolean getCategorieAtt() {
		return true;
	}

	public boolean getCategorieDef() {
		return true;
	}
	
	public boolean getCategorieSoi() {
		return false;
	}
	
}
