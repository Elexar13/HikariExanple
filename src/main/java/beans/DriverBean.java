package beans;

import java.io.Serializable;
import java.util.List;

import dao.DriverDAO;
import entities.Driver;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DriverBean implements Serializable {
    private Driver driver = new Driver();
    private String stringValue;
    private DriverDAO driverDAO = new DriverDAO();
    private List<Driver> drivers;

    public DriverBean() {
        drivers = new DriverDAO().getDrivers();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStringValue(){
        StringBuilder driverStringValue = new StringBuilder();
        drivers.forEach(d -> driverStringValue.append(d.toString()));
        return driverStringValue.toString();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver){
        driverDAO.addDriver(driver);
    }
}
