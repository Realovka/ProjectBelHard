package academy.belhard.replacement;

public class Replacement {

    private int id;
    private String nameOfMedicine;
    private String generic;

    public Replacement(int id, String nameOfMedicine, String generic) {
        this.id = id;
        this.nameOfMedicine = nameOfMedicine;
        this.generic = generic;
    }

    public Replacement(String nameOfMedicine, String generic) {
        this.nameOfMedicine = nameOfMedicine;
        this.generic = generic;
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

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }
     public  static Replacement createItemForSaving( String nameOfMedicine, String generic){
        return new Replacement(  nameOfMedicine, generic);
   }
    public  static Replacement updateItemForSaving( int id, String nameOfMedicine, String generic){
        return new Replacement( id, nameOfMedicine, generic);
    }
    @Override
    public String toString() {
        return "Replacement{" +
                "id=" + id +
                ", nameOfMedicine='" + nameOfMedicine + '\'' +
                ", generic='" + generic + '\'' +
                '}';
    }
}

