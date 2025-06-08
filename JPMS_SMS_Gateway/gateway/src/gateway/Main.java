package gateway;

import api.SmsDriver;

public class Main {
    public static void main(String[] args) {
        SmsDriver driver = DriverFactory.createDriver();
        SmsGateway gateway = new SmsGateway(driver);
        gateway.send("09120478162", "Test with Module");
    }
}
