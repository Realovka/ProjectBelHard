package academy.belhard.report;

public class AllInformation {
    int id;
    String pharmacyName;
    String city;
    String address;
    String nameOfMedicine;
    String inn;
    String farmGroup;
    String generic;

    public AllInformation(int id, String pharmacyName, String city, String address, String nameOfMedicine, String inn, String farmGroup, String generic) {
        this.id = id;
        this.pharmacyName = pharmacyName;
        this.city = city;
        this.address = address;
        this.nameOfMedicine = nameOfMedicine;
        this.inn = inn;
        this.farmGroup = farmGroup;
        this.generic = generic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    public void setNameOfMedicine(String nameOfMedicine) {
        this.nameOfMedicine = nameOfMedicine;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFarmGroup() {
        return farmGroup;
    }

    public void setFarmGroup(String farmGroup) {
        this.farmGroup = farmGroup;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    @Override
    public String toString() {
        return "AllInformation{" +
                "id=" + id +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", nameOfMedicine='" + nameOfMedicine + '\'' +
                ", inn='" + inn + '\'' +
                ", farmGroup='" + farmGroup + '\'' +
                ", generic='" + generic + '\'' +
                '}';
    }
}

