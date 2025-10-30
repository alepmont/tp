package com.example.tpractico1.dto;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private boolean disponible;
    
    // Constructor vacío
    public ProductoDTO() {}
    
    // Constructor desde entidad
    public ProductoDTO(Long id, String nombre, Double precio, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}