package com.back.cd.back.cd.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.cd.back.cd.Modelo.codigos;
import com.back.cd.back.cd.Modelo.contactos;
import com.back.cd.back.cd.Modelo.directos;
import com.back.cd.back.cd.Modelo.listaProveedores;
import com.back.cd.back.cd.Modelo.pool;
import com.back.cd.back.cd.Modelo.precios;
import com.back.cd.back.cd.Modelo.wksh;
import com.back.cd.back.cd.Modelo.Repositorio.preciosRepository;


@Service
public class service {
	@Autowired
	private com.back.cd.back.cd.Modelo.Repositorio.listaProveedoresRepository proveedoresRepository;
	@Autowired 
	private com.back.cd.back.cd.Modelo.Repositorio.directosRepository directosRepository;
	@Autowired
	private com.back.cd.back.cd.Modelo.Repositorio.poolRepository poolRepository;
	@Autowired
	private com.back.cd.back.cd.Modelo.Repositorio.contactosRepository contactosRepository;
	@Autowired
	private com.back.cd.back.cd.Modelo.Repositorio.wkshRepository wkshRepository;
	@Autowired
	private com.back.cd.back.cd.Modelo.Repositorio.codigosRepository codigosRepository;
	@Autowired
	private preciosRepository preciosRepository;
	
	@Transactional
	public void actualizarProveedores() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		//\\cernotes\A_Apoyo Sistema\Lista Proveedores Dirección Importaciones.xlsx
		String ruta="\\\\cernotes\\A_Apoyo Sistema\\Lista Proveedores Dirección Importaciones.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
        Sheet sheet = wb.getSheetAt(0);
        proveedoresRepository.deleteAllInBatch();
        List<listaProveedores> listaProv = new ArrayList<>();

