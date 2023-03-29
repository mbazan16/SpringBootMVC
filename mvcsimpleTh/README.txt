Este proyecto es una ejemplo simple de un controlador MVC.
# OBJETIVO
Realizar una navegación simple devolviento una página HTML.

# DEPENDENCIAS NECESARIAS

Las necesaria son:
Spring-Web
Thymeleaf


# EJECUCION DE PROYECTO
Cuando se ejecuta el proyecto (Spring Boot App).
Se introduce en el navegador la url http://localhost:8084/miApp/hola
-	localhost va a identificar la dirección del servidor (Tomcat)
-	/miApp identifica el contexto de la aplicación 
dada por la propiedad server.servlet.context-path=/miApp
-	/hola identifica el controlador que se va a encangar de la peticion: HolaMundoController

# ANOTACIONES
Un controlador es una clase java que se decora con @Controller,
la url que va a servir se define con la anotacion @RequestMapping(<urlAServir>)

Importante: Toda petición la termina siviendo (ejecutando) UN UNICO METODO

Los métodos que sirven peticiones se tienen que anotar con @GetMapping, @PostMapping,
@PutMapping y @DeleteMapping para identificar qué tipo de petición sirve. Si se quiere
que sirva a todo tipo de petición se identifica con @RequestMapping

Los métodos públicos de las clases @Controller tienen como retorno EL NOMBRE DE LA PLANTILLA
O EL NOMBRE DEL JSP con el que se va a construir la página HTML para enviar al cliente
En este caso el nombre es "pagina".

# TEMPLATES
Las templates Thymeleaf se encuentran en el directorio src/main/resources/templates
En  este proyecto "pagina.html" es nuestra plantilla y todavía no tiene código thymeleaf

