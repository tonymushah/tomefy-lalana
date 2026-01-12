package lalana.model.road;

import mg.tonymushah.dbconnection.DBConnect;
import mg.tonymushah.dbconnection.utils.Predicate;
import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

@Table(name = "tablepoint")
public class Point implements TablesActions {
	@PrimaryKey
	@Column(name = "id", isNumber = true)
	int id;
	@Column(name = "x", isNumber = true)
	double x;
	@Column(name = "y", isNumber = true)
	double y;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point() {
	}

	public Point(int id, double x, double y) {
		this.setId(id);
		this.setX(x);
		this.setY(y);
	}

	// FONCTION à faire :
	// TODO insert :
	// TODO find :
	// TODO delete :
	// TODO update :

	public static Point[] findAll(DBConnect connect) throws Exception {
		return connect.select(Point.class);
	}

	public static Point findByID(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(Point.class, null,
				new Predicate[] { new Predicate("id", String.valueOf(id), "and", false) })[0];
	}
}
