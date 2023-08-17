package model.entity;

public class Tenant {

	/**
     * id of tenant
     */
    private int id;

    /**
     * FIO of tenant
     */
    private String FIO;
    
    /**
     * constructor to create tenant
     * @param id id of tenant
     * @param FIO FIO of tenant
     */
    public Tenant(int id, String FIO) {
        setId(id);
        setFIO(FIO);
    }

    public Tenant(String FIO) {
    	setId(0);
        setFIO(FIO);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return String.format("Tenant:\n\tid - %d\n\tfio - %s", id, FIO);
    }
    
}
