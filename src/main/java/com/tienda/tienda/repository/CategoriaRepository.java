/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.tienda.repository;

import com.tienda.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public List<Categoria> findByActivoTrue();

//practicaa02 consultar categorias activas segun x cantidad de productos
    @Query(value = "SELECT c FROM Categoria c JOIN c.productos p "
            + "WHERE c.activo = true AND p.activo = true "
            + "GROUP BY c "
            + "HAVING COUNT(p) >= :minimo "
            + "ORDER BY COUNT(p) DESC, c.descripcion ASC")
    public List<Categoria> consultaCategoriaFiltro(@Param("minimo") Long minimo);    
    
}
