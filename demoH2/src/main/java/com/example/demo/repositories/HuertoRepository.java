package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Huerto;


public interface HuertoRepository extends JpaRepository<Huerto, Integer>{
	
	/*NamedQuery*/
	 
	 Iterable<Huerto> encuentraPorNombreNamedQuery(String name);
	 
	 /*DynamicQuerys*/
	
	 Iterable<Huerto> findByName(String name);
	 
	 /*JPQL*/
	 
	 @Query(value="Select h from Huerto h where h.name=:name")
	 Iterable<Huerto> encuentraPorNameJPQL(@Param("name") String miNombre);	 
	 
	 
	 
	 /*Nativas*/
	 @Query(value="Select h.* from Huerto h where h.name=:name",nativeQuery = true)
	 Iterable<Huerto> encuentraPorNameNativo(String name);
	 
	
	 /*De manipulación de datos:UPDATE,INSERT o DELETE*/
	 @Modifying
	 @Query(value="insert into Huerto (name) values(:name)",nativeQuery=true)
	 int insertarHuerto( String name);
	 
	 @Modifying
	 @Query("delete Huerto h where h.id = ?1")
	 int eliminarHuerto(Integer id);
 	 

}
