package com.cate.practica.nuevos.conceptos.colecciones.SGCM.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGCM.enums.EstadoBoleta;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.enums.TipoBoleta;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.util.ValidacionesAtributos;

import java.time.LocalDateTime;

public class Boleto {
    private final String codigo;
    private LocalDateTime creadoEn;
    private LocalDateTime vendidoEn;
    private EstadoBoleta estadoBoleta;
    private double precioBase;
    private TipoBoleta tipoBoleta;

    public Boleto(double precioBase, TipoBoleta tipoBoleta) {
        this.codigo = "codigo++";
        this.creadoEn = LocalDateTime.now();
        this.vendidoEn = null;
        this.precioBase = precioBase;
        this.tipoBoleta = tipoBoleta;
        this.estadoBoleta = EstadoBoleta.DISPONIBLE;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public TipoBoleta getTipoBoleta() {
        return tipoBoleta;
    }

    public void setTipoBoleta(TipoBoleta tipoBoleta) {
        ValidacionesAtributos.validarObjetosnNulo(tipoBoleta, "TipoBoleta");
        this.tipoBoleta = tipoBoleta;
    }

    private void venderBoleta() {
        this.vendidoEn = LocalDateTime.now();
        this.estadoBoleta = EstadoBoleta.VENDIDO;
    }
    private void cambiarEstadoBoletaCancelado() {
        this.estadoBoleta = EstadoBoleta.CANCELADO;
    }

    public double calcularPrecioBoleta() {
        double precioBoleta = 0;
        precioBoleta = precioBase + getTipoBoleta().getPrecio();
        venderBoleta();
        return precioBoleta;
    }
}
