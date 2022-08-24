package com.example.pruebatecnica.models;
import java.util.Collection;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "examen")
public class ExamenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexamen", unique = true, nullable = false)
    private Long idExamen;
    @Column(name = "descripcion")
    private String descripcion;


    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("examen")
    private Collection<PreguntaModel> preguntas;

  public void addPreguntaModel(PreguntaModel preguntaModel) {
    preguntas.add(preguntaModel);
    preguntaModel.setExamen(this);
}

public void removePreguntaModel(PreguntaModel preguntaModel) {
    preguntas.remove(preguntaModel);
    preguntaModel.setExamen(null);
}

public Long getIdExamen() {
    return idExamen;
}

public void setIdExamen(Long idExamen) {
    this.idExamen = idExamen;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public Collection<PreguntaModel> getPreguntas() {
    return preguntas;
}

public void setPreguntas(Collection<PreguntaModel> preguntas) {
    this.preguntas = preguntas;
}

@Override
public String toString() {
    return "ExamenModel [descripcion=" + descripcion + ", idExamen=" + idExamen + ", preguntas=" + preguntas + "]";
}
       

}
