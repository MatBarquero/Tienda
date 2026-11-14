
package com.tienda.tienda.controller;

import org.springframework.stereotype.Controller;
import com.tienda.tienda.service.CategoriaService;
import com.tienda.tienda.service.ProductoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author barqu
 * Practica #2: controlador para la consulta
 */

@Controller
@RequestMapping("/consultas")
public class CategoriaFiltroController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public CategoriaFiltroController(ProductoService productoService,
            CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @PostMapping("/consultaCategoriaFiltro")
    public String consultaCategoriaFiltro(@RequestParam() Long minimo,
            Model model) {
        var categoriasFiltro = categoriaService.consultaCategoriaFiltro(minimo);
        model.addAttribute("categoriasFiltro", categoriasFiltro);
        model.addAttribute("minimo", minimo);


        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/consultas/listado";
    }
}
