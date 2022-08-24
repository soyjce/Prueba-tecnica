package com.example.pruebatecnica.models;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "pais")
@JsonIgnoreProperties("zonahoraria")
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais", unique = true, nullable = false)
    private Long idPais;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name="idzonahoraria", nullable=false)
    private ZonaHorariaModel zonaHoraria;

    
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("pais")
    private Collection<EstadoModel> estados;

    public void addEstadoModel(EstadoModel estadoModel) {
        estados.add(estadoModel);
        estadoModel.setPais(this);
    }

    public void removeEstadoModel(EstadoModel estadoModel) {
        estados.remove(estadoModel);
        estadoModel.setPais(null);
    }
    
    public PaisModel() {
    }

    public PaisModel(Long idPais, String nombre, ZonaHorariaModel zonaHoraria) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaisModel )) return false;
        return idPais != null && idPais.equals(((PaisModel) o).idPais);
    }

    @Override
    public int hashCode() {
        return 31;
    }



    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonaHorariaModel getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(ZonaHorariaModel zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public Collection<EstadoModel> getEstados() {
        return estados;
    }

    public void setEstados(Collection<EstadoModel> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "PaisModel [estados=" + estados + ", idPais=" + idPais + ", nombre=" + nombre + ", zonaHoraria="
                + zonaHoraria + "]";
    }

    
    
}
