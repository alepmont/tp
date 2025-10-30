package com.example.tpractico1.service;

import com.example.tpractico1.dao.ProductoDAO;
import com.example.tpractico1.dto.ProductoDTO;
import com.example.tpractico1.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoDAO productoDAO;
    
    // Obtener todos los productos como DTOs
    public List<ProductoDTO> obtenerTodosLosProductos() {
        return productoDAO.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    // Obtener producto por ID
    public ProductoDTO obtenerProductoPorId(Long id) {
        Producto producto = productoDAO.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertirADTO(producto);
    }
    
    // Crear nuevo producto
    public ProductoDTO crearProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(10); // Valor por defecto
        
        Producto guardado = productoDAO.save(producto);
        return convertirADTO(guardado);
    }
    
    // Actualizar stock (lógica de negocio)
    public ProductoDTO actualizarStock(Long id, Integer cantidad) {
        Producto producto = productoDAO.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        int nuevoStock = producto.getStock() + cantidad;
        if (nuevoStock < 0) {
            throw new RuntimeException("Stock no puede ser negativo");
        }
        
        producto.setStock(nuevoStock);
        Producto actualizado = productoDAO.save(producto);
        return convertirADTO(actualizado);
    }
    
    // Buscar productos disponibles
    public List<ProductoDTO> obtenerProductosDisponibles() {
        return productoDAO.findByStockGreaterThan(0).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    // Método auxiliar: Convertir Entidad a DTO
    private ProductoDTO convertirADTO(Producto producto) {
        return new ProductoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock() > 0 // Lógica de negocio: disponible si hay stock
        );
    }
}