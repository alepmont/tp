package com.example.tpractico1.dao;

import com.example.tpractico1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {
    // Spring Data JPA genera automáticamente: save, findById, findAll, delete, etc.
    
    // Métodos personalizados
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByPrecioLessThan(Double precio);
    List<Producto> findByStockGreaterThan(Integer stock);
}