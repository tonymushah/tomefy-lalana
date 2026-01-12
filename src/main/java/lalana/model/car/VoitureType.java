package lalana.model.car;

import mg.tonymushah.dbconnection.DBConnect;
import mg.tonymushah.dbconnection.utils.Predicate;
import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

@Table(name = "voiture_type")
public class VoitureType implements TablesActions {
	@PrimaryKey
	@Column(name = "id", isNumber = true)
	private int id;
	@Column(name = "libele")
	private String libele; // 4*4 na caterella ,J9 , ...

	// TODO : autre info ici

	// FONCTION à faire :
	// TODO insert :
	// TODO find :
	// TODO delete :
	// TODO update :

	public static VoitureType[] findAll(DBConnect connect) throws Exception {
		return connect.select(VoitureType.class);
	}

	public Voiture[] getVoitures(DBConnect connect) throws Exception {
		return connect.selectWhere(Voiture.class, null,
				new Predicate[] { new Predicate("idVoitureType", String.valueOf(id), "AND", false) });
	}

	public static VoitureType findById(DBConnect connect, int id) throws Exception {
		return connect.selectWhere(VoitureType.class, null,
				new Predicate[] { new Predicate("id", String.valueOf(id), "and", false) })[0];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public VoitureType() {
	}

	public VoitureType(int id, String libele) {
		this.setId(id);
		this.setLibele(libele);
	}

}
