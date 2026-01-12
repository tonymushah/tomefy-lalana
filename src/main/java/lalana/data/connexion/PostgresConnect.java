package lalana.data.connexion;

import io.github.cdimascio.dotenv.Dotenv;
import mg.tonymushah.dbconnection.PostGresConnect;

public class PostgresConnect extends PostGresConnect {

	public PostgresConnect(String host, int port, String dbName, String username, String password) {
		super(host, port, dbName, username, password);
		// TODO Auto-generated constructor stub
	}

	public PostgresConnect(Dotenv dotenv) {
		this(dotenv.get("POSTGRES_HOST"), Integer.parseInt(dotenv.get("POSTGRES_PORT")), dotenv.get("POSTGRES_DB_NAME"),
				dotenv.get("POSTGRES_USERNAME"), dotenv.get("POSTGRES_PASSWORD"));
	}
	// CONNEXTION sur l'info de la voiture

}
