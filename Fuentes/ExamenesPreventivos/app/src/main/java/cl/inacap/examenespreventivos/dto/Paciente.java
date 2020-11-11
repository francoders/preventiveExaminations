package cl.inacap.examenespreventivos.dto;

public class Paciente {

    private String rut; //String por el guion
    private String nombre;
    private String apellido;
    private int fechaExamen;
    private int areaTrabajo;
    private boolean sintama;
    private int temperatura;
    private boolean presentaTos;
    private int presionArterial;

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

    public int getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(int fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public int getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(int areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public boolean isSintama() {
        return sintama;
    }

    public void setSintama(boolean sintama) {
        this.sintama = sintama;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isPresentaTos() {
        return presentaTos;
    }

    public void setPresentaTos(boolean presentaTos) {
        this.presentaTos = presentaTos;
    }

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }
}
