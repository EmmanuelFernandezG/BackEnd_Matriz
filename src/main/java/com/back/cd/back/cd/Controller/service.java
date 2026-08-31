package com.back.cd.back.cd.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.cd.back.cd.Modelo.Arancel_Modelo;
import com.back.cd.back.cd.Modelo.Codigos_Planeador_Modelo;
import com.back.cd.back.cd.Modelo.Contactos_Planta_Modelo;
import com.back.cd.back.cd.Modelo.Fabricas_Modelo;
import com.back.cd.back.cd.Modelo.MatrizCalculadora_Modelo;
import com.back.cd.back.cd.Modelo.Tppm_Modelo;
import com.back.cd.back.cd.Modelo.bufferPlanta_Modelo;
import com.back.cd.back.cd.Modelo.codigos;
import com.back.cd.back.cd.Modelo.contactos;
import com.back.cd.back.cd.Modelo.directos;
import com.back.cd.back.cd.Modelo.listaProveedores;
import com.back.cd.back.cd.Modelo.pool;
import com.back.cd.back.cd.Modelo.precios;
import com.back.cd.back.cd.Modelo.wksh;
import com.back.cd.back.cd.Modelo.Repositorio.Arancel_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Codigos_Planeador_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Contactos_Planta_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Fabricas_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Matriz_Calculadora_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Tp_Pm_Repository;
import com.back.cd.back.cd.Modelo.Repositorio.bufferPlanta_Repositorio;
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
	@Autowired
	private Fabricas_Repositorio fabricas_Repositorio;
	@Autowired
	private Arancel_Repositorio arancel_Repositorio;
	@Autowired
	private Tp_Pm_Repository tp_pm_Repository;
	@Autowired
	private Matriz_Calculadora_Repositorio matriz_Calculadora_Repositorio;
	@Autowired
	private bufferPlanta_Repositorio bufferPlanta_Repositorio;
	@Autowired
	private Codigos_Planeador_Repositorio codigos_Planeador_Repositorio;
	@Autowired
	private Contactos_Planta_Repositorio contactos_Planta_Repositorio;
	
	@Transactional
	public void actualizarArancel() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		String ruta="\\\\cernotes\\Formatos Vigentes-PARCELMOBI\\% arancel PM.xlsx";
		Workbook wb= WorkbookFactory.create(new FileInputStream(ruta));
		Sheet sheet= wb.getSheetAt(0);
		arancel_Repositorio.Truncararancel();
		List<Arancel_Modelo> arancel= new ArrayList<>();
		for (int i=1; i<=sheet.getLastRowNum(); i++) {
			try {
	            Row fila = sheet.getRow(i);
	            if (fila == null || getCellValue(fila.getCell(0)).isEmpty()) {
	                continue; 
	            }
	            Arancel_Modelo a = new Arancel_Modelo();
	            a.setProveedor(getCellValue(fila.getCell(0)));
	            a.setNombre_proveedor(getCellValue(fila.getCell(1)));
	            a.setMaterial(getCellValue(fila.getCell(2)));
	            a.setCentro(getCellValue(fila.getCell(3)));
	            a.setPorcentaje(getCellValue(fila.getCell(4)));

	            arancel.add(a);
	        	}catch (Exception e) {
	                System.err.println("Error procesando la fila " + (i + 1) + ": " + e.getMessage());
	            }
	            if (arancel.size() >= 500) {
	                arancel_Repositorio.saveAll(arancel);
	                arancel.clear();
	            }
	        }
	        if (!arancel.isEmpty()) {
	        	arancel_Repositorio.saveAll(arancel);
	        }

	        arancel_Repositorio.saveAll(arancel);
	        wb.close();
	}
	
	@Transactional
	public void actualizarFabricas() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		String ruta="\\\\cernotes\\A_Apoyo Sistema\\Fabricas Importaciones.xlsx";
		Workbook wb= WorkbookFactory.create(new FileInputStream(ruta));
		Sheet sheet= wb.getSheetAt(0);
		fabricas_Repositorio.Truncarfabricas();
		List<Fabricas_Modelo> fabricas= new ArrayList<>();
		for (int i=1; i<=sheet.getLastRowNum(); i++) {
			try {
	            Row fila = sheet.getRow(i);
	            if (fila == null || getCellValue(fila.getCell(0)).isEmpty()) {
	                continue; 
	            }
	            Fabricas_Modelo f = new Fabricas_Modelo();
	            f.setCodigo(getCellValue(fila.getCell(0)));
	            f.setClave(getCellValue(fila.getCell(1)));
	            f.setSap_prov_real(getCellValue(fila.getCell(2)));
	            f.setNombre_prov_real(getCellValue(fila.getCell(3)));
	            f.setSap_fabrica(getCellValue(fila.getCell(4)));
	            f.setNombre_fabrica(getCellValue(fila.getCell(5)));

	            fabricas.add(f);
	        	}catch (Exception e) {
	                System.err.println("Error procesando la fila " + (i + 1) + ": " + e.getMessage());
	            }
	            if (fabricas.size() >= 500) {
	                fabricas_Repositorio.saveAll(fabricas);
	                fabricas.clear();
	            }
	        }
	        if (!fabricas.isEmpty()) {
	        	fabricas_Repositorio.saveAll(fabricas);
	        }

	        fabricas_Repositorio.saveAll(fabricas);
	        wb.close();
	}
	
	@Transactional
	public void actualizarProveedores() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		String ruta="\\\\cernotes\\A_Apoyo Sistema\\Lista Proveedores Dirección Importaciones.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
        Sheet sheet = wb.getSheetAt(0);
        proveedoresRepository.Truncarlistaproveedores();
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
	    
	    List<directos> listaDirectos = new ArrayList<>();
	    directosRepository.Truncardirectos();
	    /*Row filaTitulos = sheet.getRow(1); 
	    for (int c = 0; c < filaTitulos.getLastCellNum(); c++) {
	        System.out.println("indice [" + c + "]: " + getCellValue(filaTitulos.getCell(c)));
	    }*/
	    
	    for (int i = 2; i <= sheet.getLastRowNum(); i++) {
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
	        d.setTotal_disponible_pcs(getInt(fila.getCell(13)));
	        d.setTotal_disponible_days(getInt(fila.getCell(14)));
	        Cell cell15 = fila.getCell(15);
	        d.setPo_pm(cell15 == null || cell15.getCellType() == CellType.BLANK ? getInt(fila.getCell(16)) : getInt(cell15) );
	        d.setPo_th(getInt(fila.getCell(16)));
	        d.setPo_th(getInt(fila.getCell(16)));
	        d.setFull_consol(getCellValue(fila.getCell(18)));
	        d.setStatus_confirmacion(getCellValue(fila.getCell(19)));

	        // Fechas
	        d.setOpen_purchase_ordersetd(getDate(fila.getCell(20)));
	        d.setOpen_purchase_orderseta(getDate(fila.getCell(21)));
	        d.setPo_qty(getInt(fila.getCell(24)));
	        d.setPo_days(getInt(fila.getCell(27)));
	        d.setSs_days(getInt(fila.getCell(28)));
	        d.setIda(getInt(fila.getCell(29)));
	        d.setOver_stock(getFloat(fila.getCell(36)));
	        d.setAlt_vendor(getCellValue(fila.getCell(38)));
	        d.setContenedor(getCellValue(fila.getCell(39)));
	        d.setFactura(getCellValue(fila.getCell(40)));
	        d.setSar2(getCellValue(fila.getCell(41)));
	        d.setDirecto(getCellValue(fila.getCell(42)));
	        d.setPod(getCellValue(fila.getCell(43)));
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
	    poolRepository.Truncarpool();
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
	    String rutaExtra="\\\\cernotes\\SEGUIMIENTO ORDENES DE COMPRA IMPORTS\\Matr\\pool Extra data.xlsx";
	    Workbook wbExtra = WorkbookFactory.create(new FileInputStream(rutaExtra));
	    Sheet sheetExtra = wbExtra.getSheetAt(0);
	    
	    //fila2
	    for (int j = 1; j <= sheetExtra.getLastRowNum(); j++) {
	    	Row filaExtra = sheetExtra.getRow(j);
            if (filaExtra == null) continue;
	        int piDelExcel = getInt(filaExtra.getCell(0)); //col A
	        pool extra = new pool();
	        
	        extra.setRecibidas_en_el_dia("manual");
	        
	        extra.setPi(piDelExcel);
	        extra.setBu("BU");
        	extra.setNo_de_proveedor("727844");				
	        extra.setProveedor("Prov Gen");
	        extra.setOpen_purchase_orders_etd("2026-01-01");
	        extra.setUrgente("NO");
	        extra.setIda("1");
	        extra.setStatus_de_liberacion("N/A");
	        extra.setComentarios("Registro agregado manual");
	        extra.setFecha_de_liberacion_rechazo("2026-01-01");
	        extra.setSeg_ctrl_doc("DOC");
	        extra.setLiberada_por("SYSTEM");
	        extra.setAnomalias("");
	        extra.setStatus_matriz_dias_transcurridos("0");

	        listaPool.add(extra);
	        
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
        contactosRepository.Truncarcontactos();
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
        wkshRepository.Truncarwksh();
        
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
		codigosRepository.Truncarcodigos();
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
                	c.setContactos(getCellValue(fila.getCell(6)));                	
                    c.setUnidadDeNegocio(getCellValue(fila.getCell(7))); 
                	
                	}else {
                    	c.setCodigo(getInt(fila.getCell(0)));
                    	c.setClave(getCellValue(fila.getCell(1)));
                    	c.setDescripcion(getCellValue(fila.getCell(2)));
                    	c.setClvFamSAP(getCellValue(fila.getCell(0)));
                    	c.setFamiliaSAP(getCellValue(fila.getCell(1)));
                    	c.setMarcaComercial(getCellValue(fila.getCell(8)));
                    	c.setContactos(getCellValue(fila.getCell(9)));                	
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
	    preciosRepository.Truncarprecios();
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
	
	@Transactional
	public void actualizarTPPM() throws Exception{
		tp_pm_Repository.Truncartppm();
		String rutas= "\\\\cernotes\\Publico\\Z_FormatoTEST\\TST Rev\\BaseCalc.xlsm";
			String rutaActual=rutas;
			Workbook wb = WorkbookFactory.create(new FileInputStream(rutaActual));
		    Sheet sheet = wb.getSheet("Hoja1");
		    List<Tppm_Modelo> tppm_modelo= new ArrayList<>();
		    for (int j = 2; j <= sheet.getLastRowNum(); j++) {
                Row fila = sheet.getRow(j);
                if (fila == null || getInt(fila.getCell(0)) == 0) continue;
                Tppm_Modelo c = new Tppm_Modelo();
                		c.setPo(getInt(fila.getCell(0)));
                		c.setProveedor(getCellValue(fila.getCell(1)));
                		c.setPosicion(getInt(fila.getCell(2)));
                		c.setCantidad(getInt(fila.getCell(7)));
            			c.setMoneda(getCellValue(fila.getCell(12)));
            			c.setMaterial(getInt(fila.getCell(13)));
                		c.setClave(getCellValue(fila.getCell(14)));
                		c.setPoth(getInt(fila.getCell(27)));
                		c.setEtd(getDate(fila.getCell(6)));
                		c.setPrecio(getFloat(fila.getCell(11)));
                		tppm_modelo.add(c);
                	if (tppm_modelo.size() >= 500) {
                        tp_pm_Repository.saveAll(tppm_modelo);
                        tppm_modelo.clear();
                    }
                }
		    if (!tppm_modelo.isEmpty()) {
		    	tp_pm_Repository.saveAll(tppm_modelo);
            }
		    wb.close();
	}
	@Transactional 
	public void actualizarMatrizCalculadora() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		File archivo = null;
		for(int d=0; d<10; d++) {
			String fecha = java.time.LocalDate.now().minusDays(d).format(java.time.format.DateTimeFormatter.ofPattern("ddMMyy"));
			String ruta="\\\\Cernotes\\seguimiento ordenes de compra imports\\Calculadora\\Listado de Items-Proveedores con matriz firmada o de Referencia al "+fecha+".xlsx";
			File archivoO = new File(ruta);
            if (archivoO.exists()) {
                archivo = archivoO;
                break;
            }
		}
		try (InputStream is = new FileInputStream(archivo);
	             Workbook wb = WorkbookFactory.create(is)) {
	    Sheet sheet = wb.getSheetAt(0);
	    matriz_Calculadora_Repositorio.TruncarMatrizCalculadora();
	    
	    List<MatrizCalculadora_Modelo> matrizCalc = new ArrayList<>();
        for(int i = 6; i <= sheet.getLastRowNum(); i++) {
        	Row fila= sheet.getRow(i);
        	
        	MatrizCalculadora_Modelo mc=new MatrizCalculadora_Modelo();
        	mc.setCodigo(getCellValue(fila.getCell(0)));
        	mc.setClave(getCellValue(fila.getCell(1)));
        	mc.setDescripcion(getCellValue(fila.getCell(2)));
        	mc.setFamilia(getCellValue(fila.getCell(3)));
        	mc.setBu(getCellValue(fila.getCell(4)));
        	mc.setTipomatriz(getCellValue(fila.getCell(5)));
        	mc.setNo_proveedor(getCellValue(fila.getCell(6)));
        	mc.setProveedor(getCellValue(fila.getCell(7)));        	
            
        	matrizCalc.add(mc);
        	if (matrizCalc.size() >= 500) {
                matriz_Calculadora_Repositorio.saveAll(matrizCalc);
                matrizCalc.clear();
            }

        }
        if (!matrizCalc.isEmpty()) {
        	matriz_Calculadora_Repositorio.saveAll(matrizCalc);
        }
		} catch (Exception e) {
            System.err.println("Error al abrir " + archivo.getName() + ": " + e.getMessage());
        }
	
	}

	@Transactional 
	public void actualizarBufferPlanta() throws Exception{
		IOUtils.setByteArrayMaxOverride(200_000_000);
		File archivo = null;
		for(int d=0; d<10; d++) {
			String fecha = java.time.LocalDate.now().minusDays(d).format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
			String ruta="\\\\cernotes\\Publico\\comparte\\Planeacion\\Buffer 2019\\Informe Buffer " +fecha+".xlsx";
			File archivoO = new File(ruta);
            if (archivoO.exists()) {
                archivo = archivoO;
                break;
            }
		}
		
		try (InputStream is = new FileInputStream(archivo);
	             Workbook wb = WorkbookFactory.create(is)) {
	    Sheet sheet = wb.getSheetAt(0);
	    bufferPlanta_Repositorio.TruncarBufferPlanta();
	    
	    List<bufferPlanta_Modelo> bufferPlanta = new ArrayList<>();
        for(int i=3; i <= sheet.getLastRowNum(); i++) {
        	Row fila= sheet.getRow(i);
        	
        	bufferPlanta_Modelo bp=new bufferPlanta_Modelo();
        	bp.setPlanta(getCellValue(fila.getCell(0)));
        	bp.setPlaneador(getCellValue(fila.getCell(1)));
        	bp.setProveedor(getCellValue(fila.getCell(2)));
        	bp.setCodigo(getInt(fila.getCell(3)));
        	bp.setClave(getCellValue(fila.getCell(4))); 
        	bp.setExclusiva_materia_prima(getCellValue(fila.getCell(5)));
        	bp.setFamilia(getCellValue(fila.getCell(6))); 
        	bp.setTipo_orden(getCellValue(fila.getCell(7)));
        	bp.setVar_fsct(getCellValue(fila.getCell(8)));
        	bp.setInv_disp_piezas(getInt(fila.getCell(9)));
        	bp.setInv_disp_dias(getInt(fila.getCell(10)));
        	bp.setPiezas(getInt(fila.getCell(11)));
        	bp.setDias_consumo(getInt(fila.getCell(12)));
        	bp.setSs(getInt(fila.getCell(13)));
        	bp.setTotal_dias(getInt(fila.getCell(14)));
        	bp.setPcd(getInt(fila.getCell(15)));
        	bp.setAlm_07_piezas(getInt(fila.getCell(16)));
        	bp.setAlm_07_dias(getInt(fila.getCell(17)));
        	bp.setPo(getCellValue(fila.getCell(18)));
        	bp.setPo_th(getCellValue(fila.getCell(19)));
        	bp.setSar(getCellValue(fila.getCell(20)));
        	bp.setFc(getCellValue(fila.getCell(21)));
        	bp.setEstatus_confirmacion(getCellValue(fila.getCell(22)));
        	bp.setEtd(getDate(fila.getCell(23)));
        	bp.setEta(getDate(fila.getCell(24)));       	
            bp.setSd_vs_pi(getCellValue(fila.getCell(25)));
            
            String valorCantidad= getCellValue(fila.getCell(26));
            if(valorCantidad.isEmpty()) {
            	bp.setFilaAmarilla("Amarillo");
            	bp.setCantidad(getCellValue(fila.getCell(26)));
            }else {
            	bp.setFilaAmarilla("Blanco");
            	bp.setCantidad(getCellValue(fila.getCell(26)));
            }
            bp.setCob_real(getCellValue(fila.getCell(27)));
            bp.setCob_plan(getCellValue(fila.getCell(28)));
            bp.setVar_dias_lt(getCellValue(fila.getCell(29)));
            bp.setIdB(getCellValue(fila.getCell(30)));
            bp.setIda(getInt(fila.getCell(31)));
            bp.setPa(getCellValue(fila.getCell(32)));
            bp.setPico_teorico(getCellValue(fila.getCell(33)));
            bp.setProv(getCellValue(fila.getCell(34)));
            bp.setOrden_sugerida(getCellValue(fila.getCell(35)));
            bp.setFecha_emision_po(getDate(fila.getCell(36)));
            bp.setFecha_embarque(getDate(fila.getCell(37)));
            bp.setCantidad_sugerida(getCellValue(fila.getCell(38)));
            bp.setFecha_quemada(getCellValue(fila.getCell(39)));
            bp.setDias_inv(getCellValue(fila.getCell(40)));
            bp.setNota(getCellValue(fila.getCell(41)));
            bp.setNo_sar(getCellValue(fila.getCell(42)));
            bp.setContenedor(getCellValue(fila.getCell(43)));
            bp.setFactura(getCellValue(fila.getCell(44)));
            bp.setM3(getCellValue(fila.getCell(45)));
            bp.setPeso(getCellValue(fila.getCell(46)));
            bp.setPriority(getCellValue(fila.getCell(47)));
            
        	bufferPlanta.add(bp);
        	if (bufferPlanta.size() >= 500) {
                bufferPlanta_Repositorio.saveAll(bufferPlanta);
                bufferPlanta.clear();
            }
        }
        if (!bufferPlanta.isEmpty()) {
        	bufferPlanta_Repositorio.saveAll(bufferPlanta);
        }
		} catch (Exception e) {
            System.err.println("Error al abrir " + archivo.getName() + ": " + e.getMessage());
        }}
	@Transactional
	public void actualizarCodigosPlaneador() throws Exception{
		String ruta="\\\\TFSJIL01\\Planeacion_Control_Documental\\Buffer\\PO's sin PI\\CODIGOS POR PLANEADOR.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
        Sheet sheetPlaneador= wb.getSheet("Planeador");
        codigos_Planeador_Repositorio.TruncarCodigosPlaneador();
        List<Codigos_Planeador_Modelo> codigosPlan = new ArrayList<>();
        for (int i=1; i <= sheetPlaneador.getLastRowNum(); i++) {
        	Row r = sheetPlaneador.getRow(i);
        	if (r == null || getInt(r.getCell(0)) == 0) continue;
        	Codigos_Planeador_Modelo c= new Codigos_Planeador_Modelo();
        	c.setItem(getCellValue(r.getCell(0)));
        	c.setNombre_planner(getCellValue(r.getCell(1)));
        	c.setGerente_planner(getCellValue(r.getCell(2)));
        	c.setDescripcion(getCellValue(r.getCell(3)));
        	c.setComprador(getCellValue(r.getCell(4)));
        	
        	codigosPlan.add(c);
        }
        if (codigosPlan.size() >= 500) {
            codigos_Planeador_Repositorio.saveAll(codigosPlan);
            codigosPlan.clear();
        }
        if (!codigosPlan.isEmpty()) {
        	codigos_Planeador_Repositorio.saveAll(codigosPlan);
        }
    }

	@Transactional
	public void actualizarContactosPlanta() throws Exception{
		String ruta="\\\\TFSJIL01\\Ordenes de Compra\\REPORTES\\Directorio.xlsx";
		Workbook wb = WorkbookFactory.create(new FileInputStream(ruta));
        Sheet sheet= wb.getSheet("Hoja1");
        contactos_Planta_Repositorio.TruncarContactosPlanta();
        List<Contactos_Planta_Modelo> contactosPlan = new ArrayList<>();
        for (int i=2; i <= sheet.getLastRowNum(); i++) {
        	Row r = sheet.getRow(i);
        	Contactos_Planta_Modelo c= new Contactos_Planta_Modelo();
        	c.setResponsable(getCellValue(r.getCell(1)));
        	c.setGerente(getCellValue(r.getCell(2)));
        	c.setRol(getCellValue(r.getCell(3)));
        	c.setCorrespondencia(getCellValue(r.getCell(4)));
        	c.setBu(getCellValue(r.getCell(5)));
        	contactosPlan.add(c);
        }
        if (contactosPlan.size() >= 500) {
            contactos_Planta_Repositorio.saveAll(contactosPlan);
            contactosPlan.clear();
        }
        if (!contactosPlan.isEmpty()) {
        	contactos_Planta_Repositorio.saveAll(contactosPlan);
        }
    }
	
	//FUNCIONES AUX 
	private LocalDate getDate(Cell cell) {
		String valordecelda = "";
		LocalDate fechaFormateada = null;
		if (cell.getCellType() == CellType.STRING) {
			valordecelda = cell.getStringCellValue().trim();	
			valordecelda = cell.getStringCellValue().trim();
			if (valordecelda.contains(".")) {
		        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		        LocalDate fecha = LocalDate.parse(valordecelda, formatoEntrada);
		        fechaFormateada = fecha; 
		    }
			return fechaFormateada;
		}else { if (cell != null && DateUtil.isCellDateFormatted(cell)) {
	        if (cell.getLocalDateTimeCellValue() != null) {
	            return cell.getLocalDateTimeCellValue().toLocalDate();
	        }
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