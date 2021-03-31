package Utils;

/**
 *
 * @author Santiago Llerena
 */
public class StringUtil {

    public static String[] splitCadena(String cadena, String separador) {
        String[] s = new String[2];
        int i = cadena.length();
        int c = 0;
        boolean comilla = false;
        for (int j = 0; j < s.length; j++) {
            s[j] = "";
        }
        for (int j = 0; j < i; j++) {
            String e = cadena.substring(j, j + 1);
            if (!comilla) {
                if (e.equals("\"")) {
                    comilla = true;
                } else {
                    if (e.equals(separador)) {
                        c += 1;
                    } else {
                        s[c] = s[c] + e;
                    }
                }
            } else {
                if (e.equals("\"")) {
                    comilla = false;
                } else {
                    s[c] = s[c] + e;
                }
            }
        }
        return s;
    }
}
