package com.example.pruebatecnica.models;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.Collection;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ciudad")
@JsonIgnoreProperties("estado")
public class CiudadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idciudad", unique = true, nullable = false)
    private Long idCiudad;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idestado", nullable=false)
    private EstadoModel estado;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("ciudad")
    private Collection<EstudianteModel> estudiantes;

    public void addEstudianteModel(EstudianteModel estudianteModel) {
        estudiantes.add(estudianteModel);
        estudianteModel.setCiudad(this);
    }

    public void removeCiudadModel(EstudianteModel estudianteModel) {
        estudiantes.remove(estudianteModel);
        estudianteModel.setCiudad(null);
    }

    
    public CiudadModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CiudadModel )) return false;
        return idCiudad != null && idCiudad.equals(((CiudadModel) o).idCiudad);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

    public Collection<EstudianteModel> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<EstudianteModel> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "CiudadModel [estado=" + estado + ", estudiantes=" + estudiantes + ", idCiudad=" + idCiudad + ", nombre="
                + nombre + "]";
    }   
    
}
