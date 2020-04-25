package academy.belhard.medicine;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineUtil {
    public static Medicine toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nameOfMedicine = resultSet.getString("name_of_medicine");
        String inn = resultSet.getString("inn");
        String farmGroup = resultSet.getString("farm_group");
        int replacementId = resultSet.getInt("replacement_id");

        return new Medicine (id, nameOfMedicine, inn, farmGroup, replacementId);
    }
}
