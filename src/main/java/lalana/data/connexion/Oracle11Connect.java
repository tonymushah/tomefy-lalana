package lalana.data.connexion;

import io.github.cdimascio.dotenv.Dotenv;
import mg.tonymushah.dbconnection.Oracle11gConnect;

public class Oracle11Connect extends Oracle11gConnect {

    public Oracle11Connect(String host, int port, String dbName,
            String username, String password) {
        super("jdbc", "oracle", "thin", host, port, dbName, username, password);
    }

    public Oracle11Connect(Dotenv dotenv) {
        this(dotenv.get("ORACLE_HOST"), Integer.parseInt(dotenv.get("ORACLE_PORT")),
                dotenv.get("ORACLE_DB_NAME"), dotenv.get("ORACLE_DB_USER"),
                dotenv.get("ORACLE_DB_PASSWORD"));
    }
    // CONNEXTION sur l'info de la route
}
