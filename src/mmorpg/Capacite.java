package mmorpg;
/**
 * 
 * Cette interface est implementee par toute les capacites.
 * Elle comprend toute les methodes qui seront redefinies dans les classes capacites
 * telles que les classes Epee, Ecu...
 * 
 * version 1.0
 * 2016
 * @author Dinesh Govindaradjane et Jeremy Dos Santos
 * 
 */
public interface Capacite {
	public String toString();
	public String afficheCapaciteAvecCoeffReduit();
	public String getNom();
	public boolean getCategorieAtt();
	public boolean getCategorieDef();
	public boolean getCategorieSoi();
	public float getEffAtt();
	public float getEffDef();
	public float getPbaAtt();
	public float getPbaDef();
	public void setEffAtt(float a);
	public void setEffDef(float a);
	public void setPbaAtt(float a);
	public void setPbaDef(float a);
}
