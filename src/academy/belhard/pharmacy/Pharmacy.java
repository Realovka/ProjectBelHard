package academy.belhard.pharmacy;

import java.util.Date;

public class Pharmacy {
    private  int id;
    private String pharmacyName;
    private String city;
    private String address;
    private int medicineId;
    private Date createdAt;
    private Date updatedAt;


    public Pharmacy(int id, String pharmacyName, String city, String address, int medicineId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.pharmacyName = pharmacyName;
        this.city = city;
        this.address = address;
        this.medicineId = medicineId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Pharmacy(String pharmacyName, String city, String address, int medicineId) {

        this.pharmacyName = pharmacyName;
        this.city = city;
        this.address = address;
        this.medicineId = medicineId;
    }

    public Pharmacy(int id, String pharmacyName, String city, String address, int medicineId) {
        this.id = id;
        this.pharmacyName = pharmacyName;
        this.city = city;
        this.address = address;
        this.medicineId = medicineId;
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

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public  static Pharmacy createItemForSaving( String pharmacyName, String city, String address, int medicineId ){
        return new Pharmacy( pharmacyName, city,address,medicineId);
    }
    public  static Pharmacy updateItemForSaving(int id, String pharmacyName, String city, String address, int medicineId ){
        return new Pharmacy( id, pharmacyName, city,address,medicineId);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", medicineId=" + medicineId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
