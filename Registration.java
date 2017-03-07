import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
	static String name;
	static String password;
	static ArrayList userName = new ArrayList();
	static ArrayList passWord = new ArrayList();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Registration obj = new Registration();
		obj.registerYourself();
		ConnectionToOracle cObj = new ConnectionToOracle();
		cObj.establishConnection();
	}

	void registerYourself() throws InterruptedException {
		System.out.println("Register to proceed...");
		Thread.sleep(1000);
		System.out.println("enter username: ");
		Scanner scan = new Scanner(System.in);
		name = scan.next();
		System.out.println("enter password: ");
		password = scan.next();

		userName.add(name);
		passWord.add(password);

		// System.out.println(userDetails);
	}
}
