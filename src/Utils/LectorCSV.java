package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Santiago Llerena
 */
public class LectorCSV {

    private ArrayList<String> lineas;
    private ObjectCSV[] objetos;

    public class ObjectCSV {

        String usernarme;
        int score;

        public ObjectCSV(String usernarme, int score) {
            this.usernarme = usernarme;
            this.score = score;
        }

        public String getUsernarme() {
            return usernarme;
        }

        public int getScore() {
            return score;
        }
    }

    public LectorCSV(String ruta) {
        lineas = new ArrayList<>();

        try {
            FileReader is = new FileReader(ruta);
            BufferedReader br = new BufferedReader(is);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException ex) {
        }
        objetos = new ObjectCSV[lineas.size()];
        for (int i = 0; i < objetos.length; i++) {
            String[] e = StringUtil.splitCadena(lineas.get(i), ",");
            if (e.length == 2) {
                objetos[i] = new ObjectCSV(e[0], Integer.parseInt(e[1]));
            }
        }
    }

    public ObjectCSV[] getObjetos() {
        return objetos;
    }

    public void organizar() {

        for (int i = 0; i < objetos.length; i++) {
            for (int j = 0; j < objetos.length - 1 - i; j++) {
                if (objetos[j].score < objetos[j + 1].score) {
                    ObjectCSV aux = objetos[j];
                    objetos[j] = objetos[j + 1];
                    objetos[j + 1] = aux;
                }
            }
        }
    }
}
