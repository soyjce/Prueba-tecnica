package com.example.pruebatecnica.models;
import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class RespuestaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta", unique = true, nullable = false)
    private Long idRespuesta;
    @Column(name = "idexamen")
    private Long idExamen;
    @Column(name = "idestudiante")
    private Long idEstudiante;
    @Column(name = "idpregunta")
    private long idPregunta;
    @Column(name = "idopcion")
    private long idOpcion;
    
    public RespuestaModel() {
    }

    public RespuestaModel(Long idRespuesta, Long idExamen, Long idEstudiante, long idPregunta, long idOpcion) {
        this.idRespuesta = idRespuesta;
        this.idExamen = idExamen;
        this.idEstudiante = idEstudiante;
        this.idPregunta = idPregunta;
        this.idOpcion = idOpcion;
    }
    public Long getIdRespuesta() {
        return idRespuesta;
    }
    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
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
    public long getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }
    public long getIdOpcion() {
        return idOpcion;
    }
    public void setIdOpcion(long idOpcion) {
        this.idOpcion = idOpcion;
    }

    @Override
    public String toString() {
        return "RespuestaModel [idEstudiante=" + idEstudiante + ", idExamen=" + idExamen + ", idOpcion=" + idOpcion
                + ", idPregunta=" + idPregunta + ", idRespuesta=" + idRespuesta + "]";
    }
    
    
}
