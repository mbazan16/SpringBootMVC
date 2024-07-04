package com.example.mvc.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.bussiness.ServicioEmpleado;
import com.example.mvc.entities.Departamento;
import com.example.mvc.entities.Empleado;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class ControladorEmpleados {
	Logger log = LoggerFactory.getLogger(ControladorEmpleados.class);
	
	@Autowired
	ServicioEmpleado servicio;
	
	@Autowired
	ServicioDepartamento servicioDepartamento;
	
	@GetMapping
	public String irEmpleados(Model model) throws Exception {
		log.info("[irEmpleados]");
		
		List<Empleado> empleados=servicio.listEmpleados();
		
		model.addAttribute("empleados", empleados);
		return "empleados";
	}
	
	@GetMapping("/a")
	public String irCrearEmpleado(Model model) throws Exception {
		log.info("[irCrearEmpleado]");
		model.addAttribute("employee", new Empleado());
		
		List<Departamento> departamentos = servicioDepartamento.listDepartamentos();		
		model.addAttribute("departamentos", departamentos);	
		return "crearEmpleado";
	}
	
	//Nota:BindingResult debe ir "pegado" a la entidad a validar, debe ser el siguiente parametro
	//Nota:La entidad se debe mapear con ModelAttribute y con el nombre del formulario @ModelAttribute("employee")
	//Tiene que mapearse con ModelAttribute para que la gestión de excepciones @CotrolAdvice no sea la que recoja el error
	@PostMapping
	public String grabarEmpleado(@Valid @ModelAttribute("employee") Empleado empleado,BindingResult result,Model model) throws Exception {
		log.info("[grabarEmpleado]");
		log.debug("[empleado:"+empleado.toString()+"]");
		
		if (result.hasErrors()) { 
			List<Departamento> departamentos = servicioDepartamento.listDepartamentos();		
			model.addAttribute("departamentos", departamentos);
            return "crearEmpleado";        
		}
		empleado=servicio.grabarEmpleado(empleado);
		
		return "redirect:/empleados";
	}
	
}
	
