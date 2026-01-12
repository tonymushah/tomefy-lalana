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
	int id;
	@Column(name = "libele")
	String libele; // 4*4 na caterella ,J9 , ...

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

}
