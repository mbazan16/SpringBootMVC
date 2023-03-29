Este proyecto es una ejemplo simple de un controlador MVC.
# OBJETIVO
Realizar una navegación jsp simple devolviento una pagina web con un saludo


# CONFIGURACIÓN JSP
Los ficheros .jsp se colocan en src/main/webapp (no esta en las carpetas fuentes, 
se visualiza en la carpeta src, debajo de las dependencias Maven)

spring.mvc.view.prefix: /jsp/
Directorio dentro de webapp donde se van a situar los jsp's

spring.mvc.view.suffix: .jsp
Extensión de los ficheros jsp`s

# DEPENDENCIAS NECESARIAS

Las necesaria únicamente es:
Spring-Web

Para que el Tomcat sirva los jsp's:
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
</dependency>
Para las tag JSTL:
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
</dependency>

Opcional, las utilidades para el desarrollo:
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>


# EJECUCION DE PROYECTO
Cuando se ejecuta el proyecto (Spring Boot App).
Se introduce en el navegador la url http://localhost:8083/miApp/saludo
-	localhost va a identificar la dirección del servidor (Tomcat)
-	/miApp identifica el contexto de la aplicación 
dada por la propiedad server.servlet.context-path=/miApp
-	/saludo identifica el controlador que se va a encangar de la peticion: SaludoController

# ANOTACIONES
Un controlador es una clase java que se decora con @Controller,
la url que va a servir se define con la anotacion @RequestMapping(<urlAServir>)

Importante: Toda petición la termina siviendo (ejecutando) UN UNICO METODO

Los métodos que sirven peticiones se tienen que anotar con @GetMapping, @PostMapping,
@PutMapping y @DeleteMapping para identificar qué tipo de petición sirve. Si se quiere
que sirva a todo tipo de petición se identifica con @RequestMapping

Los métodos públicos de las clases @Controller tienen como retorno EL NOMBRE DE LA PLANTILLA
O EL NOMBRE DEL JSP con el que se va a construir la página HTML para enviar al cliente
En este caso, NO ES ASI, al anotar el método con @RequestBody la cadena de retorno
 identifica el contenido de la respuesta.
 
 