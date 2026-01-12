package lalana;

import static org.junit.Assert.assertNotNull;
import java.nio.file.Path;

import org.junit.Test;

import io.github.cdimascio.dotenv.Dotenv;
import lalana.data.connexion.Oracle11Connect;
import lalana.data.connexion.PostgresConnect;
import mg.tonymushah.dbconnection.DBConnect;

public class LalanaTest {

	@Test
	public void testOracleConnect() throws Exception {
		System.out.println(Path.of(".").normalize());
		assertNotNull("ORACLE_PORT_NOT_SET", Dotenv.load().get("ORACLE_PORT"));
		try (DBConnect connect = new Oracle11Connect(Dotenv.load())) {
			connect.connect();
		}
	}

	@Test
	public void testPsqlConnect() throws Exception {
		assertNotNull("POSTGRES_PORT_NOT_SET", Dotenv.load().get("POSTGRES_PORT"));
		try (DBConnect connect = new PostgresConnect(Dotenv.load())) {
			connect.connect();
		}
	}
}
