package gateway;

import api.SmsDriver;
import gateway.migration.MigrationRunner;


public class Main {
    public static void main(String[] args) {
        try {
            SmsDriver driver = DriverFactory.createDriver();
            SmsGateway gateway = new SmsGateway(driver);

            String number = "09120000000";
            String message = "Test with Module";

            gateway.send(number, message);

            DbServices db = new DbServices();
            db.Connect();
            MigrationRunner migrator = new MigrationRunner(db.getConnection());
            migrator.run();
            db.saveMessage(number, message);
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
