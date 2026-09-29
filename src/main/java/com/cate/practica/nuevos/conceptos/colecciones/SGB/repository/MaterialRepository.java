package com.cate.practica.nuevos.conceptos.colecciones.SGB.repository;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.model.Material;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena y opera sobre los materiales de la biblioteca.
 * @author Cate
 */

public class MaterialRepository {
    private List<Material> materiales = new ArrayList<>();

    public void addMaterial(Material material) {
        Validaciones.validarObjetosnNulo(material, "Material");
        materiales.add(material);
    }






}
