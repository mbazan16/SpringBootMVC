package com.example.mvc.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String irEmpleados(Model model,
		      @RequestParam("page") Optional<Integer> page, 
		      @RequestParam("size") Optional<Integer> size) throws Exception {
		log.info("[irEmpleados]");
		int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
		Page<Empleado> empleados=servicio.listEmpleados(PageRequest.of(currentPage - 1, pageSize));
		
		model.addAttribute("empleados", empleados);
		
		 int totalPages = empleados.getTotalPages();
	        if (totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	            model.addAttribute("pageNumbers", pageNumbers);
	        }
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
	
	@GetMapping("/f/{id}")
	public String irFichaEmpleado(Model model,@PathVariable("id") Integer id) throws Exception {
		log.info("[irFichaEmpleado]");
		
		Empleado empleado = servicio.getEmpleado(id);
		log.debug("[empleado:"+empleado.toString()+"]");
		model.addAttribute("empleado", empleado);	
		return "modals/empleado";
	}
	
}
	
