package com.example.pruebatecnica.models;
import java.util.Collection;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "pregunta")
@JsonIgnoreProperties("examen")
public class PreguntaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpregunta", unique = true, nullable = false)
    private Long idPregunta;
    @Column(name = "descripcion")
    private String descripcion;    
   
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idexamen", nullable=false)
    private ExamenModel examen;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("pregunta")
    private Collection<OpcionModel> opciones;
       
    public void addOpcionModel(OpcionModel opcionModel) {
        opciones.add(opcionModel);
        opcionModel.setPregunta(this);
    }
    
    public void removeOpcionModel(OpcionModel opcionModel) {
        opciones.remove(opcionModel);
        opcionModel.setPregunta(null);
    }


    public PreguntaModel(Long idPregunta, String descripcion, ExamenModel examen, Collection<OpcionModel> opciones) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.examen = examen;
        this.opciones = opciones;
    }
    public PreguntaModel() {

    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreguntaModel )) return false;
        return idPregunta != null && idPregunta.equals(((PreguntaModel) o).idPregunta);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    public Long getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ExamenModel getExamen() {
        return examen;
    }
    public void setExamen(ExamenModel examen) {
        this.examen = examen;
    }
    public Collection<OpcionModel> getOpciones() {
        return opciones;
    }
    public void setOpciones(Collection<OpcionModel> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return "PreguntaModel [descripcion=" + descripcion + ", examen=" + examen + ", idPregunta=" + idPregunta
                + ", opciones=" + opciones + "]";
    }


    
}
