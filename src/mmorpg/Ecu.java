package mmorpg;
/**
 * 
 * Cette classe est la capacite Ecu. Elle permet aux combattants d'attaquer et surtout de se defendre.
 * Sa probabilite de reussite depend de la dexterite du combattant
 * et son efficacite depend de la force du combattant.
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public class Ecu extends Bouclier{

		
		private static String nom="Ecu";
		private float effAtt;
		private float pbaAtt;
		private float effDef;
		private float pbaDef;
		private static float pro = 70.0f;
		private static float man = 30.0f;
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

		public Ecu() {
			this.pbaAtt = 0;
			this.effAtt = 0;
			this.pbaDef = 0;
			this.effDef = 0;
		}

		public Ecu(int dexterite, int force) {
			this.pbaAtt = dexterite * man / 5000;
			this.effAtt = force * pro / 50;
			this.pbaDef = dexterite * man / 10000;
			this.effDef = force * pro / 100;
		}

		public String getNom(){
			return Ecu.nom;
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
			return Ecu.nom
					+"\n	Probabilité de réussite d'une attaque: " + this.pbaAtt 
					+"\n	Efficacité offensive: " + this.effAtt 
					+"\n	Probabilité de réussite d'une défense: " + this.pbaDef 
					+"\n	Efficacité defensive: " + this.effDef 
					+"\n	Protection: " + Ecu.pro 
					+"\n	Maniabilité: " + Ecu.man;
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
			return Ecu.nom
					+"\n	Probabilités et Efficacités réduite d'un quart!"
					+"\n	Probabilité de réussite d'une attaque: " + this.pbaAtt*0.75 
					+"\n	Efficacité offensive: " + this.effAtt*0.75 
					+"\n	Probabilité de réussite d'une défense: " + this.pbaDef*0.75 
					+"\n	Efficacité defensive: " + this.effDef*0.75
					+"\n	Protection: " + Ecu.pro 
					+"\n	Maniabilité: " + Ecu.man;
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
