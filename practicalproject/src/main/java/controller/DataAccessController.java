package controller;

import model.CreateDatabaseConnection;
import model.Location;

import java.sql.*;

public class DataAccessController {

    public static boolean insertDataToLocation(Location location) {
        boolean f = false;

        try {
            Connection con = CreateDatabaseConnection.createConnection();

            String insertQuery = "INSERT INTO location(country_name, region_name, city_name, latitude, longitude) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertRecord = con.prepareStatement(insertQuery);
            insertRecord.setString(1, location.getCountryName());
            insertRecord.setString(2, location.getRegionName());
            insertRecord.setString(3, location.getCityName());
            insertRecord.setDouble(4, location.getLatitude());
            insertRecord.setDouble(5, location.getLongitude());
            insertRecord.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public static void displayLocation() {

        try {
            Connection con = CreateDatabaseConnection.createConnection();

            String displayQuery = "SELECT * FROM location";

            Statement displayStatement = con.createStatement();
            ResultSet resultSet = displayStatement.executeQuery(displayQuery);

            System.out.println("\tID\tCountry\t\tRegion\tCity\tLatitude\tLongitude");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String country = resultSet.getString(2);
                String region = resultSet.getString(3);
                String city = resultSet.getString(4);
                double latitude = resultSet.getDouble(5);
                double longitude = resultSet.getDouble(6);

                System.out.println("\t" + id + "\t" + country + "\t" + region + "\t" + city + "\t" + latitude + "\t" + longitude);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkDuplicateCity(String city_name) {
        Connection con = CreateDatabaseConnection.createConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        boolean checkCity = false;

        try {
            String strQuery = "SELECT * FROM location WHERE city_name = ?";
            preparedStatement = con.prepareStatement(strQuery);

            preparedStatement.setString(1, city_name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                checkCity = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkCity;
    }

}
