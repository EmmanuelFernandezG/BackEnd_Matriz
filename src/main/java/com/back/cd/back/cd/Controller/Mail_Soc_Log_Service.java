package com.back.cd.back.cd.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.cd.back.cd.Modelo.MailDTO;
import com.back.cd.back.cd.Modelo.listaProveedores;
import com.back.cd.back.cd.Modelo.Repositorio.listaProveedoresRepository;

@Service
public class Mail_Soc_Log_Service {
	//private static final String rutaProv="\\\\TFSJIL01\\Planeacion_Control_Documental\\Contacto de Proveedores.xlsx";
	@Autowired
	private listaProveedoresRepository listaProveedoresRepository;
	
	public List<MailDTO> correos(List<Map<String, Object>> filas){
		Map<String, List<Map<String, Object>>> agrupados=filas.stream().collect(Collectors.groupingBy(f-> String.valueOf(f.getOrDefault("no_de_proveedor", "")).trim()));
		List<MailDTO> borrador=new ArrayList<>();
		for(Map.Entry<String, List<Map<String, Object>>> entry : agrupados.entrySet()) {
            String noProv = entry.getKey();
            List<Map<String, Object>> pos=entry.getValue();
            if(noProv.isEmpty()) continue;
            Map<String, Object> primeraFila = pos.get(0);
            String nombreProveedor=String.valueOf(primeraFila.getOrDefault("nombreProveedor", ""));
            List<String> poUnicas= new ArrayList<>();
            List<String> rutasArchivos = new ArrayList<>();
            Set<String> setCopiasCC = new HashSet<>(); // no repetir corr cc
            String tipog="";
            String noRg="";
            boolean nacionalg= false;
            boolean esPiOkg= false;
            for (Map<String,Object> fila : pos) {
                String nopo = String.valueOf(fila.getOrDefault("nopo", "")).trim();
                String nooc = String.valueOf(fila.getOrDefault("nooc", "")).trim();
                String statusProblema = String.valueOf(fila.getOrDefault("status_problema", "")).toUpperCase().trim();
                String nombreg = String.valueOf(fila.getOrDefault("gte_responsable_bu", "")).toUpperCase().trim();
                String gerente=(nombreg).split("\\s+")[0];
                String bu= String.valueOf(fila.getOrDefault("unidad_de_negocio", "")).toUpperCase().trim();
                String rea = String.valueOf(fila.getOrDefault("numero_reimp", "")).trim();
                String pik= String.valueOf(fila.getOrDefault("piok", "")).trim();
                boolean espok= pik.equals("PI OK") ;
                esPiOkg=espok;
                
                boolean esNacional = nopo.isEmpty() || nopo.equalsIgnoreCase(nooc);
                nacionalg= esNacional;
                String nacionalPO = esNacional ? nooc : nopo;
                String opcionalPO = esNacional ? nopo : nooc  ;
                
                if (!nacionalPO.isEmpty() && !poUnicas.contains(nacionalPO)) {
                    poUnicas.add(nacionalPO);
                }
                boolean esUrgente = statusProblema.contains("URGENTE");
              
                if(statusProblema.contains("DIRECTA")){
                	tipog="Directa";
                }else if(esUrgente) {
                	tipog="Urgente";
                }
                if(rea.startsWith("R")) {
                	noRg="R";
                }else if(!rea.startsWith("EA")){
                	noRg="N";
                }else {
                	noRg="";
                }
                
                String rutaPDF = rutaPDF(nacionalPO, gerente, rea, esUrgente, opcionalPO , nombreg);
                if (rutaPDF != null && !rutasArchivos.contains(rutaPDF)) {
                    rutasArchivos.add(rutaPDF);
                }
                //System.out.println("Fila -->bu: " + bu + ", status: " + statusProblema);
                if(bu.contains("REFACCIONES")) {
                	setCopiasCC.addAll(List.of("arramirez@truper.com","dacostah@truper.com","eleonc@truper.com","gjbautistar@truper.com","ggsanchezc@truper.com","jmfernandezc@truper.com","mtrejog@truper.com","mtrejog@truper.com","medelgadilloa@truper.com","mtoledos@truper.com","fcomunes@truper.com"));
                }else if(statusProblema.contains("DIRECTA")) {
                	setCopiasCC.addAll(List.of("arramirez@truper.com","aprosalesm@truper.com","ayromerom@truper.com","imartinezro@truper.com","jjacintog@truper.com","mvelazquezgo@truper.com","medelgadilloa@truper.com","magomezm@truper.com"));
                }else {
                	setCopiasCC.addAll(List.of("arramirez@truper.com"));                	
                } 
            }
            String cadenaPo=String.join(", ", poUnicas);
            String correoProveedor=ObtenerCorreoProv(noProv);
            if(correoProveedor==null || correoProveedor.trim().isEmpty()) {
            	correoProveedor="srodriguezg@truper.com";
            }
            String texto=Textos(nombreProveedor, cadenaPo, esPiOkg,nacionalg, tipog, noRg, pos.size()>1);
            StringBuilder cuerpoTexto = new StringBuilder(texto);
            if (!rutasArchivos.isEmpty()) {
                for (String ruta : rutasArchivos) {
                    cuerpoTexto.append("- ").append(ruta).append("\n");
                }
                cuerpoTexto.append("\n");
            }
            
            MailDTO dto=new MailDTO();
            dto.setNoProveedor(noProv);
            dto.setNombreProveedor(nombreProveedor);
            dto.setTo(correoProveedor);
            dto.setCc(String.join("; ", setCopiasCC)); //convertir set a string para guardarlo en el dto
            dto.setAsunto("PO" + (pos.size() > 1 ? "s" : "") + ": "  + cadenaPo);
            dto.setTexto(cuerpoTexto.toString());
            borrador.add(dto);
		}
		return borrador;
	}
	
