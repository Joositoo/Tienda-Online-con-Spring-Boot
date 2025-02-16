package org.example.tiendaonlineconspringboot.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotBlank(message = "Debes rellenar el campo nombre.")
    @Pattern(regexp = "^\\w{2,100}$", message = "Nombre del producto debe tener caracteres alfanuméricos.")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "Debes rellenar el campo precio.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser un valor mayor o igual a 0.")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;


    @NotNull(message = "Debes rellenar el campo stock.")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Size(max = 255)
    @Column(name = "imagen_url")
    private String imagen_url;

    @OneToMany(mappedBy = "producto")
    @JsonIgnoreProperties({"producto"})
    private Set<Historial> historials = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public Set<Historial> getHistorials() {
        return historials;
    }

    public void setHistorials(Set<Historial> historials) {
        this.historials = historials;
    }

}