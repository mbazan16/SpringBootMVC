Este proyecto trabaja con una entidad que posee dos tipos de fechas:
  * el atributo fechaInicio del tipo LocalDate
  * el atributo fechaFin del tipo java.util.Date

Para trabajar con fechas y formularios thymeleaf, es necesario incluir la dependencia:

	<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-java8time</artifactId>
			<version>3.0.4.RELEASE</version>
		</dependency>

Además de las propia de Thymeleaf con SpringBoot.

Para mostrar los campos de fecha en un formulario los atributos de la entidad deben estar
formateados:

@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate fechaInicio;
	
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date fechaFin;



Se recomiendo leer el articulo https://www.baeldung.com/dates-in-thymeleaf
