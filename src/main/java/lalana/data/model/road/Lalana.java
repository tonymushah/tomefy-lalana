package lalana.data.model.road;

import java.util.Vector;

import mg.tonymushah.dbconnection.DBConnect;
import mg.tonymushah.dbconnection.utils.Predicate;
import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

@Table(name = "lalana")
public class Lalana implements TablesActions {
	@PrimaryKey
	@Column(name = "id", isNumber = true)
	private int id;
	@Column(name = "nom")
	private String nom;

	@Column(name = "pointArrivee", isNumber = true)
	private int pointArrivee;
	@Column(name = "pointDepart", isNumber = true)
	private int pointDepart;

	@Column(name = "largeur", isNumber = true)
	private double largeurADoubleSens; // largeur à double sens

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointArrivee() {
		return pointArrivee;
	}

	public void setPointArrivee(int pointArrivee) {
		this.pointArrivee = pointArrivee;
	}

	public int getPointDepart() {
		return pointDepart;
	}

	public void setPointDepart(int pointDepart) {
		this.pointDepart = pointDepart;
	}

	public double getLargeurADoubleSens() {
		return largeurADoubleSens;
	}

	public void setLargeurADoubleSens(double largeurADoubleSens) {
		this.largeurADoubleSens = largeurADoubleSens;
	}

	// FONCTION à faire :
	// [x] insert :
	// TODO find :
	// [x] delete :
	// [x] update :

	public Lalana() {
	}

	public Lalana(int id, String nom, int pointArrivee, int pointDepart, double largeurADoubleSens) {
		this.setId(id);
		this.setNom(nom);
		this.setPointArrivee(pointArrivee);
		this.setPointDepart(pointDepart);
		this.setLargeurADoubleSens(largeurADoubleSens);
	}

	public static Lalana[] findAll(DBConnect connect) throws Exception {
		return connect.select(Lalana.class);
	}

	public static Lalana findById(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(Lalana.class, null, new Predicate[] {
				new Predicate("id", String.valueOf(id), "and", false)
		})[0];
	}

	public Point getPointDepart(DBConnect connect) throws Exception {
		return Point.findByID(connect, this.getPointDepart());
	}

	public Point getPointArrivee(DBConnect connect) throws Exception {
		return Point.findByID(connect, this.getPointArrivee());
	}

	public double distance(DBConnect connect) throws Exception {
		return this.getPointDepart(connect).distance(this.getPointArrivee(connect));
	}

	public Vector<Lalana> getSousLalana(DBConnect connect) {
		throw new UnsupportedOperationException("not yet supported");
	}
}
