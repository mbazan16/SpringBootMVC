package com.example.mvc.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.bussiness.ServicioFoto;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Foto;
import com.example.mvc.repository.FotoRepository;

@Controller
@RequestMapping(path = "/")
public class AppController {

	@Autowired
    ServicioFoto servicio;

   

    @RequestMapping(path = "/")
    public String index(Model model){

        return "redirect:/listar";
    }

    @RequestMapping(path = "/listar")
    public String listar(Model model) throws ServicioException{
        model.addAttribute("fotos", servicio.listFotos());
        return "listar";
    }

    @PostMapping(path = "/procesarFoto")
    public String procesarFoto(@RequestParam(name = "foto") MultipartFile file) throws IOException, ServicioException {
        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        //creando salvando el objeto.
        Foto foto = new Foto(file.getOriginalFilename(), file.getContentType(), encodedString);
        servicio.grabarFoto(foto);
        return "redirect:/listar";
    }

    @GetMapping(path = "/visualizar/{id}")
    public String visualizarFoto( @PathVariable(name = "id") Long id, Model model, RedirectAttributes redirectAttributes) throws ServicioException{
        Foto foto = servicio.conseguirFoto(id);
        if(foto==null){
            redirectAttributes.addFlashAttribute("error", "Foto no existe");
            return "redirect:/listar";
        }
        model.addAttribute("foto", foto);
        return "visualizar";
    }

    @GetMapping(path = "/eliminar/{id}")
    public String borrarFoto(@PathVariable(name = "id") Long id) throws ServicioException{
        servicio.eliminarFoto(id);
        return "redirect:/listar";
    }

}