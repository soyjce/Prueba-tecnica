package com.example.pruebatecnica.models;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "estado")
@JsonIgnoreProperties("pais")
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado", unique = true, nullable = false)
    private Long idEstado;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idpais", nullable=false)
    private PaisModel pais;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("estado")
    private Collection<CiudadModel> ciudades;

    public void addCiudadModel(CiudadModel ciudadModel) {
        ciudades.add(ciudadModel);
        ciudadModel.setEstado(this);
    }

    public void removeCiudadModel(CiudadModel ciudadModel) {
        ciudades.remove(ciudadModel);
        ciudadModel.setEstado(null);
    }

    
    public EstadoModel() {
    }

    

    public EstadoModel(Long idEstado, String nombre, PaisModel pais, Collection<CiudadModel> ciudades) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudades = ciudades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoModel )) return false;
        return idEstado != null && idEstado.equals(((EstadoModel) o).idEstado);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }

    public Collection<CiudadModel> getCiudades() {
        return ciudades;
    }

    public void setCiudades(Collection<CiudadModel> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public String toString() {
        return "EstadoModel [ciudades=" + ciudades + ", idEstado=" + idEstado + ", nombre=" + nombre + ", pais=" + pais
                + "]";
    }





    
    
}
