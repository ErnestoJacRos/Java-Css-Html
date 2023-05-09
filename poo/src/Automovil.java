public class Automovil {
   private int id;
   private String fabricante;
   private String modelo;
   private Color color = Color.GRIS;
    private double cilindrada;
    private int capacidadTanque = 40;

    private TipoAutomovil tipo;

    /*atributo estático */
    private static int capacidadTanqueEstatico = 40;
    private static Color colorPatente = Color.NARANJA;
    private static int ultimoId;

    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public  static final String COLOR_GRIS_OSCURO = "Gris Oscuro";

    /*las constantes normalmente son public, static y por rigor final y
     * la nomenclatura correspondiente en mayúsculas y palabras separadas con guion bajo */
    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final Integer VELOCIDAD_MAX_CIUDAD = 80;

    /*el apuntador "this" con paréntesis "this()" es para llamar constructores y se llama
    * poniendo los parámetros que llama el constructor anterior y asi no escribimos más código */

    public Automovil() {
        /*Esto lo hacemos para que cada vez se cree un objeto tengo un contador y vaya creciendo y como
        * ultimoId es estático mantiene el valor y también crear el get and set del atributo id */
        this.id = ++Automovil.ultimoId;
    }
    public Automovil(String fabricante){
        this();/*como anteriormente hemos llamado con esto estamos llamando el constructor vacío
        y posteriormente todos los demás constructores lo llamarán, si no lo hiciéramos así solamente
        el constructor vacío será el que incrementará
         */
        this.fabricante = fabricante;
    }
    public Automovil (String fabricante, String modelo){
        this(fabricante);
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color){
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante,String modelo, Color color, double cilindrada){
        this(fabricante, modelo, color);
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadTanque){
        this(fabricante, modelo, color, cilindrada);
        this.capacidadTanque = capacidadTanque;
    }



    /*para generar los métodos de acceso de los atributos automáticamente hacemos clic derecho ->
* generate -> getter and setter > seleccionamos los atributos */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public static Color getColorPatente(){
        return Automovil.colorPatente;
    }
    public static void setColorPatente(Color colorPatente){
        Automovil.colorPatente = colorPatente;
    }

    public static int getCapacidadTanqueEstatico(){
        return Automovil.capacidadTanqueEstatico;
    }

    public static  void setCapacidadTanqueEstatico(int capacidadTanqueEstatico){
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public TipoAutomovil getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    /*como buenas prácticas los métodos no DEBEN imprimir nada ern la consola
    * su función es la de procesar datos y no imprimir */
    public String verDetalle(){
        StringBuilder sb = new StringBuilder();
        sb.append("id = " + this.id);
        sb.append("\nfabricante = " + this.fabricante);
        sb.append("\nmodelo = " + this.modelo);
        sb.append("\ncolor = " + this.color);
        /* como es atributo estático o sea de la clase se puede llamar sin el apuntador "this"
        * y/o con el nombre la clase */
        sb.append("\ncolor Patente= " + Automovil.colorPatente);
        sb.append("\ncilindrada = " + this.cilindrada);
        sb.append("\nTipo_AutoMóvil = " + this.tipo);
        return sb.toString();
    }

    private String acelerar(int rpm){
        return "el auto " + this.fabricante + " acelera a: " + rpm + " rpm";
    }

    private String frenar(){
        return this.fabricante + " " + this.modelo + " frenando!";
    }


    public String acelerarFrenar(int rpm){
        String frenar = this.frenar();
        String acelerar = this.acelerar(rpm);
        return frenar + "\n" + acelerar;
    }
/*es un tipo de polimorfismo, ya que, la sobre carga de métodos hace la misma acción de diferente forma
* mismo comportamiento, pero, implementado de otra forma
* "Polimorfismo: Diferente forma de hacer lo mismo"*/
    public float calcularConsumo(int kms, float porcentajeGasolina){
        return kms / (this.capacidadTanque*porcentajeGasolina);
    }
/* la diferencia entre ocultamiento y encapsulamiento es que ocultamiento es cuando usas los modificadores
*de acceso como: private, public, protected,
* y encapsulamiento es lo hermético con lo que se implementa el método por ejemplo la clase "main" que llama
* a los métodos de las instancias creadas no sabe como está implementado el método, ya que está encapsulado  */
    public float calcularConsumo(int kms, int porcentajeGasolina){
        /*acá tenemos que dividir entre cien para que no del correcto porcentaje */
        return kms / (this.capacidadTanque*porcentajeGasolina/100f);
    }

    /*en un método estático no puedes hacer uso de variables de instancia, ya que por ser un método
    * estático necesitas variables de clase o sea estáticas */
    public static  float calcularConsumoEstatico(int kms, int porcentajeGasolina){
        /*acá tenemos que dividir entre cien para que no del correcto porcentaje */
        return kms / (Automovil.capacidadTanqueEstatico *porcentajeGasolina/100f);
    }





    @Override
    public String toString() {
        return "\nAutomóvil {" +
                ",\nid ='" + this.id + '\'' +
                "\nfabricante='" + this.fabricante + '\'' +
                ",\nmodelo='" + this.modelo + '\'' +
                ",\ncolor='" + this.color + '\'' +
                ",\ncolor Patente='" + Automovil.colorPatente + '\'' +
                ",\ncilindrada=" + this.cilindrada +
                ",\ncapacidadTanque=" + this.capacidadTanque +
                ",\nTipo Automóvil=" + this.tipo +
                '}';
    }


    /*Otra forma de polimorfismo es la sobre escritura de los métodos padre.
    * ¡Diferente forma de hacer lo mismo!
    *Estamos sobreescribiendo el método equals() para que solo haga la comparación con los parámetros
    * que estemos indicando*/
    @Override
    public boolean equals(Object obj) {
        /*si son el mismo objeto ya no es necesario comparar por los parámetros 
        * la misma referencia*/
        if (this == obj){
            return true;
        }
        /*este if lo hacemos para validar que si en el programa quieren usar el método equals()
        * para comparar otro tipo de instancia, como ejemplo un tipo Date y asi no rompa el programa*/
        if (!(obj instanceof  Automovil)){
            return false;
        }
        /*primero se castea, ya que el método va a recibir un objeto del tipo automóvil en específico */
        Automovil auto = (Automovil) obj;
        /*validamos que los parámetros no sean nulos y que no rompa el programa con un NullException*/
        return (this.fabricante !=  null &&
                this.modelo != null &&
                this.fabricante.equals(auto.getFabricante()) &&
                this.modelo.equals(auto.getModelo()));
    }
}
/*un atributo estático no pertenece al objeto sino a la clase por lo cual es compartido
* por cualquier objeto de esa clase, de tal forma que si un objeto en particular modifica este valor
* estático se va a modificar para el resto, se puede decir que es un atributo genérico, compartido por
* todas las clases de las instancias de la clase  */