import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.net.*;
public class MD5 { 
	public static String getMd5(String input) 
	{ 
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		}
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	}
	public static void main(String args[]) throws Exception 
	{
        File file = new File("./MD5sums"); 
  
  		BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  		String st; 
  		while ((st = br.readLine()) != null){
			
			String[] array=st.split("\t-\t", -2);
			if(getMd5(array[0]).equals(array[1])){
				System.out.println("verified");
			}
			else{
				System.out.println("not verified");
			}
		}
			
		br.close();
  	}
}
