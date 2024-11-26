import java.util.Random;
public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

    public Pokemon(String nombre, String tipo){
    	this.nombre = nombre;
    	this.tipo = tipo.toLowerCase();
    	nivel = 1;
    	actualizarStats();
    }

    public Pokemon(String nombre, String tipo,int nivel){
    	this.nombre = nombre;
    	this.tipo = tipo.toLowerCase();
    	this.nivel = nivel;
    	actualizarStats();
    }



    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
       
    Random rn = new Random();	
    int poder;
    switch(this.nivel) {
    case 1 -> poder = rn.nextInt(8) + 3;
    case 2 -> poder = rn.nextInt(15) + 6;
    case 3 -> poder = rn.nextInt(22) + 9;
    case 4 -> poder = rn.nextInt(29) + 12;
    default -> poder = 3;
    }
    
    if ((this.tipo.equals("agua") && contrincante.tipo.equals("fuego")) ||
            (this.tipo.equals("fuego") && contrincante.tipo.equals("tierra")) ||
            (this.tipo.equals("tierra") && contrincante.tipo.equals("agua"))) {
    	
            poder += 2 * this.nivel;
            
        } else if ((this.tipo.equals("agua") && contrincante.tipo.equals("tierra")) ||
                   (this.tipo.equals("fuego") && contrincante.tipo.equals("agua")) ||
                   (this.tipo.equals("tierra") && contrincante.tipo.equals("fuego"))) {
            poder -= 2 * contrincante.nivel; 
        }

        return Math.max(poder, 1);
    }

    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\nTipo: " + this.tipo +
                "\nNivel: " + this.nivel +
                "\nAguante " + this.aguante;
    }

}