        //for (int i=ultimaFila; i>=0; i--) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        	try {
            Row fila = sheet.getRow(i);
            if (fila == null || getCellValue(fila.getCell(0)).isEmpty()) {
                continue; 
            }
            listaProveedores p = new listaProveedores();
            p.setAcreedor(getCellValue(fila.getCell(0)));
            p.setSupplier(getCellValue(fila.getCell(1)));
            p.setPs(getCellValue(fila.getCell(2)));
            p.setNombre_pais(getCellValue(fila.getCell(3)));
            p.setMon(getCellValue(fila.getCell(4)));
            p.setC_pag(getCellValue(fila.getCell(5)));
            p.setDescripcion_cond_pago(getCellValue(fila.getCell(6)));
            p.setResponsable(getCellValue(fila.getCell(7)));
            p.setRespacreedor(getCellValue(fila.getCell(8)));
            p.setDirecc(getCellValue(fila.getCell(9)));
            p.setNif(getCellValue(fila.getCell(10)));
            p.setNif2(getCellValue(fila.getCell(11)));
            p.setIncot(getCellValue(fila.getCell(12)));
            p.setIncoterms2(getCellValue(fila.getCell(13)));
            p.setOrgc(getCellValue(fila.getCell(14)));
            p.setGrupo(getCellValue(fila.getCell(15)));
            //fecha columna Q
            p.setFecha(getDate(fila.getCell(16)));
            p.setConcbusq(getCellValue(fila.getCell(17)));
            p.setCalle(getCellValue(fila.getCell(18)));
            p.setPoblacion(getCellValue(fila.getCell(19)));
            p.setDistrito(getCellValue(fila.getCell(20)));
            p.setCp(getCellValue(fila.getCell(21)));
            p.setTelefono1(getCellValue(fila.getCell(22)));
            p.setNtelefax(getCellValue(fila.getCell(23)));
            p.setRg(getCellValue(fila.getCell(24)));
            listaProv.add(p);
        	}catch (Exception e) {
                System.err.println("Error procesando la fila " + (i + 1) + ": " + e.getMessage());
            }
            if (listaProv.size() >= 500) {
                proveedoresRepository.saveAll(listaProv);
                listaProv.clear();
            }
        }
        if (!listaProv.isEmpty()) {
            proveedoresRepository.saveAll(listaProv);
        }

        proveedoresRepository.saveAll(listaProv);
        wb.close();
	}
	
	@Transactional
	public void actualizarDirectos() throws Exception {
		IOUtils.setByteArrayMaxOverride(200_000_000);
	    String ruta = "\\\\Cernotes\\SEGUIMIENTO ORDENES DE COMPRA IMPORTS\\PO directos.xlsx";
	    Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
	    Sheet sheet = wb.getSheetAt(0);
	    directosRepository.deleteAllInBatch();
	    List<directos> listaDirectos = new ArrayList<>();

	    for (int i = 3; i <= sheet.getLastRowNum(); i++) {
	        Row fila = sheet.getRow(i);
	        if (fila == null || getCellValue(fila.getCell(0)).isEmpty()) break;

	        directos d = new directos();
	        
	        d.setPlaneador(getCellValue(fila.getCell(0)));
	        d.setProveedor(getCellValue(fila.getCell(1)));
	        d.setCodigo(getInt(fila.getCell(2)));
	        d.setDescripcion(getCellValue(fila.getCell(3)));
	        d.setFamilia(getCellValue(fila.getCell(4)));
	        d.setCe(getCellValue(fila.getCell(5)));
	        d.setDailymrpsale(getFloat(fila.getCell(6)));
	        d.setTotal_disponible_pcs(getInt(fila.getCell(7)));
	        d.setTotal_disponible_days(getInt(fila.getCell(8)));
	        d.setPo_pm(getInt(fila.getCell(9)));
	        d.setPo_th(getInt(fila.getCell(10)));
	        d.setFull_consol(getCellValue(fila.getCell(11)));
	        d.setStatus_confirmacion(getCellValue(fila.getCell(12)));

	        // Fechas
	        d.setOpen_purchase_ordersetd(getDate(fila.getCell(13)));
	        d.setOpen_purchase_orderseta(getDate(fila.getCell(14)));
	        d.setPo_qty(getInt(fila.getCell(15)));
	        d.setPo_days(getInt(fila.getCell(16)));
	        d.setSs_days(getInt(fila.getCell(17)));
	        d.setIda(getInt(fila.getCell(18)));
	        d.setOver_stock(getFloat(fila.getCell(19)));
	        d.setAlt_vendor(getCellValue(fila.getCell(20)));
	        d.setContenedor(getCellValue(fila.getCell(21)));
	        d.setFactura(getCellValue(fila.getCell(22)));
	        d.setSar2(getCellValue(fila.getCell(23)));
	        d.setDirecto(getCellValue(fila.getCell(24)));
	        d.setPod(getCellValue(fila.getCell(25)));

	        listaDirectos.add(d);

	        if (listaDirectos.size() >= 500) {
	            directosRepository.saveAll(listaDirectos);
	            listaDirectos.clear();
	        }
	    }
	    if (!listaDirectos.isEmpty()) {
	        directosRepository.saveAll(listaDirectos);
	    }
	}
	@Transactional
	public void actualizarPool() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		String ruta = "\\\\Cernotes\\Matrices de Precio\\6_Reportes de PIs\\Reporte de PI's pool de Matrices.xlsx";
	    Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
	    Sheet sheet = wb.getSheetAt(0);
	    poolRepository.deleteAllInBatch();
	    List<pool> listaPool = new ArrayList<>();
	    
	    for (int i = 3; i <= sheet.getLastRowNum(); i++) {
	    	
	    	 try {

	    	        Row fila = sheet.getRow(i);
	    	        if (fila == null) {
	    	            continue;
	    	        }

	    	        String valorF = getCellValue(fila.getCell(5));
	    	        String valorK = getCellValue(fila.getCell(10));

	    	        if (valorF.isEmpty() || valorK.isEmpty()) {
	    	            continue;
	    	        }

	        pool p = new pool();
	        
	        p.setRecibidas_en_el_dia(getCellValue(fila.getCell(0)));
	        p.setPi(getInt(fila.getCell(1)));
	        p.setBu(getCellValue(fila.getCell(2)));
	        p.setNo_de_proveedor(getCellValue(fila.getCell(3)));
	        p.setProveedor(getCellValue(fila.getCell(4)));
	        p.setOpen_purchase_orders_etd(valorF);
	        p.setUrgente(getCellValue(fila.getCell(6)));
	        p.setIda(getCellValue(fila.getCell(7)));
	        p.setStatus_de_liberacion(getCellValue(fila.getCell(8)));
	        String comentarios = getCellValue(fila.getCell(9)).replace("\u200B", "");
	        p.setComentarios(comentarios);
	        p.setFecha_de_liberacion_rechazo(valorK);
	        p.setSeg_ctrl_doc(getCellValue(fila.getCell(11)));
	        p.setLiberada_por(getCellValue(fila.getCell(12)));
	        p.setAnomalias(getCellValue(fila.getCell(13)));
	        p.setStatus_matriz_dias_transcurridos(getCellValue(fila.getCell(14)));
	        
	        listaPool.add(p);
	        
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	        continue;
	    	 }
	        if (listaPool.size() >= 500) {
	            poolRepository.saveAll(listaPool);
	            listaPool.clear();
	        }
	    }
	    if (!listaPool.isEmpty()) {
	        poolRepository.saveAll(listaPool);
	    }
	    wb.close();
	}
	
	//contactos
	@Transactional
	public void actualizarContactos() throws Exception{
		String ruta="\\\\cernotes\\A_Apoyo Sistema\\Listado de Contactos FR Importaciones-Planeación.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
        Sheet sheetCompradores = wb.getSheet("Compradores");
        Sheet sheetPlaneadores= wb.getSheet("Planeadores");
        contactosRepository.deleteAllInBatch();
        List<contactos> listaContactos = new ArrayList<>();
        // BUSCARV: Grupo de planeadores (Columna B)  Gerente C, Planeador F
        for (int i=1; i <= sheetCompradores.getLastRowNum(); i++) {
        	Row r = sheetCompradores.getRow(i);
        	String grupoCompr = getCellValue(r.getCell(1)); //B
        	String gerente="N/A";
        	String planeador="N/A";
        	for (int j=1; j <= sheetPlaneadores.getLastRowNum(); j++) {
        		Row p = sheetPlaneadores.getRow(j);
        		String grupoPlan = getCellValue(p.getCell(0)); //B
                	if (grupoPlan.equals(grupoCompr)) {
                        gerente = getCellValue(p.getCell(2)); //C ind3
                        planeador = getCellValue(p.getCell(5)); //F ind 6
                        break;
                	} 
            }
        	contactos c= new contactos();
        	c.setGrupo_de_Compras(getCellValue(r.getCell(0)));
            c.setGrupo_de_Planeadores(grupoCompr);
            c.setUnidad_de_Negocio(getCellValue(r.getCell(2)));
            c.setDirector_SR_de_BU(getCellValue(r.getCell(3)));
            c.setDirector_JR_de_BU(getCellValue(r.getCell(6)));
            c.setGte_Responsable_BU(getCellValue(r.getCell(9)));
            c.setComprador(getCellValue(r.getCell(13)));
            c.setAsistente(getCellValue(r.getCell(17)));
            
            c.setGerente_planeacion(gerente);
            c.setPlaneador_planeacion(planeador);
            listaContactos.add(c);
        }

        if (listaContactos.size() >= 500) {
            contactosRepository.saveAll(listaContactos);
            listaContactos.clear();
        }
        if (!listaContactos.isEmpty()) {
            contactosRepository.saveAll(listaContactos);
        }
    }
	
	@Transactional
	public void actualizarWksh() throws Exception{
		String ruta="\\\\cernotes\\SEGUIMIENTO ORDENES DE COMPRA IMPORTS\\Calculadora\\";
	    File dire = new File(ruta);
	    File[] archivo = dire.listFiles((dir, name) -> name.startsWith("VALIDAR TC Y MP"));
	    File archivoE = archivo[0];
	    
		Workbook wb = WorkbookFactory.create(new FileInputStream(archivoE));
        Sheet sheet = wb.getSheetAt(0);
        wkshRepository.deleteAllInBatch();
        
        List<wksh> listaWksh = new ArrayList<>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++) {
        	Row fila= sheet.getRow(i);
        	
        	wksh w=new wksh();
        	int noProv = getInt(fila.getCell(0)); 
            String nombreProv = getCellValue(fila.getCell(1));
            String bu = getCellValue(fila.getCell(2)); 
            String tcMp = getCellValue(fila.getCell(3)); 

            w.setNo_Proveedor(noProv);
            w.setNombre_del_proveedor(nombreProv);
            w.setBU(bu);
            //concat
            w.setConcatenar(noProv + bu);
            w.setTC_MP(tcMp);
            
        	listaWksh.add(w);
        	if (listaWksh.size() >= 500) {
                wkshRepository.saveAll(listaWksh);
                listaWksh.clear();
            }

        }
        if (!listaWksh.isEmpty()) {
            wkshRepository.saveAll(listaWksh);
        }
	}
	
	@Transactional
	public void actualizarCodigos() throws Exception{
		codigosRepository.deleteAllInBatch();
		
		String rutas[]={"\\\\cernotes\\A_Apoyo Sistema\\Lista Codigos Direccion Importaciones.xls",
				"\\\\cernotes\\A_Apoyo Sistema\\Listado Codigos Refacciones.xlsm"};
		for(int i=0; i<rutas.length; i++) {
			String rutaActual=rutas[i];
			int tipoArchivo=i+1;
			Workbook wb = WorkbookFactory.create(new FileInputStream(rutaActual));
		    Sheet sheet = wb.getSheetAt(0);
		    List<codigos> listaCodigos= new ArrayList<>();
		    //List<codigos> totalProcesados = new ArrayList<>();
		    
		    //lsitado 1: "importaciones" inicia en fila 2 (indice 1)
		    //listado 2: "refaccciones" inicia en fila 3 (indice 2)
		    int filaInicio;
		    if(tipoArchivo==1) {
		    	filaInicio=1;
		    }else filaInicio=2;
		    for (int j = filaInicio; j <= sheet.getLastRowNum(); j++) {
                Row fila = sheet.getRow(j);
                if (fila == null) continue;
                codigos c = new codigos();
                if(tipoArchivo==1) {
                	c.setCodigo(getInt(fila.getCell(0)));
                	c.setClave(getCellValue(fila.getCell(1)));
                	c.setDescripcion(getCellValue(fila.getCell(2)));
                	c.setClvFamSAP(getCellValue(fila.getCell(3)));
                	c.setFamiliaSAP(getCellValue(fila.getCell(4)));
                	c.setMarcaComercial(getCellValue(fila.getCell(5)));
                	}else {
                        c.setCodigo(getInt(fila.getCell(0)));
                        c.setClave(getCellValue(fila.getCell(1)));
                        c.setDescripcion(getCellValue(fila.getCell(2))); 
                        c.setUnidadDeNegocio(getCellValue(fila.getCell(8))); 
                	}
                	listaCodigos.add(c);
                	if (listaCodigos.size() >= 500) {
                        codigosRepository.saveAll(listaCodigos);
                        listaCodigos.clear();
                    }
                }
		    if (!listaCodigos.isEmpty()) {
                codigosRepository.saveAll(listaCodigos);
            }
		}
	}
	        
	@Transactional
	public void actualizarPrecios() throws Exception {
	    IOUtils.setByteArrayMaxOverride(200_000_000);
	    preciosRepository.deleteAllInBatch();
	    String[] nombresBase = {"Lista de precios ", "Lista de precios Refacciones "};
	    for (int listado = 0; listado < nombresBase.length; listado++) {
	        String nom = nombresBase[listado];
	        File archivo = null;
	        for (int d = 0; d < 10; d++) {
	            String fecha = java.time.LocalDate.now().minusDays(d).format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
	            String rutaCompleta = "\\\\Isilon2truperdata\\Importaciones\\SAP\\" + nom + fecha + ".xlsx";
	            File archivoO = new File(rutaCompleta);
	            if (archivoO.exists()) {
	                archivo = archivoO;
	                break;
	            }
	        }
	        try (InputStream is = new FileInputStream(archivo);
	             Workbook wb = WorkbookFactory.create(is)) {
	            Sheet sheet = wb.getSheetAt(0);
	            List<precios> listaPrecios = new ArrayList<>();
	                
	            for (int j = 11; j <= sheet.getLastRowNum(); j++) {
	                if (j % 2 == 0) continue; 
	                Row fila = sheet.getRow(j);
	                if (fila == null) continue;

	                String material= getCellValue(fila.getCell(5));
	                String proveedor=getCellValue(fila.getCell(2));
	                String precioT= getCellValue(fila.getCell(7));
	                
	                precios p = new precios();
	                p.setProveedor(proveedor);
	                p.setMaterial(material);
	                p.setPrecio(new java.math.BigDecimal(precioT));
	                p.setMoneda(getCellValue(fila.getCell(8)));
	                p.setMaterialproveedor(material + proveedor);
	                listaPrecios.add(p);
	                if (listaPrecios.size() >= 500) {
	                    preciosRepository.saveAll(listaPrecios);
	                    listaPrecios.clear();
	                }
	            }
	            if (!listaPrecios.isEmpty()) {
	                preciosRepository.saveAll(listaPrecios);
	            }
	        } catch (Exception e) {
	            System.err.println("Error al abrir " + archivo.getName() + ": " + e.getMessage());
	        }
	    }
	}
	//FUNCIONES AUX 
	private LocalDate getDate(Cell cell) {
	    if (cell != null && DateUtil.isCellDateFormatted(cell)) {
	        if (cell.getLocalDateTimeCellValue() != null) {
	            return cell.getLocalDateTimeCellValue().toLocalDate();
	        }
	    }
	    return null;
	}
	
	//String a int 
	private int getInt(Cell cell) {
	    String val = getCellValue(cell);
	    if (val.isEmpty() || val.equalsIgnoreCase("NUEVO")) { //directos
	        return 0;
	    }
	    if (val.equalsIgnoreCase("rp")) { //pool
	        return 99999;
	    }
	    try {//excel decimales
	        return (int) Double.parseDouble(val);
	    } catch (Exception e) {
	        return 0; // ¿? 
	    }
	}
	private float getFloat(Cell cell) {
	    String val = getCellValue(cell);
	    if (val.isEmpty()) return 0.0f;
	    try { return Float.parseFloat(val);
	    } catch (Exception e) {return 0.0000f; }
	}
	
	private String getCellValue(Cell cell) {

	    if (cell == null) return "";

	    switch (cell.getCellType()) {

	        case STRING:
	            return cell.getStringCellValue().trim();

	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getLocalDateTimeCellValue().toLocalDate().toString();
	            }
	            double valor = cell.getNumericCellValue();
	            java.math.BigDecimal bd = new java.math.BigDecimal(String.valueOf(valor));
	            if (valor==(long) valor) {
	                return String.valueOf((long) valor);
	            } else {
	                return bd.toPlainString();
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());

	        case FORMULA:
	            return cell.getCellFormula();

	        case BLANK:
	            return "";

	        default:
	            return "";
	    }
	}
}