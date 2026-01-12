package lalana;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.cdimascio.dotenv.Dotenv;
import lalana.data.connexion.Oracle11Connect;
import lalana.data.connexion.PostgresConnect;
import mg.tonymushah.dbconnection.DBConnect;

public class LalanaTest {

	public static Dotenv testDotenv() {
		return Dotenv.configure().load();
	}

	@Test
	public void testOracleConnect() throws Exception {
		Dotenv testDotenv = testDotenv();
		assertNotNull("ORACLE_PORT_NOT_SET", testDotenv.get("ORACLE_PORT"));
		try (DBConnect connect = new Oracle11Connect(testDotenv)) {
			connect.connect();
		}
	}

	@Test
	public void testPsqlConnect() throws Exception {
		Dotenv testDotenv = testDotenv();
		assertNotNull("POSTGRES_PORT_NOT_SET", testDotenv.get("POSTGRES_PORT"));
		try (DBConnect connect = new PostgresConnect(testDotenv)) {
			connect.connect();
		}
	}
}
