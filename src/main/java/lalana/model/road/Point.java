package lalana.model.road;

import javafx.geometry.Point2D;
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
	private int id;
	@Column(name = "x", isNumber = true)
	private double x;
	@Column(name = "y", isNumber = true)
	private double y;

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
	// [x] insert :
	// [x] find :
	// [x] delete :
	// [x] update :

	public static Point[] findAll(DBConnect connect) throws Exception {
		return connect.select(Point.class);
	}

	public static Point findByID(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(Point.class, null,
				new Predicate[] { new Predicate("id", String.valueOf(id), "and", false) })[0];
	}

	/**
	 * 
	 * NOTE: If `point` is null, it will calcute to the origin point (0, 0) instead.
	 * 
	 * @param point
	 * @return distance to between `this` and the `point` parameter
	 * 
	 */
	public double distance(Point point) {
		if (point == null) {
			point = new Point();
		}
		return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2));
	}

	public Point2D toPoint2d() {
		return new Point2D(this.getX(), this.getY());
	}
}
