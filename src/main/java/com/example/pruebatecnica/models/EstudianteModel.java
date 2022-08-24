package com.example.pruebatecnica.models;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "estudiante")
public class EstudianteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestudiante", unique = true, nullable = false)
    private Long idEstudiante;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private Integer edad;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idciudad", nullable=false)
    private CiudadModel ciudad;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudianteModel )) return false;
        return idEstudiante != null && idEstudiante.equals(((EstudianteModel) o).idEstudiante);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "EstudianteModel [ciudad=" + ciudad + ", edad=" + edad + ", idEstudiante=" + idEstudiante + ", nombre="
                + nombre + "]";
    }



}
