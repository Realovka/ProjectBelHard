package academy.belhard.pharmacy;


import academy.belhard.util.CurrentDateUtil;
import academy.belhard.util.DbConnector;

import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PharmacyConnector {
    private static final String SELECT_ALL = "SELECT*FROM pharmacy ORDER BY id ASC";
    private static final String ADD = "INSERT INTO pharmacy(pharmacy_name, city, address, medicine_id) VALUES (?,?,?,?) ";
    private static final String SELECT_BY_ID = "SELECT*FROM pharmacy WHERE id=?";
    private static final String UPDATE = "UPDATE  pharmacy SET pharmacy_name=?,city=?, address=?, medicine_id=?, updated_at=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM  pharmacy  WHERE id=? ";

    public static void showAllPharmacy() throws SQLException {
        List<Pharmacy> result = PharmacyConnector.getAll();
        for (Pharmacy pharmacy : result) {
            System.out.println(pharmacy);
        }

        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static List<Pharmacy> getAll() throws SQLException {
        List<Pharmacy> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Pharmacy pharmacy = PharmacyUtil.toObject(resultSet);
                result.add(pharmacy);
            }
        }
        return result;
    }

    public static void add(Pharmacy pharmacy) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD);

        ) {

            String pharmacyName = pharmacy.getPharmacyName();
            String city = pharmacy.getCity();
            String address=pharmacy.getAddress();
            int medicineId=pharmacy.getMedicineId();


            statement.setString(1, pharmacyName);
            statement.setString(2, city);
            statement.setString(3, address);
            statement.setInt(4, medicineId);

            statement.executeUpdate();

        }


    }

    public static Pharmacy getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);

        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Pharmacy pharmacy = PharmacyUtil.toObject(resultSet);
            resultSet.close();
            return pharmacy;

        }

    }

    public static void update(Pharmacy pharmacy) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE);

        ) {


            statement.setString(1, pharmacy.getPharmacyName());
            statement.setString(2, pharmacy.getCity());
            statement.setString(3, pharmacy.getAddress());
            statement.setInt(4, pharmacy.getMedicineId());
            statement.setDate(5, new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(6, pharmacy.getId());

            statement.executeUpdate();
        }
        }

        public static void deleteById(int id) throws SQLException {

            Connection connection = DbConnector.getConnection();

            try (
                    PreparedStatement statement = connection.prepareStatement(DELETE);

            ) {

                statement.setInt(1, id);

                statement.executeUpdate();

            }

    }

}
