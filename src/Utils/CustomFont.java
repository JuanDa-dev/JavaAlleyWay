package Utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Santiago Llerena
 */
public class CustomFont {

    private Font font = null;

    public CustomFont(String nombre) {
        String fontNombre = nombre;
        try {
            InputStream is = getClass().getResourceAsStream(fontNombre);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {
            System.err.println(fontNombre + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
    }
    
    public Font font(int estilo, float tamaño){
        Font tfont = font.deriveFont(estilo, tamaño);
        return tfont;
    }

}
