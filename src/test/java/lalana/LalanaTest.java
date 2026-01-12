package lalana;

import org.junit.Test;

import io.github.cdimascio.dotenv.Dotenv;
import lalana.data.connexion.Oracle11Connect;
import lalana.data.connexion.PostgresConnect;
import mg.tonymushah.dbconnection.DBConnect;

public class LalanaTest {

	@Test
	public void testOracleConnect() {
		try (DBConnect connect = new Oracle11Connect(Dotenv.load())) {
			connect.connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void testPsqlConnect() {
		try (DBConnect connect = new PostgresConnect(Dotenv.load())) {
			connect.connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
