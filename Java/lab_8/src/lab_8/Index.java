package lab_8;


import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.time.LocalDate;


class KeyComp implements Comparator<String> {
    public int compare(String o1, String o2) {

        //textFormat.parse(paramDateAsString);
        try {
            LocalDate d1 = LocalDate.parse(o1);
            LocalDate d2 = LocalDate.parse(o2);
            int res = d1.compareTo(d2);
            return res;
        } catch (Exception e) {
            return o1.compareTo(o2);
        }
    }
}

class KeyCompReverse implements Comparator<String> {
    public int compare(String o1, String o2) {
        // reverse order:
        try {
            LocalDate d1 = LocalDate.parse(o1);
            LocalDate d2 = LocalDate.parse(o2);
            int res = d2.compareTo(d1);
            return res;
        } catch (Exception e) {
            return o2.compareTo(o1);
        }
    }
}

interface IndexBase {
    String[] getKeys( Comparator<String> comp );
    void put( String key, long value );
    boolean contains( String key );
    Vector<Long> get(String key );
}

class IndexOne2One implements Serializable, IndexBase {
    // Unique keys
    // class release version:
    private static final long serialVersionUID = 1L;

    private TreeMap<String,Long> map;

    public IndexOne2One() {
        map = new TreeMap<String,Long> ();
    }

    public String[] getKeys( Comparator<String> comp ) {
        String[] result = map.keySet().toArray( new String[0] );
        Arrays.sort( result, comp );
        return result;
    }

    public void put( String key, long value ) {
        map.put(key, new Long( value ));
    }

    public boolean contains( String key ) {
        return map.containsKey(key);
    }

    public Vector<Long> get( String key ) {
        long pos = map.get( key ).longValue();
        Vector<Long> a = new Vector<Long>(1);
        a.add(0, pos);
        return a;
    }
}

class IndexOne2N implements Serializable, IndexBase {
    // Not unique keys
    // class release version:
    private static final long serialVersionUID = 1L;

    private TreeMap<String,Vector<Long>> map;

    public IndexOne2N() {
        map = new TreeMap<String,Vector<Long>> ();
    }

    public String[] getKeys( Comparator<String> comp ) {
        String[] result = map.keySet().toArray( new String[0] );
        Arrays.sort( result, comp );
        return result;
    }

    public void put( String key, long value ) {
        Vector<Long> arr = map.get(key);
        arr = Index.InsertValue( arr, value );
        map.put(key, arr);
    }

    public void put( String keys,   // few keys in one string
                     String keyDel, // key delimiter
                     long value ) {
        StringTokenizer st = new StringTokenizer( keys, keyDel );
        int num = st.countTokens();
        for ( int i= 0; i < num; i++ ) {
            String key = st.nextToken();
            key = key.trim();
            put( key, value );
        }
    }

    public boolean contains( String key ) {
        return map.containsKey(key);
    }

    public Vector<Long> get( String key ) {
        return map.get( key );
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

    public static Vector<Long> InsertValue( Vector<Long> arr, long value ) {
        if(arr==null)
            arr=new Vector<Long>();
        arr.addElement(new Long(value));

        return arr;
    }
    
	
    IndexOne2N          providers;
    IndexOne2N            datas;
    IndexOne2N          age_limits;
	
    public void test( Business_Firm toy ) throws KeyNotUniqueException {
        assert( toy != null );
        //if ( providers.contains(toy.provider)) {
          //  throw new KeyNotUniqueException( toy.provider );
        //}
       // if ( age_limits.contains( toy.age_limit )) {
       //     throw new KeyNotUniqueException( toy.age_limit );
       // }		
    }
	
    public void put( Business_Firm toy, long value ) throws KeyNotUniqueException {
        test( toy );
        providers.put( toy.provider, toy.authorDel, value );
        datas.put( toy.receipt_date, toy.authorDel, value);
        age_limits.put( toy.age_limit, toy.authorDel, value);		
    }
	
    public Index()  {
    	providers   = new IndexOne2N();
    	datas = new IndexOne2N();
    	age_limits 	= new IndexOne2N();
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