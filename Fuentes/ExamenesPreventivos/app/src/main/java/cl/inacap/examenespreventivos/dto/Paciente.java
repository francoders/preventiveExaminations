package cl.inacap.examenespreventivos.dto;

public class Paciente {

    private String rut; //String
    private String nombre;
    private String apellido;
    private String fechaExamen;
    private String areaTrabajo;
    private String sintama;
    private float temperatura;
    private String presentaTos;
    private int presionArterial;
    private int id;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getSintama() {
        return sintama;
    }

    public void setSintama(String sintama) {
        this.sintama = sintama;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getPresentaTos() {
        return presentaTos;
    }

    public void setPresentaTos(String presentaTos) {
        this.presentaTos = presentaTos;
    }

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}