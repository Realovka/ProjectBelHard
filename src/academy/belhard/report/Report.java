package academy.belhard.report;

import academy.belhard.util.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Report {
    public  static  void join() throws SQLException {
        Connection connection = DbConnector.getConnection();
        String query="SELECT pharmacy.id, pharmacy.pharmacy_name, pharmacy.city, pharmacy.address, medicine.name_of_medicine,medicine.inn,medicine.farm_group,replacement.generic  \n" +
                "FROM pharmacy JOIN medicine ON pharmacy.medicine_id=medicine.id JOIN replacement ON medicine.replacement_id=replacement.id";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            int id;
            String pharmacyName;
            String city;
            String address;
            String nameOfMedicine;
            String inn;
            String farmGroup;
            String generic;
            id=resultSet.getInt("id");
            pharmacyName=resultSet.getString("pharmacy_name");
            city=resultSet.getString("city");
            address=resultSet.getString("address");
            nameOfMedicine=resultSet.getString("name_of_medicine");
            inn=resultSet.getString("inn");
            farmGroup=resultSet.getString("farm_group");
            generic=resultSet.getString("generic");
            AllInformation pharmacy1=new AllInformation(id,pharmacyName,city, address, nameOfMedicine,inn, farmGroup, generic);
            System.out.println(pharmacy1);
        }
        statement.close();
        connection.close();;
    }
}
