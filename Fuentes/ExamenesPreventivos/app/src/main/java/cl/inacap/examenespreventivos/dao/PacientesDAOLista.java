package cl.inacap.examenespreventivos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examenespreventivos.dto.Paciente;

public class PacientesDAOLista implements PacientesDAO {

    private List<Paciente> pacientes = new ArrayList<>();

    private static PacientesDAOLista instancia;

    private PacientesDAOLista(){
        Paciente p = new Paciente();
        p.setRut("19.557.731-5");
        p.setNombre("Francisco");
        p.setApellido("Corvalan");
        p.setFechaExamen(10-11-2020);
        p.setAreaTrabajo(1);
        //p.setSintama();
        p.setTemperatura(34);
        //p.setPresentaTos();
        p.setPresionArterial(43);
        pacientes.add(p);
    }

    public static PacientesDAOLista getInstance(){
        if (instancia == null){
            instancia = new PacientesDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        pacientes.add(p);
        return p;
    }
}
