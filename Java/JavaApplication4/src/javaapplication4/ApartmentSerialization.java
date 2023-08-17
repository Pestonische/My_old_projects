import java.io.*;
import java.util.*;

public class ApartmentSerialization {
    static public String filename    = "ApartmentSerialization.dat";
    static public String filenameBak = "ApartmentSerialization.~dat";
    static public String idxname     = "ApartmentSerialization.idx";
    static public String idxnameBak  = "ApartmentSerialization.~idx";
    
    private static PrintStream apartmnetsOut = System.out;
	
    static Apartment readBook( Scanner fin ) throws IOException {	
        return Apartment.nextRead( fin, apartmnetsOut ) 
                ? Apartment.read( fin, apartmnetsOut ) : null;
    }

    private static void deleteBackup() {
        new File( filenameBak ).delete();
        new File( idxnameBak ).delete();				
    }
	
    static void deleteFile() {
        deleteBackup();
        new File( filename ).delete();
        new File( idxname ).delete();
    }
	
    private static void backup() {
        deleteBackup();
        new File( filename ).renameTo( new File( filenameBak ));
        new File( idxname ).renameTo( new File( idxnameBak ));
    }
    static public String output = "";
    static boolean deleteFile( String[] args ) 
            throws ClassNotFoundException, IOException, KeyNotUniqueException {
        //-dk  {n|s|f|l} key      - clear data by key
        if ( args.length != 3 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        long[] poss = null;
        try ( Index idx = Index.load( idxname )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx == null ) {
                return false;
            }
            if ( pidx.contains(Integer.parseInt(args[2]))== false ) {
                System.err.println( "Key not found: " + args[2] );
                return false;				
            }
            poss = pidx.get(Integer.parseInt(args[2]));
        }
        backup();
        Arrays.sort( poss );
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile fileBak= new RandomAccessFile(filenameBak, "rw");
              RandomAccessFile file = new RandomAccessFile( filename, "rw")) {
            boolean[] wasZipped = new boolean[] {false};
            long pos;
            while (( pos = fileBak.getFilePointer()) < fileBak.length() ) {
                Apartment apart = (Apartment) 
                Buffer.readObject( fileBak, pos, wasZipped );
                if ( Arrays.binarySearch(poss, pos) < 0 ) { // if not found in deleted
                    long ptr = Buffer.writeObject( file, apart, wasZipped[0] );
                    idx.put( apart, ptr );
                }
             }
         }
         return true;
    }
	
    static public void appendFile(Apartment apart, Boolean zipped ) 
            throws FileNotFoundException, IOException, ClassNotFoundException, 
                KeyNotUniqueException {
        //Scanner fin = new Scanner( System.in, encoding );
        //apartmnetsOut.println( "Enter apartment data: " );
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            idx.test( apart );
            long pos = Buffer.writeObject( raf, apart, zipped );
            idx.put( apart, pos );
           
        }
    }
	
    private static String printRecord( RandomAccessFile raf, long pos ) 
            throws ClassNotFoundException, IOException {
        String out = "";
        boolean[] wasZipped = new boolean[] {false};
        Apartment apart = (Apartment) Buffer.readObject( raf, pos, wasZipped );
        if ( wasZipped[0] == true ) {
            //System.out.print( " compressed" );
            out += " compressed";
        }
        //System.out.println( " record at position "+ pos + ": \n" + apart );
        out += " record at position "+ pos + ": \n" + apart;
        return out;
    }
	
    private static void printRecord( RandomAccessFile raf, Integer key, 
            IndexBase pidx ) throws ClassNotFoundException, IOException {
        long[] poss = pidx.get( key );
        for ( long pos : poss ) {
            //System.out.print( "*** Key: " +  key + " points to" );
            output += "*** Key: " +  key + " points to";
            output += printRecord( raf, pos );
        }		
    }
    
    static void printFile() 
            throws FileNotFoundException, IOException, ClassNotFoundException {
        long pos;
        int rec = 0;
        try ( RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            while (( pos = raf.getFilePointer()) < raf.length() ) {
                //System.out.print( "#" + (++rec ));
                output+="\n\n\t#" + (++rec);
                output += printRecord( raf, pos );
            }
            //System.out.flush();
        }
    }
	
    private static IndexBase indexByArg( String arg, Index idx ) {
        IndexBase pidx = null;
        if ( arg.equals("n")) {
            pidx = idx.numbers;
        } 
        else if ( arg.equals("s")) {
            pidx = idx.squares;
        } 
        else if ( arg.equals("f")) {
            pidx = idx.floors;
        }
        else if ( arg.equals("l")) {
        	pidx = idx.lifetimes;
        }
        else {
            System.err.println( "Invalid index specified: " + arg );
        }
        return pidx;
    }
	
    static boolean printFile( String[] args, boolean reverse ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 2 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx == null ) {
                return false;
            }
            Integer[] keys = 
                pidx.getKeys( reverse ? new KeyCompReverse() : new KeyComp() );
            for ( Integer key : keys ) {
                printRecord( raf, key, pidx );
            }
        }
        return true;
    }
	
    static boolean findByKey( String[] args ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 3 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx.contains(Integer.parseInt(args[2]))== false ) {
                System.err.println( "Key not found: " + args[2] );
                return false;				
            }
            printRecord( raf, Integer.parseInt(args[2]), pidx );
        }
        return true;	
    }
	
    static boolean findByKey( String[] args, Comparator<Integer> comp ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 3 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx.contains(Integer.parseInt(args[2]))== false ) {
                System.err.println( "Key not found: " + args[2] );
                return false;				
            }
            Integer[] keys = pidx.getKeys( comp );
            for ( int i = 0; i < keys.length; i++ ) {
                Integer key = keys[i];
                if ( key.equals( Integer.parseInt(args[2]) )) {
                    break;
                }
                printRecord( raf, key, pidx );
            }
        }
        return true;
    }
}