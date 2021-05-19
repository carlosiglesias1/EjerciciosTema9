package recursos.figuras;

public class Figura2D_v8 {
    private float ancho;
    private float alto;
    private String nombre;

    public Figura2D_v8(float alto, float ancho, String nombre) {
        this.alto = alto;
        this.ancho = ancho;
        this.nombre = nombre;
    }

    public Figura2D_v8(float altoYAncho, String nombre) {
        this.alto = altoYAncho;
        this.ancho = altoYAncho;
        this.nombre = nombre;
    }

    public Figura2D_v8 (){
        this.alto = this.ancho = 0;
        this.nombre = null;
    }

    public Figura2D_v8 (Figura2D_v8 fV7){
        this.alto = fV7.getAlto();
        this.ancho = fV7.getAncho();
        this.nombre = fV7.getNombre();
    }

    public float getAlto() {
        return alto;
    }

    public float getAncho() {
        return ancho;
    }

    public String getNombre() {
        return nombre;
    }

    public String verDim() {
        return String.format("alto = %.2f %nancho = %.2f", alto, ancho);
    }
}
