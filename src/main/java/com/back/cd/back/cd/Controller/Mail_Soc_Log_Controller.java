package com.back.cd.back.cd.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.MailDTO;

@RestController
@RequestMapping("/importaciones/controldocumental/mail")
@CrossOrigin(origins = "*")
public class Mail_Soc_Log_Controller {
	@Autowired
	Mail_Soc_Log_Service mailService;
	
	@PostMapping("/borrador")
	public List<MailDTO> correosBorrador(@RequestBody List<Map<String, Object>> filas) {
        return mailService.correos(filas);
    }
}