package academy.belhard;

import academy.belhard.medicine.Medicine;
import academy.belhard.medicine.MedicineConnector;
import academy.belhard.pharmacy.Pharmacy;
import academy.belhard.pharmacy.PharmacyConnector;
import academy.belhard.replacement.Replacement;
import academy.belhard.replacement.ReplacementConnector;
import academy.belhard.util.CommandReader;

import java.sql.SQLException;


import static academy.belhard.util.CommandReader.showMenu;
import static academy.belhard.report.Report.join;
import static academy.belhard.medicine.MedicineConnector.showAllMedicine;
import static academy.belhard.pharmacy.PharmacyConnector.showAllPharmacy;
import static academy.belhard.replacement.ReplacementConnector.showAllReplacement;

public class Main {

    public static void main(String[] args) throws SQLException {

        boolean continueLoop = true;
        while (continueLoop) {
            showMenu();
            int command = CommandReader.readNumber("Введите команду:");
            System.out.println();
            switch (command) {
                case 1:
                     showAllPharmacy();
                     break;
                case 2:
                    String nameOfPharmacy = CommandReader.readString("Введите название аптеки");
                    String city = CommandReader.readString ("Введите город, в котором находится аптека");
                    String address = CommandReader.readString ("Введите адрес аптеки");
                    int medicineId=CommandReader.readNumber("Введите id соответствующего медикамента в теблице 'Medicine'");
                    Pharmacy pharmacy=Pharmacy.createItemForSaving(nameOfPharmacy, city,address,medicineId );
                    PharmacyConnector.add(pharmacy);
                    showAllPharmacy();
                    break;
                case 3:
                    int id=CommandReader.readNumber("Введите индекс редактируемой аптеки в таблице 'Pharmacy'");
                    String nameOfPharmacy1 = CommandReader.readString("Введите название аптеки");
                    String city1 = CommandReader.readString ("Введите город, в котором находится аптека");
                    String address1 = CommandReader.readString ("Введите адрес аптеки");
                    int medicineId1=CommandReader.readNumber("Введите id соответствующего медикамента в теблице 'Medicine'");
                    Pharmacy pharmacy1=Pharmacy.updateItemForSaving(id, nameOfPharmacy1, city1,address1,medicineId1 );
                    PharmacyConnector.update(pharmacy1);
                    showAllPharmacy();
                    break;
                case 4:
                    int idPharmacy = CommandReader.readNumber("Введите id удаляемой строки в таблице 'Pharmacy'");
                    PharmacyConnector.deleteById(idPharmacy);
                    showAllPharmacy();
                    break;
                case 5:
                    int idPharmacy1 = CommandReader.readNumber("Введите id необходимой для вывода строки из таблицы 'Pharmacy'");
                    System.out.println(PharmacyConnector.getById(idPharmacy1));
                    System.out.println();
                    break;
                case 6:
                    showAllMedicine();
                    break;
                case 7:
                    String nameOfMedicine = CommandReader.readString("Введите название медикамента");
                    String inn = CommandReader.readString ("Введите МНН");
                    String farmGroup = CommandReader.readString ("Введите фарм. группу");
                    int replacementId=CommandReader.readNumber("Введите id соответствующей замены в теблице 'Replacement'");
                    Medicine medicine=Medicine.createItemForSaving(nameOfMedicine, inn, farmGroup, replacementId );
                    MedicineConnector.add(medicine);
                    showAllMedicine();
                    break;
                case 8:
                    int id2=CommandReader.readNumber("Введите индекс редактируемого медикамента в таблице 'Medicine'");
                    String nameOfMedicine1 = CommandReader.readString("Введите название медикамента");
                    String inn1 = CommandReader.readString ("Введите МНН");
                    String farmGroup1 = CommandReader.readString ("Введите фарм. группу");
                    int replacementId1=CommandReader.readNumber("Введите id соответствующей замены в теблице 'Replacement'");
                    Medicine medicine1=Medicine.updateItemForSaving(id2, nameOfMedicine1, inn1, farmGroup1, replacementId1 );
                    MedicineConnector.update(medicine1);
                    showAllMedicine();
                    break;
                case 9:
                    int idMedicine = CommandReader.readNumber("Введите id удаляемой записи в таблице 'Medicine'");
                    MedicineConnector.deleteById(idMedicine);
                    showAllMedicine();
                    break;
                case 10:
                    int idMedicine1 = CommandReader.readNumber("Введите id необходимой для вывода строки из таблицы 'Medicine'");
                    System.out.println(MedicineConnector.getById(idMedicine1));
                    System.out.println();
                    break;
                case 11:
                    showAllReplacement();
                    break;
                case 12:
                    String nameOfMedicine2 = CommandReader.readString("Введите название медикамента");
                    String generic = CommandReader.readString ("Введите название замен");
                    Replacement replacement=Replacement.createItemForSaving(nameOfMedicine2, generic );
                    ReplacementConnector.add(replacement);
                    showAllReplacement();
                    break;
                case 13:
                    int id3=CommandReader.readNumber("Введите индекс редактируемого медикамента в таблице 'Replacement'");
                    String nameOfMedicine3 = CommandReader.readString("Введите название медикамента");
                    String generic1 = CommandReader.readString ("Введите название замен");
                    Replacement replacement1=Replacement.updateItemForSaving(id3, nameOfMedicine3, generic1 );
                    ReplacementConnector.update(replacement1);
                    showAllReplacement();
                    break;
                case 14:
                    int idReplacement = CommandReader.readNumber("Введите id удаляемой записи в таблице 'Replacement'");
                     ReplacementConnector.deleteById(idReplacement);
                     showAllReplacement();
                     break;
                case 15:
                    int idReplacement1 = CommandReader.readNumber("Введите id необходимой для вывода строки из таблицы 'Replacement'");
                    System.out.println(ReplacementConnector.getById(idReplacement1));
                    System.out.println();
                    break;
                case 16:
                    join();
                    System.out.println();
                    break;
                case 17:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Введенная команда не существует или не реализована");
                    System.out.println();
            }


        }
        showMenu();

    }

}

