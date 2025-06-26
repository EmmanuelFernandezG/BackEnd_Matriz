package com.back.cd.back.cd.Modelo;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocDTO {

    private Long foliott;
    private Long nooc;
    private String unidad_de_negocio;
    private Long no_de_proveedor;
    private LocalDate fecha_de_embarque_de_laoc;
    private Double monto_de_po;
    private String moneda;
    private String gerente_de_compras;
    private String confirmador;
    private String proveedor;
    private String pto_directo;
    private String validaciones_extraordinarias;

}


