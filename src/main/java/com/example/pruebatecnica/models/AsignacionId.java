package com.example.pruebatecnica.models;
import java.io.Serializable;
import java.util.Objects;

public class AsignacionId implements Serializable {


    private Long idExamen;
    private Long idEstudiante;    

    
    public AsignacionId() {

    }

    public AsignacionId(Long idExamen, Long idEstudiante) {
        this.idExamen = idExamen;
        this.idEstudiante = idEstudiante;
    }


    public Long getIdExamen() {
        return idExamen;
    }
    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }
    public Long getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignacionId asignacion = (AsignacionId) o;
        return idExamen.equals(asignacion.idExamen) &&
                this.idEstudiante.equals(asignacion.idEstudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idExamen, this.idEstudiante);
    }

   
    
}
