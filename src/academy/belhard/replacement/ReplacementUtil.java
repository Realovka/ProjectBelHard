package academy.belhard.replacement;

import academy.belhard.replacement.Replacement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplacementUtil {
    public static Replacement toObject(ResultSet resultSet) throws SQLException{
    int id = resultSet.getInt("id");
    String nameOfMedicine = resultSet.getString("name_of_medicine");
    String generic = resultSet.getString("generic");

    return new Replacement (id, nameOfMedicine, generic);
}
}