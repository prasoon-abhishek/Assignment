import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionToOracle {

	void establishConnection() throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("connecting to database");
		Thread.sleep(1000);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "HR", "hr");
		System.out.println("connected to database successfully.");
		Thread.sleep(1000);
		PreparedStatement ps = con.prepareStatement("insert into REGISTRATION values(?,?)");
		ps.setString(1, Registration.name);
		ps.setString(2, Registration.password);
		int res = ps.executeUpdate();
		if (res == 0) {
			System.out.println("not inserted");
		} else {
			System.out.println("inserted");
		}
		ps.close();
		con.close();

	}

}
