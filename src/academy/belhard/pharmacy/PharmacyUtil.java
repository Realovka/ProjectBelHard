package academy.belhard.pharmacy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PharmacyUtil {
    public static Pharmacy toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String pharmacyName = resultSet.getString("pharmacy_name");
        String city = resultSet.getString("city");
        String address = resultSet.getString("address");
        int medicineId = resultSet.getInt("medicine_id");
        Date createdAt =resultSet.getDate("created_at");
        Date updatedAt=resultSet.getDate("updated_at");

        return new Pharmacy (id, pharmacyName, city, address, medicineId, createdAt, updatedAt);
    }
}
