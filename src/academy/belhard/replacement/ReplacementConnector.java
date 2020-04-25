package academy.belhard.replacement;

import academy.belhard.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplacementConnector {

    private static final String SELECT_ALL = "SELECT*FROM replacement ORDER BY id ASC";
    private static final String ADD = "INSERT INTO replacement(name_of_medicine,generic) VALUES (?,?) ";
    private static final String SELECT_BY_ID = "SELECT*FROM replacement WHERE id=?";
    private static final String UPDATE = "UPDATE  replacement SET name_of_medicine=?,generic=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM  replacement  WHERE id=? ";

    public static void showAllReplacement() throws SQLException {
        List<Replacement> result = ReplacementConnector.getAll();
        for (Replacement replacement : result) {
            System.out.println(replacement);
        }

        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static List<Replacement> getAll() throws SQLException {
        List<Replacement> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Replacement replacement = ReplacementUtil.toObject(resultSet);
                result.add(replacement);
            }
        }
        return result;
    }

    public static void add(Replacement replacement) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD);

        ) {


           String nameOfMedicine= replacement.getNameOfMedicine();
           String generic=replacement.getGeneric();

            statement.setString(1, nameOfMedicine);
            statement.setString(2, generic);

            statement.executeUpdate();

        }


    }

    public static Replacement getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);

        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Replacement replacement = ReplacementUtil.toObject(resultSet);
            resultSet.close();
            return replacement;

        }

    }




    public static void update(Replacement replacement) throws SQLException {

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE);

        ) {

            statement.setString(1, replacement.getNameOfMedicine());
            statement.setString(2, replacement.getGeneric());
            statement.setInt(3, replacement.getId());

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



