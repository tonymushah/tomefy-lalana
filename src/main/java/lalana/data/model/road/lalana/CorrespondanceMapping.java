package lalana.data.model.road.lalana;

import mg.tonymushah.dbconnection.utils.annotations.Column;
import mg.tonymushah.dbconnection.utils.annotations.PrimaryKey;
import mg.tonymushah.dbconnection.utils.annotations.Table;
import mg.tonymushah.dbconnection.utils.interfaces.TablesActions;

// TODO
@Table(name = "sous_lalana_correspondance")
public class CorrespondanceMapping implements TablesActions {
	@PrimaryKey
	@Column(name = "id", isNumber = true)
	private int id;

	@Column(name = "idLalanaMere", isNumber = true)
	private Integer lalanaMere;
	@Column(name = "idLalanaFille", isNumber = true)
	private Integer lalanaFille;
	@Column(name = "idOrdApparation", isNumber = true)
	private int ord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLalanaMere() {
		return lalanaMere;
	}

	public void setLalanaMere(Integer lalanaMere) {
		this.lalanaMere = lalanaMere;
	}

	public Integer getLalanaFille() {
		return lalanaFille;
	}

	public void setLalanaFille(Integer lalanaFille) {
		this.lalanaFille = lalanaFille;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public CorrespondanceMapping(int id, Integer lalanaMere, Integer lalanaFille, int ord) {
		this.setId(id);
		this.setLalanaMere(lalanaMere);
		this.setLalanaFille(lalanaFille);
		this.setOrd(ord);
	}

	public CorrespondanceMapping() {
	}

}