	private String Textos(String proveedor, String po,boolean piOk, boolean nacional, String tipo, String NoR, boolean esPlural) {
		String piOkg = piOk ? "PIOK" : "";
		String nac= nacional ?"Verdadero":"Falso";
		String tip=("Urgente".equalsIgnoreCase(tipo))?"":tipo;
		String noR = (NoR == null || NoR.trim().isEmpty()) ? "N" : NoR.trim();
		//System.out.println(noR);
		String plural= esPlural ? "s":"";
		String claveCase= piOkg+nac+tip+noR;
		//String noRTexto = "N".equalsIgnoreCase(noR) ? "" : noR;
		switch(claveCase) {
		case "VerdaderoR": // NACIONAL Urgente Nuevos "SIN PI OK"
			return "Estimado Proveedor : " + proveedor+ "\n\n" + 
            "Adjunto encuentren Ordenes de Compra con Número: " + po + " " +noR+ ".\n Por favor confirmen, vía email, que fue recibida correctamente." + "\n\n" +
            "Le recordamos que es indispensable incluir su direccion fiscal y Registro Federal de Contribuyentes en todas sus proformas.\n\n "+
            "Esperamos su Proforma Invoice en un lapso no mayor a 48 hrs, enviando su confirmación al correo de proforma@truper.com.\n\n"+
            "Agradeceré su pronta respuesta.\n\n" +"Departamento de Importaciones\nTruper.\n\n";
		case "VerdaderoN":	//NACIONAL Urgente Nuevos "SIN PI OK"
			return "Estimado Proveedor : " + proveedor+ "\n\n" + 
            "Adjunto encuentren Ordenes de Compra con Número: " + po + ".\n Por favor confirmen, vía email, que fue recibida correctamente." + "\n\n" +
            "Le recordamos que es indispensable incluir su direccion fiscal y Registro Federal de Contribuyentes en todas sus proformas.\n\n "+
            "Esperamos su Proforma Invoice en un lapso no mayor a 48 hrs, enviando su confirmación al correo de proforma@truper.com.\n\n"+
            "Agradeceré su pronta respuesta.\n\n" +"Departamento de Importaciones\nTruper.\n\n";
		case "VerdaderoDirectaN": //NACIONAL Directa Nuevos|
			return "Estimado Proveedor: " + proveedor + "\n\n" +
            "Adjunto encuentren Ordenes de Compra con Número: " + po + " " + noR + ".\n" +"Por favor confirmen, vía email, que fue recibida correctamente.\n\n" +
            "Le recordamos que es indispensable incluir su dirección fiscal y Registro Federal de Contribuyentes en todas sus proformas.\n\n" +
            "Esperamos su Proforma Invoice en un lapso no mayor a 48 hrs, enviando su confirmación al correo de proforma@truper.com.\n\n" +
            "Agradeceré su pronta respuesta.\n\n" + "Departamento de Importaciones\nTruper.\n\n";
		case "PIOKVerdaderoR": // PIOK NACIONAL REVISADO
			 return "Estimado Proveedor: " + proveedor + "\n\n" +
            "Adjunto encuentre el revisado de la Orden de Compra con Número: " + po + " , Le enviamos esta Orden de Compra como referencia.\n\n" +
            "Ya contamos con su confirmación, no requerimos una nueva Proforma.\n\n" +
            "Saludos Cordiales,\nDepartamento de Importaciones\nTruper\n\n";
		case "FalsoN": //IMPORTADO Nuevos
			return "Dear: " +proveedor+ "\n\n" +
            "Attached you will find the purchase order"+ plural + " " + po + " in PDF format for your review. Please note that the seals that were normally attached to the PO email" + plural+ " are now included at the end of the PDF file" + plural+ ".\n\n" + 
            "We ask you to send your Proforma Invoice" +plural+ " within 48 hours, confirming prices, quantities, and shipment date.\n\n"+
            "The PI" +plural+ " must be sent to proforma@truper.com, with a copy to the Truper purchasing executive in charge of your account. Once received, Truper will send a confirmation email acknowledging the PI" +plural+ ".\n\n"+
            "Important note: We recommend that you do not purchase raw materials for " + (plural== "s"? "these": "this") + " order"+plural+" until you have received Truper’s confirmation of the PI"+plural+ ". Truper will not assume responsibility for any raw material costs incurred prior to this confirmation, unless written instructions have been provided authorizing such purchase.\n\n" +
            "Thank you for your prompt attention. We look forward to your confirmation.\n\n" +
            "Best regards,\n\n";
		case "FalsoR": //IMPORTADO REVISADO
            return "Dear: " + proveedor + "\n\n" +
                   "Attached you will find the purchase order" + plural + " " + po + " in PDF format for your review. " +
                   "Please note that the seals that were normally attached to the PO email" + plural + " are now included at the end of the PDF file" + plural + ".\n\n" +
                   "We ask you to send your Proforma Invoice" + plural + " within 48 hours, confirming prices, quantities, and shipment date.\n\n" +
                   "The PI" + plural + " must be sent to proforma@truper.com, with a copy to the Truper purchasing executive in charge of your account. " +
                   "Once received, Truper will send a confirmation email acknowledging the PI" + plural + ".\n\n" +
                   "Important note: We recommend that you do not purchase raw materials for " + (esPlural ? "these" : "this") + " order" + plural + " " +
                   "until you have received Truper’s confirmation of the PI" + plural + ". Truper will not assume responsibility for any raw material costs " +
                   "incurred prior to this confirmation, unless written instructions have been provided authorizing such purchase.\n\n" +
                   "Thank you for your prompt attention. We look forward to your confirmation.\n\n" +
                   "Best regards,\n\n";
		case "PIOKFalsoR": //PIOK IMPORTADO REVISADO 
            return "Dear: " + proveedor + "\n\n" +
                   "For your reference, find attached Purchase Order" + plural + " " + po + " " + noR + ". Please confirm receipt.\n\n" +
                   "The PO" + plural + " " + (esPlural ? "have" : "has") + " been adjusted to align with your Proforma Invoice" + plural + "; " +
                   "therefore, issuing " + (esPlural ? "new ones" : "a new one") + " is not required.\n\n" +
                   "Thanks and best regards,\n\n";

        case "PIOKFalsoDirectaR": 
            return "Dear: " + proveedor + "\n\n" +
                   "This is a direct shipment to Ensenada, located in Tijuana, Mexico, which is the designated Port of Discharge and must be declared in the Proforma Invoice. " +
                   "Any shipment done to a different location will result in additional transportation charges, which shall be borne by the supplier.\n\n" +
                   "For your reference, find attached Purchase Order" + plural + " " + po + " " + noR + ". Please confirm receipt. " +
                   "The PO" + plural + " " + (esPlural ? "have" : "has") + " been adjusted to align with your Proforma Invoice" + plural + "; therefore, issuing " + (esPlural ? "new ones" : "a new one") + " is not required.\n\n" +
                   "If you have any questions regarding " + (esPlural ? "these" : "this") + " order" + plural + ", please contact us at directshipments@truper.com. " +
                   "To confirm your Proforma Invoice" + plural + ", please ensure the document" + plural + " " + (esPlural ? "are" : "is") + " attached, " +
                   "the email is sent to proforma@truper.com, and your Truper account executive is copied for proper follow-up.\n\n" +
                   "Thanks and best regards,\n\n";

        case "FalsoDirectaR":
        	return "Dear: " +proveedor+ "\n\nImportant Notice!\n"+
            "This is a direct shipment to Ensenada, located in Tijuana, Mexico, which is the designated Port of Discharge and must be declared in the Proforma Invoice" +plural+". Any shipment done to a different location will result in additional transportation charges, which shall be borne by the supplier.\n\n"+
            "Attached you will find the purchase order" + plural+" " +po+" "+noR +" in PDF format for your review.\n\n"+
            "We ask you to send your Proforma Invoice"+ plural+" within 48 hours, confirming prices, quantities, and shipment date.\n\n" +
            "If you have any questions regarding " +(plural == "s"? "these": "this") + " order" + plural+", please contact us at directshipments@truper.com. To confirm your Proforma Invoice" +plural+", please ensure the document"+ plural +(plural== "s"? " are": " is") + " attached, the email is sent to proforma@truper.com, and your Truper account executive is copied for proper follow-up.\n\n" +
            "Thank you for your prompt attention. We look forward to your confirmation.\n\n"+
            "Best regards,\n\n";
        case "FalsoDirectaN":
            return "Dear: " + proveedor + "\n\nImportant Notice!\n\n" +
                   "This is a direct shipment to Ensenada, located in Tijuana, Mexico, which is the designated Port of Discharge and must be declared in the Proforma Invoice" + plural + ". " +
                   "Any shipment done to a different location will result in additional transportation charges, which shall be borne by the supplier.\n\n" +
                   "Attached you will find the purchase order" + plural + " " + po + " " + noR + " in PDF format for your review.\n\n" +
                   "We ask you to send your Proforma Invoice" + plural + " within 48 hours, confirming prices, quantities, and shipment date.\n\n" +
                   "If you have any questions regarding " + (esPlural ? "these" : "this") + " order" + plural + ", please contact us at directshipments@truper.com. " +
                   "To confirm your Proforma Invoice" + plural + ", please ensure the document" + plural + " " + (esPlural ? "are" : "is") + " attached, " +
                   "the email is sent to proforma@truper.com, and your Truper account executive is copied for proper follow-up.\n\n" +
                   "Thank you for your prompt attention. We look forward to your confirmation.\n\n" +
                   "Best regards,\n\n";
        default:
            return "";
    }
		
	}
	
