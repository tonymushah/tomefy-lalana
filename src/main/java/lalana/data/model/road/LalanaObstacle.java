package lalana.data.model.road;

import mg.tonymushah.dbconnection.DBConnect;
import mg.tonymushah.dbconnection.utils.Predicate;
import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

@Table(name = "obstacle")
public class LalanaObstacle implements TablesActions {
	@PrimaryKey
	@Column(name = "id", isNumber = true)
	private int id;
	@Column(name = "idLalanaMere", isNumber = true)
	private int idLalanaMere;

	@Column(name = "pourcentageReduction", isNumber = true)
	private double pourcentageReduction;

	@Column(name = "distanceArrivee", isNumber = true)
	private double distanceArrivee;
	@Column(name = "distanceDepart")
	private double distanceDepart;

	// FONCTION à faire :
	// [x] insert :
	// [x] find :
	// [x] delete :
	// [x] update :

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLalanaMere() {
		return idLalanaMere;
	}

	public void setIdLalanaMere(int idLalanaMere) {
		this.idLalanaMere = idLalanaMere;
	}

	public double getPourcentageReduction() {
		return pourcentageReduction;
	}

	public void setPourcentageReduction(double pourcentageReduction) {
		this.pourcentageReduction = pourcentageReduction;
	}

	public double getDistanceArrivee() {
		return distanceArrivee;
	}

	public void setDistanceArrivee(double distanceArrivee) {
		this.distanceArrivee = distanceArrivee;
	}

	public double getDistanceDepart() {
		return distanceDepart;
	}

	public void setDistanceDepart(double distanceDepart) {
		this.distanceDepart = distanceDepart;
	}

	public LalanaObstacle() {
	}

	public LalanaObstacle(int id, int idLalanaMere, double pourcentageReduction, double distanceArrivee,
			double distanceDepart) {
		this.setId(idLalanaMere);
		this.setIdLalanaMere(idLalanaMere);
		this.setPourcentageReduction(pourcentageReduction);
		this.setDistanceArrivee(distanceArrivee);
		this.setDistanceDepart(distanceDepart);
	}

	public static LalanaObstacle[] findAll(DBConnect connect) throws Exception {
		return connect.select(LalanaObstacle.class);
	}

	public static LalanaObstacle findById(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(LalanaObstacle.class, null, new Predicate[] {
				new Predicate("id", String.valueOf(id), "and", false)
		})[0];
	}

	public Lalana getLalanaMere(DBConnect connect) throws Exception {
		return Lalana.findById(connect, this.getIdLalanaMere());
	}
}
