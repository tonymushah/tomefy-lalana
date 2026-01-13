package lalana.data.model.road;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.Vector;

import lalana.data.model.car.Voiture;
import lalana.data.model.road.lalana.CorrespondanceMapping;
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

	public double getLargeurAUnSens() {
		return this.getLargeurADoubleSens() / 2;
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

	// TODO implement this thingy. I dunno how it works lol
	public List<Lalana> getSousLalana(DBConnect connect) throws Exception {

		CorrespondanceMapping[] correspondance = connect.selectWhere(CorrespondanceMapping.class, null,
				new Predicate[] { new Predicate("idLalanaMere", String.valueOf(this.getId()), "and", false) });

		TreeMap<Integer, Lalana> c = new TreeMap<>();
		// Je ne sais pas si ca marche avec des routes embranche

		for (CorrespondanceMapping lalana : correspondance) {
			c.put(lalana.getOrd(), Lalana.findById(connect, lalana.getLalanaFille()));
		}
		return new Vector<>(c.values());
	}

	// Je ne sais pas si tokony `List<Lalana>` sa `Optional<Lalana>` no atao eto
	public Optional<Lalana> getLalanaMere(DBConnect connect) throws Exception {
		CorrespondanceMapping[] correspondances = connect.selectWhere(CorrespondanceMapping.class, null,
				new Predicate[] { new Predicate("idLalanaFille", String.valueOf(this.getId()), "and", false) });
		if (correspondances.length == 0) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(Lalana.findById(connect, correspondances[0].getLalanaMere()));
		}
	}

	public List<Lalana> getSousLalanaIfHaveMere(DBConnect connect) throws Exception {
		Optional<Lalana> lalanaMere = this.getLalanaMere(connect);
		if (lalanaMere.isPresent()) {
			return lalanaMere.get().getSousLalana(connect);
		} else {
			return this.getSousLalana(connect);
		}
	}

	public LalanaObstacle[] getObstacles(DBConnect connect) throws Exception {
		return connect.selectWhere(LalanaObstacle.class, null, new Predicate[] {
				new Predicate("idLalanaMere", String.valueOf(this.getId()), "and", false)
		});
	}

	public double tempsVoiture(DBConnect connect, double vitesseMoyenne) throws Exception {
		return this.distance(connect) / vitesseMoyenne;
	}
}
