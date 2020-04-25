package academy.belhard.medicine;

import academy.belhard.util.DbConnector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineConnector {
    private static final String SELECT_ALL = "SELECT*FROM medicine ORDER BY id ASC";
    private static final String ADD = "INSERT INTO medicine( name_of_medicine, inn, farm_group, replacement_id) VALUES (?,?,?,?) ";
    private static final String SELECT_BY_ID = "SELECT*FROM medicine WHERE id=?";
    private static final String UPDATE = "UPDATE  medicine SET name_of_medicine=?,inn=?, farm_group=?, replacement_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM  medicine  WHERE id=? ";

    public static void showAllMedicine() throws SQLException {
        List<Medicine> result = MedicineConnector.getAll();
        for (Medicine medicine : result) {
            System.out.println(medicine);
        }

        System.out.println();
        System.out.println();
        System.out.println();

    }


    public static List<Medicine> getAll() throws SQLException {
        List<Medicine> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Medicine medicine = MedicineUtil.toObject(resultSet);
                result.add(medicine);
            }
        }
        return result;
    }

    public static void add(Medicine medicine) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD);

        ) {

            String nameOfMedicine  = medicine.getNameOfMedicine();
            String inn = medicine.getInn();
            String farmGroup = medicine.getFarmGroup();
            int replacementId = medicine.getReplacementId();


            statement.setString(1, nameOfMedicine);
            statement.setString(2, inn);
            statement.setString(3, farmGroup);
            statement.setInt(4, replacementId);


            statement.executeUpdate();

        }

    }

    public static Medicine getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);

        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Medicine medicine = MedicineUtil.toObject(resultSet);
            resultSet.close();
            return medicine;

        }
    }

    public static void update(Medicine medicine) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE);

        ) {

            statement.setString(1, medicine.getNameOfMedicine());
            statement.setString(2, medicine.getInn());
            statement.setString(3, medicine.getFarmGroup());
            statement.setInt(4, medicine.getReplacementId());
            statement.setInt(5, medicine.getId());

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

