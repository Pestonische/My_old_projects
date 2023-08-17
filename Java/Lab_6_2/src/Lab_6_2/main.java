package Lab_6_2;

import java.util.*;
import java.io.*;
import java.util.Locale;
import java.util.Properties;

import Lab_6_2.AppLocale;

public class main {
	static boolean[] valid = { true, false };

	public static dispatcher[] carpool() throws Exception {
		dispatcher[] d = new dispatcher[3];
		d[0] = new dispatcher(1, "Вася", valid[0], 1);
		d[1] = new dispatcher(2, "Ваня", valid[1], 2);
		d[2] = new dispatcher(3, "Петр", valid[0], 3);
		return d;
	}

	static Locale createLocale(String[] args) {
		if (args.length == 2) {
			return new Locale(args[0], args[1]);
		} else if (args.length == 4) {
			return new Locale(args[2], args[3]);
		}
		return null;
	}

	static void setupConsole(String[] args) {
		if (args.length >= 2) {
			if (args[0].compareTo("-encoding") == 0) {
				try {
					System.setOut(new PrintStream(System.out, true, args[1]));
				} catch (UnsupportedEncodingException ex) {
					System.err.println("Unsupported encoding: " + args[1]);
					System.exit(1);
				}
			}
		}
	}

	public static void main(String[] args) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.dat"))) {
			setupConsole(args);
			Locale loc = createLocale(args);
			if (loc == null) {
				System.err.println("Invalid argument(s)\n" + "Syntax: [-encoding ENCODING_ID] language country\n"
						+ "Example: -encoding Cp855 be BY");
				System.exit(1);
			}
			AppLocale.set(loc);
			dispatcher obj_1 = new dispatcher(4, "Игнат", valid[0], 4);
			oos.writeObject(obj_1);
			obj_1.no_in_flight_drivers();
			obj_1.completed();
			dispatcher obj_2 = new dispatcher(5, "Матвей", valid[0], 5);
			obj_1.completed();
			obj_2._repairs_car();
			Connector con = new Connector("info.dat");
			con.write(carpool());
			dispatcher[] b = con.read();
			for (dispatcher n : b) {
				System.out.println(n.toString());
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
