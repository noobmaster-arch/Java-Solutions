public class Vehicle{

    // enum status
    // {
    //     pass="PASS",
    //     fail="FAIL",
    //     pending="PENDING",
    // }

    private String regNo;
    private String manufacturer;
    private String owner;
    protected double co2;
    protected double co;
    protected double hc;
    protected String pollutionStatus="PENDING";

    public Vehicle(String nregNo, String nmanufacturer, String nowner){
        regNo= nregNo;
        manufacturer= nmanufacturer;
        owner= nowner;
        co2=-1;
        co=-1;
        hc=-1;
    }

    public void insertvalues(String nco2, String nco, String nhc){
        co2=Double.parseDouble(nco2);
        co=Double.parseDouble(nco);
        hc=Double.parseDouble(nhc);    
    }

    public void checkPollutionStatus(){}

    public String toString(){
        return "Reg No:"+regNo+"\n"
                + "Manufacturer:"+manufacturer+"\n"
                + "Owner:"+owner+"\n"
                + "Pollution Status:"+pollutionStatus;
    }


}