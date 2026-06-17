package com.back.cd.back.cd.Modelo;

import java.util.List;

public class AsignacionDTO {

	    private String asistentepos;
	    private List<Long> ids;

	    private List<Long> idsplog;

	    
	    public String getAsistentepos() {
			return asistentepos;
		}
		public void setAsistentepos(String asistentepos) {
			this.asistentepos = asistentepos;
		}
		public List<Long> getIds() {
			return ids;
		}
		public void setIds(List<Long> ids) {
			this.ids = ids;
		}
		public List<Long> getIdsplog() {
			return idsplog;
		}
		public void setIdsplog(List<Long> idsplog) {
			this.idsplog = idsplog;
		}
		
	    
}
