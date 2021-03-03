
package java_videogame_80s.gamecomponents;


public class Ladrillo {
    
    private int posX;//Coordenada X del ladrillo
    private int posY;//Coordenada Y del ladrillo

    public Ladrillo(int posX, int posY) {//Recibe las coordenadas X y Y de un ladrillo
        this.posX = posX;
        this.posY = posY;
    }
    
    //Metodos getter and setter
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
}