	private String rutaPDF(String po, String gerente, String rea, boolean esUrgente , String OpcionPO , String nombreg) {
		
        String ewa = ("MARÍA ELIZABETH LÓPEZ".equalsIgnoreCase(nombreg) || "MARIA RIVERA A".equalsIgnoreCase(nombreg)  || "ERIKA KAREN HERNANDEZ".equalsIgnoreCase(nombreg)) ? "EWA\\" : "";
        String base = "\\\\srvfilesn\\POS_DIGITALES\\";
        
        gerente = ("MARÍA ELIZABETH LÓPEZ".equalsIgnoreCase(nombreg) ? "ELIZABETH" : 
		           "MARIA RIVERA A".equalsIgnoreCase(nombreg) ? "MARIA RIVERA" : 
	        	   "OMAR SAHAGUN L".equalsIgnoreCase(nombreg) ? "RENE" :    
        		   "VALERIA MEDELLÍN".equalsIgnoreCase(nombreg) ? "AARON" : 
	        	   "ERIKA KAREN HERNANDEZ".equalsIgnoreCase(nombreg) ? "ERIKA" : gerente);

        if (esUrgente) {
            base += "NUEVAS\\URGENTES\\REGISTRADOS\\";
        } //else if() {
        	//evalua nuevas N
        //	base +="NUEVAS\\" + ewa + gerente+"\\";
       // } 
        else if (rea!=null && rea.startsWith("R")) {
            base += "REVISADOS_EA´S_REIMP\\" + ewa + gerente + "\\";
        } else { //nuevas
            base+="NUEVAS\\" + ewa + gerente + "\\";
        }
        File folder = new File(base);
        if (folder.exists()) {
            File[] match = folder.listFiles((dir, name) -> (name.startsWith(po) || name.startsWith(OpcionPO)) && name.toLowerCase().endsWith(".pdf"));
            if (match!=null && match.length > 0) {
                return match[0].getAbsolutePath();
            }
            File registrados = new File(base + "REGISTRADOS\\");
            if (registrados.exists() && registrados.isDirectory()) {
                File[] matchesReg = registrados.listFiles((dir, name) -> (name.startsWith(po) || name.startsWith(OpcionPO)) && name.endsWith(".pdf"));
                if (matchesReg!=null && matchesReg.length > 0) {
                    return matchesReg[0].getAbsolutePath();
                }
            }
        }
        return base + po + ".pdf (no encontrado)";
    }
	
	private String ObtenerCorreoProv(String noPrvBusqueda){
	    Optional<listaProveedores> prov = listaProveedoresRepository.findFirstByAcreedor(noPrvBusqueda);
	    if (prov.isPresent() && prov.get().getDirecc()!=null) {
	        return prov.get().getDirecc().trim();
	    }
        return "";
    } 
}