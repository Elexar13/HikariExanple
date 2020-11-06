package dao;

import com.zaxxer.hikari.HikariDataSource;
import data.MyDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entities.Driver;

public class DriverDAO {

    HikariDataSource dataSource = MyDataSource.getDataSource();

    public List<Driver> getDrivers(){
        List<Driver> drivers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from driver");
            ResultSet rs = ps.executeQuery();
            connection.close();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int truck_id = rs.getInt("id");
                System.out.println(id + " " + name + " " + truck_id);
                drivers.add(new Driver(id, name, truck_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return drivers;
    }

    public void addDriver(Driver driver) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into driver (name, truck_id) values(?, ?);");
            ps.setString(1, driver.getName());
            ps.setInt(2, driver.getTruckId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
