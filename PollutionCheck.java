import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class PollutionCheck{
    public static void main(String[] args){
        try{
            File veh = new File(args[0]);
            Scanner vehs = new Scanner(veh);
            String[] cols;
            HashMap < String,Vehicle> vehicles = new HashMap < String,Vehicle>();
            while (vehs.hasNextLine()) {
                cols= vehs.nextLine().split(", ");
                if(cols[3].equals("Car")){
                    vehicles.put(cols[0], new Car(cols[0], cols[1], cols[2]));
                }
                else if(cols[3].equals("Truck")){
                    vehicles.put(cols[0], new Truck(cols[0], cols[1], cols[2]));
                }
            }
            vehs.close();
            File pol = new File(args[1]);
            Scanner polc = new Scanner(pol);
            while(polc.hasNextLine()){
                cols=polc.nextLine().split(", ");
                vehicles.get(cols[0]).insertvalues(cols[1], cols[2], cols[3]);
            }
            polc.close();
            File qry = new File(args[2]);
            Scanner qrys = new Scanner(qry);
            String regNo, buf;
            while(qrys.hasNextLine()){
                regNo=qrys.nextLine();
                if(vehicles.containsKey(regNo)){
                    vehicles.get(regNo).checkPollutionStatus();
                    // buf=vehicles.get(regNo).toString();
                    // cols=buf.split(":");
                    //System.out.println(cols[4]);
                }
                else{
                    System.out.println("NOT REGISTERED");
                }
            }
            qrys.close();
        } catch( FileNotFoundException e){
            System.out.println("Oops! File Not Found");
        }
    }
}