package academy.belhard.medicine;

public class Medicine {
    private int id;
    private String nameOfMedicine;
    private String inn;
    private String farmGroup;
    private  int replacementId;

    public Medicine(int id, String nameOfMedicine, String inn, String farmGroup, int replacementId) {
        this.id = id;
        this.nameOfMedicine = nameOfMedicine;
        this.inn = inn;
        this.farmGroup = farmGroup;
        this.replacementId = replacementId;
    }

    public Medicine(String nameOfMedicine, String inn, String farmGroup, int replacementId) {
        this.nameOfMedicine = nameOfMedicine;
        this.inn = inn;
        this.farmGroup = farmGroup;
        this.replacementId = replacementId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getReplacementId() {
        return replacementId;
    }

    public void setReplacementId(int replacementId) {
        this.replacementId = replacementId;
    }

    public  static Medicine createItemForSaving( String nameOfMedicine, String inn, String farmGroup, int replacementId ){
        return new Medicine(nameOfMedicine, inn, farmGroup, replacementId);
    }
    public  static Medicine updateItemForSaving( int id,String nameOfMedicine, String inn, String farmGroup, int replacementId ){
        return new Medicine(id, nameOfMedicine, inn, farmGroup, replacementId);
    }
    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", nameOfMedicine='" + nameOfMedicine + '\'' +
                ", inn='" + inn + '\'' +
                ", farmGroup='" + farmGroup + '\'' +
                ", replacementId=" + replacementId +
                '}';
    }
}
