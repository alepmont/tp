package com.example.tpractico1.controller;

import com.example.tpractico1.dto.ProductoDTO;
import com.example.tpractico1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    // GET /api/productos - Obtener todos
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() {
        List<ProductoDTO> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }
    
    // GET /api/productos/{id} - Obtener uno
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        try {
            ProductoDTO producto = productoService.obtenerProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST /api/productos - Crear nuevo
    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO dto) {
        ProductoDTO creado = productoService.crearProducto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    
    // PATCH /api/productos/{id}/stock - Actualizar stock
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductoDTO> actualizarStock(
            @PathVariable Long id, 
            @RequestParam Integer cantidad) {
        try {
            ProductoDTO actualizado = productoService.actualizarStock(id, cantidad);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    // GET /api/productos/disponibles - Productos con stock
    @GetMapping("/disponibles")
    public ResponseEntity<List<ProductoDTO>> obtenerDisponibles() {
        List<ProductoDTO> productos = productoService.obtenerProductosDisponibles();
        return ResponseEntity.ok(productos);
    }
}