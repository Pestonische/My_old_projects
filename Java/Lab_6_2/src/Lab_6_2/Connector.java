package Lab_6_2;

import java.io.*;

public class Connector 
{
    private final String filename;

    public Connector( String filename ) {
        this.filename = filename;
    }

    public void write( dispatcher[] band) throws IOException {
        FileOutputStream fos = new FileOutputStream (filename);
        try ( ObjectOutputStream oos = new ObjectOutputStream( fos )) {
            oos.writeInt( band.length );
            for (dispatcher payments : band) {
                oos.writeObject(payments);
            }
            oos.flush();
        }
    }

    public dispatcher[] read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        try ( ObjectInputStream oin = new ObjectInputStream(fis)) {
            int length = oin.readInt();
            dispatcher[] result = new dispatcher[length];
            for ( int i = 0; i < length; i++ ) {
                result[i] = (dispatcher) oin.readObject();
            }
            return result;
        }
    }

}




