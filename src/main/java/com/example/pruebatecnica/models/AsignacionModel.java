package com.example.pruebatecnica.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asignacion")
@IdClass(AsignacionId.class)
public class AsignacionModel implements Serializable {

   
    @Id
    @Column(name = "idexamen")
    private Long idExamen;
    @Column(name = "idestudiante")
    private Long idEstudiante;
    @Column(name = "fechaexamen")
    private String fechaExamen;
    @Column(name = "calificacion")
    private Integer calificacion;
    
    public AsignacionModel() {
        

    }

    public AsignacionModel(Long idExamen, Long idEstudiante, String fechaExamen,
            Integer calificacion) {

        this.idExamen = idExamen;
        this.idEstudiante = idEstudiante;
        this.fechaExamen = fechaExamen;
        this.calificacion = calificacion;
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

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "AsignacionModel [calificacion=" + calificacion + ", fechaExamen=" + fechaExamen + ", idEstudiante="
                + idEstudiante + ", idExamen=" + idExamen + "]";
    }



   

   
    
}
