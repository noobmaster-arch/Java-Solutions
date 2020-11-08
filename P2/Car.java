

public class Car extends Vehicle{
     public void checkPollutionStatus(){
         
            if((co2>15)||(co>0.5)||(hc>750)){
            pollutionStatus="FAIL";
            }
            else if((co2<=15)&&(co<=0.5)&&(hc<=750)&&(co2!=-1)){
                pollutionStatus="PASS";
            }
            System.out.println(pollutionStatus);
    }

    public Car(String regNo, String manufacturer, String owner){
        super(regNo, manufacturer, owner);
    }

}