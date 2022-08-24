package com.example.pruebatecnica.models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "opcion")
public class OpcionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopcion", unique = true, nullable = false)
    private Long idOpcion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "escorrecta")
    private Boolean esCorrecta;
    @Column(name = "puntos")
    private Integer puntos;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idpregunta", nullable=false)
    private PreguntaModel pregunta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpcionModel )) return false;
        return idOpcion != null && idOpcion.equals(((OpcionModel) o).idOpcion);
    }

    @Override
    public int hashCode() {
        return 31;
    }
    
    public OpcionModel() {


    }
    
    public OpcionModel(Long idOpcion, String descripcion, Boolean esCorrecta, Integer puntos, PreguntaModel pregunta) {
        this.idOpcion = idOpcion;
        this.descripcion = descripcion;
        this.esCorrecta = esCorrecta;
        this.puntos = puntos;
        this.pregunta = pregunta;
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public PreguntaModel getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaModel pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "OpcionModel [descripcion=" + descripcion + ", esCorrecta=" + esCorrecta + ", idOpcion=" + idOpcion
                + ", pregunta=" + pregunta + ", puntos=" + puntos + "]";
    }

    
}
