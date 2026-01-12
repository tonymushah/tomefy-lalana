
package lalana.model.car;

import mg.tonymushah.dbconnection.DBConnect;
import mg.tonymushah.dbconnection.utils.Predicate;
import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

@Table(name = "voiture")
public class Voiture implements TablesActions {
	@Column(name = "id", isNumber = true)
	@PrimaryKey
	int id;

	@Column(name = "idVoitureType", isNumber = true)
	int type;

	@Column(name = "longueur", isNumber = true)
	double longueur;
	@Column(name = "largeur", isNumber = true)
	double largeur;
	// pour vérifier que la vitesse moyenne choisi est valide
	@Column(name = "vitesseMax", isNumber = true)
	double vitesseMax;

	public Voiture() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public Voiture(int id, int type, double longueur, double largeur, double vitesseMax) {
		this.setId(id);
		this.setType(type);
		this.setLargeur(largeur);
		this.setLongueur(longueur);
		this.setVitesseMax(vitesseMax);
	}

	// FONCTION à faire :
	// [x] insert :
	// [x] find :
	// [x] delete :
	// [x] update :

	public Voiture[] findAll(DBConnect connect) throws Exception {
		return connect.select(Voiture.class);
	}

	public Voiture findById(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(Voiture.class, null,
				new Predicate[] { new Predicate("id", String.valueOf(id), "and", false) })[0];
	}
}
