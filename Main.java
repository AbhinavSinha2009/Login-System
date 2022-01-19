import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
		
public class LoginPage {
    
    
    public static void main(String[] args) throws IOException{
    	userProcess();
    }
    public static void createAccount() throws IOException {
		FileWriter accountMaker = new FileWriter("C:\\Users\\abhin\\eclipse-workspace\\Java\\src\\"
                + "main\\java\\UserInfo.txt");
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Create your account today!\n");
    	System.out.print("Create username: ");
    	String username = sc.nextLine();
    	accountMaker.write(username);
    	System.out.print("\nCreate password: ");
    	String password = sc.nextLine();
    	accountMaker.write(", " + password);
    	accountMaker.close();
    }
    public static void loginCheck() throws IOException {
        File UserInfo = new File("C:\\Users\\abhin\\eclipse-workspace\\Java\\src\\"
                 + "main\\java\\UserInfo.txt"); // enter username, password in 
         try (Scanner sc = new Scanner(System.in)) {
			try (Scanner scFile = new Scanner(UserInfo)) {
				HashMap<String, String> map = new HashMap<String, String>();
				 
				 while(scFile.hasNextLine()) {
				     String[] splits = scFile.nextLine().split(", ");
				     map.put(splits[0].toLowerCase(), splits[1]);
				 }
				 System.out.print("\nNow, login\n");
				 System.out.print("\nEnter username: ");
				 String usernameInput = sc.nextLine();
				 System.out.print("\nEnter password: ");
				 String passwordInput = sc.nextLine();
				 if(passwordInput.equals(map.get(usernameInput.toLowerCase()))) {
				     System.out.println("\n"+usernameInput.toLowerCase() + ", you have successfully logged in!");
				     while(true) {
				     System.out.println("Type the keyword 'logout' to exit your account. Or type"
				     		+ "'create' to create a new account: ");
				     String input = sc.nextLine();
				     if(input.equals("create")) {
				    	 userProcess();
				      } 
				     if(input.equals("logout")) {
				    	 loginCheck();
				     }
				    }
				 } else {
				     System.out.println("\nPlease enter a valid username/password that exists.\n");
				     loginCheck();
				 }
			}
		}
     }
    public static void userProcess() throws IOException {
      	 try {
          	createAccount();
          } catch(Exception b) {
              System.out.println("\nPlease enter a valid username/password.\n");
              createAccount();
          } try {
              loginCheck();
          } catch(Exception e) {
              System.out.println("\nPlease enter a valid username/password that exists.\n");
              loginCheck();
          }
    }
}
