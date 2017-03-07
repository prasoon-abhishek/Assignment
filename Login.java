import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

	static ArrayList login1 = new ArrayList();
	static ArrayList login2 = new ArrayList();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter username: ");
		String u = scan.nextLine();
		System.out.println("enter password: ");
		String p = scan.nextLine();
		System.out.println("trying to login...");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "HR", "hr");
		java.sql.Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from REGISTRATION");

		// System.out.println(" U_Name\t P_Name ");
		while (rs.next()) {
			login1.add(rs.getString(1));
			login2.add(rs.getString(2));

		}Thread.sleep(1000);

		// System.out.println(login);

		if (login1.contains(u) && login2.contains(p)) {
			System.out.println("login successfull");
		} else
			System.out.println("login failed");

		stat.close();
		con.close();
	}

}
