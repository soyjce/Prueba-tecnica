package com.example.pruebatecnica.models;
import java.util.Collection;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "zonahoraria")
public class ZonaHorariaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idzonahoraria", unique = true, nullable = false)
    private Long idZonaHoraria;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "utc")
    private String utc;

    @OneToMany(mappedBy = "zonaHoraria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("zonaHoraria")
    private Collection<PaisModel> paises;

    public void addPaisModel(PaisModel paisModel) {
        paises.add(paisModel);
        paisModel.setZonaHoraria(this);
    }

    public void removePaisModel(PaisModel paisModel) {
        paises.remove(paisModel);
        paisModel.setZonaHoraria(null);
    }
    
    public ZonaHorariaModel() {

    }

    public Long getIdZonaHoraria() {
        return idZonaHoraria;
    }
    public void setIdZonaHoraria(Long idZonaHoraria) {
        this.idZonaHoraria = idZonaHoraria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getUtc() {
        return utc;
    }
    public void setUtc(String utc) {
        this.utc = utc;
    }

    public Collection<PaisModel> getPaises() {
        return paises;
    }

    public void setPaises(Collection<PaisModel> paises) {
        this.paises = paises;
    }

    @Override
    public String toString() {
        return "ZonaHorariaModel [codigo=" + codigo + ", idZonaHoraria=" + idZonaHoraria + ", nombre=" + nombre
                + ", paises=" + paises + ", utc=" + utc + "]";
    }


}
