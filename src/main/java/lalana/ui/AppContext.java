package lalana.ui;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.stage.Stage;
import lalana.data.connexion.Oracle11Connect;
import lalana.data.connexion.PostgresConnect;
import mg.tonymushah.dbconnection.DBConnect;

public class AppContext implements AutoCloseable {
	private DBConnect oracle;
	private DBConnect postgres;
	private Stage mainStage;

	public DBConnect getOracle() {
		return oracle;
	}

	public DBConnect getPostgres() {
		return postgres;
	}

	public AppContext() throws Exception {
		Dotenv dotenv = Dotenv.load();
		oracle = new Oracle11Connect(dotenv);
		postgres = new PostgresConnect(dotenv);
	}

	@Override
	public void close() throws Exception {
		if (oracle != null) {
			oracle.close();
		}
		if (postgres != null) {
			postgres.close();
		}
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
}
