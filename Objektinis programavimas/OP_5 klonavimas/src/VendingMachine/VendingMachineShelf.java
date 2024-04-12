package VendingMachine;
public class VendingMachineShelf implements Cloneable{

    private int id;

    private String origin;

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public VendingMachineShelf(int id, String origin){
        this.id = id;
        this.origin = origin;
    }

    public void setId(int id) {this.id = id;}
    public void setOrigin(String origin) {this.origin = origin;}
    public int getId() {return id;}
    public String getOrigin() {return origin;}
}
