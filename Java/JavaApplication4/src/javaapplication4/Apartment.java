import java.io.*;
import java.util.*;

enum BuildingType {
    COTTAGE, TOWNHOUSE, DUPLEX, STUDIO;
}

public class Apartment implements Serializable {
	private static final long serialVersionUID = 1L;
	int number = 0;
	static final String P_number = "Number";
	int square = 0;
	static final String P_square = "Square";
	int floor = 0;
	static final String P_floor = "Floor";
	int roomsNumber = 0;
	static final String P_roomsNumber = "RoomsNumber";
	String street = null;
	static final String P_street = "Street";
	BuildingType buildingType = null;
	static final String P_buildingType = "BuildingType";
	int lifetime = 0;
	static final String P_lifetime = "Lifetime";
    
	public static final String squareDel = ",";
	public static final String floorDel = ",";
	public static final String lifetimeDel = ",";
	
    public static Boolean nextRead( Scanner fin, PrintStream out ) {
        return nextRead( P_number, fin, out );
    }
    
    static Boolean nextRead( final String prompt, Scanner fin, PrintStream out ) {
        out.print( prompt );
        out.print( ": " );
        return fin.hasNextLine();
    }
	
	public Apartment() {
		
	}
        
	public static Apartment read(Scanner fin, PrintStream out) throws IOException {
		Apartment apart = new Apartment();
		int tmpInt;
		
		tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0) {
			return null;
		} else {
			apart.number = tmpInt;
		}
		
		if ( !nextRead( P_square, fin, out )) return null;
		tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0) {
			return null;
		} else {
			apart.square = tmpInt;
		}
		
		if ( !nextRead( P_floor, fin, out )) return null;
		tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0) {
			return null;
		} else {
			apart.floor = tmpInt;
		}
		
		if ( !nextRead( P_roomsNumber, fin, out )) return null;
		tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0) {
			return null;
		} else {
			apart.roomsNumber = tmpInt;
		}
		
		if ( ! nextRead( P_street, fin, out )) return null;
                apart.street = fin.nextLine();
        
                if ( ! nextRead( P_buildingType, fin, out )) return null;
                tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0 || tmpInt >= 4) {
			return null;
		} else {
			apart.buildingType = BuildingType.values()[tmpInt];
		}
		
		if ( !nextRead( P_lifetime, fin, out )) return null;
		tmpInt = Integer.parseInt(fin.nextLine());
		if (tmpInt <= 0) {
			return null;
		} else {
			apart.lifetime = tmpInt;
		}
		
		return apart;
	}
	
	public static final String areaDel = "\n";
	
	public String toString() {
        return new String (
            "Apartment number = " + this.number + areaDel +
            "Apartment square = " + this.square + areaDel +
            "Apartment floor = " + this.floor + areaDel +
            "Apartment rooms number = " + this.roomsNumber + areaDel +
            "Apartment street = " + this.street + areaDel +
            "Apartment building type = " + this.buildingType + areaDel +
            "Apartment lifetime = " + this.lifetime
        );
    }
}
