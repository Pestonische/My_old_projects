import java.io.*;
import java.util.*;
import java.util.zip.*;

class KeyComp implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        // right order:	
        return o1.compareTo(o2);
    }
}

class KeyCompReverse implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        // reverse order:
        return o2.compareTo(o1);
    }
}

interface IndexBase {
    Integer[] getKeys( Comparator<Integer> comp );
    void put( int key, long value );
    boolean contains( int key );
    long[] get( int key );
}

class IndexOne2One implements Serializable, IndexBase {
    // Unique keys
    // class release version:
    private static final long serialVersionUID = 1L;
    
    private TreeMap<Integer,Long> map;
    
    public IndexOne2One() {
        map = new TreeMap<Integer,Long> ();
    }
	
    public Integer[] getKeys( Comparator<Integer> comp ) {
        Integer[] result = map.keySet().toArray( new Integer[0] );
        Arrays.sort( result, comp );
        return result;
    }
	
    public void put( int key, long value ) {
        map.put(key, new Long( value ));
    }

    public boolean contains( int key ) {
        return map.containsKey(key);
    }
	
    public long[] get( int key ) {
        long pos = map.get( key ).longValue();
        return new long[] {pos};
    }
}

class KeyNotUniqueException extends Exception {
    // class release version:
    private static final long serialVersionUID = 1L;
    
    public KeyNotUniqueException( String key ) {
        super( new String( "Key is not unique: " + key ));
    }
}

public class Index implements Serializable, Closeable {
    // class release version:
    private static final long serialVersionUID = 1L;

    public static long[] InsertValue( long[] arr, long value ) {
        int length = ( arr == null ) ? 0 : arr.length;
        long [] result = new long[length + 1];
        for( int i = 0; i < length; i++ )
            result[i] = arr[i];
        result[length] = value;
        return result;
    }
	
    IndexOne2One          numbers;
    IndexOne2One          squares;
    IndexOne2One          floors;
    IndexOne2One          lifetimes;
	
    public void test( Apartment apart ) throws KeyNotUniqueException {
        assert( apart != null );
    }
	
    public void put( Apartment apart, long value ) throws KeyNotUniqueException {
        test( apart );
        numbers.put( apart.number, value );
        squares.put( apart.square, value);
        floors.put( apart.floor, value);
        lifetimes.put( apart.lifetime, value);
    }
	
    public Index()  {
    	this.numbers   = new IndexOne2One();
        this.squares   = new IndexOne2One();
        this.floors = new IndexOne2One();
        this.lifetimes   = new IndexOne2One();
    }
	
    public static Index load( String name ) 
            throws IOException, ClassNotFoundException {
        Index obj = null;
        try {
            FileInputStream file = new FileInputStream( name );
            try( ZipInputStream zis = new ZipInputStream( file )) {
                ZipEntry zen = zis.getNextEntry();
                if ( zen.getName().equals( Buffer.zipEntryName )== false ) {
                    throw new IOException("Invalid block format");
                }
                try ( ObjectInputStream ois = new ObjectInputStream( zis )) {
                    obj = (Index) ois.readObject();
                }
            }
        } catch ( FileNotFoundException e ) {
            obj = new Index();
        }
        if ( obj != null ) {
            obj.save( name );
        }
        return obj;
    }
	
    private transient String filename = null; 
	
    public void save( String name ) {
        filename = name;
    }
	
    public void saveAs( String name ) throws IOException {
        FileOutputStream file = new FileOutputStream( name );
        try ( ZipOutputStream zos = new ZipOutputStream( file )) {
            zos.putNextEntry( new ZipEntry( Buffer.zipEntryName ));
            zos.setLevel( ZipOutputStream.DEFLATED );
            try ( ObjectOutputStream oos = new ObjectOutputStream( zos )) {
                oos.writeObject( this );
                oos.flush();
                zos.closeEntry();
                zos.flush();
            }
        }
    }
	
    public void close() throws IOException {
        saveAs( filename );
    }
}