public class Truck extends Vehicle{
    public void checkPollutionStatus(){
            if((co2>25)||(co>0.8)||(hc>1000)){
                pollutionStatus="FAIL";
            }
            if((co2<=25)&&(co<=0.8)&&(hc<=1000)&&(co2!=-1)){
                pollutionStatus="PASS";
            }
            System.out.println(pollutionStatus);
    }

    public Truck(String regNo, String manufacturer, String owner){
        super(regNo, manufacturer, owner);
    }

}
