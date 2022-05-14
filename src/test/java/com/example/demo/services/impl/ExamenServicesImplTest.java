package com.example.demo.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.contants.Datos;
import com.example.demo.models.Examen;
import com.example.demo.repositories.ExamenRepository;
import com.example.demo.repositories.PreguntasRepository;

class ExamenServicesImplTest {
	
	@Mock
	ExamenRepository repository;
	
	@Mock
	PreguntasRepository preguntasReposiroty;
	
	@InjectMocks
	ExamenServicesImpl examenService;
	
	
	@BeforeEach
	void setup() {
		/*
		 * repository = mock(ExamenRepository.class);
		 * preguntasReposiroty = mock(PreguntasRepository.class);
		 * examenService = new ExamenServicesImpl(repository, preguntasReposiroty);
		 * 
		 */
		MockitoAnnotations.openMocks(this);
		
	}
	
	
	@Test
	void testFindExamenByName() {
		/*
		 * sin Mockito
		 * 
		 * ExamenRepository repository = new ExamenRepositoryImpl();
		 * ExamenService examenService = new ExamenServicesImpl(repository);
		 */
		
		/*
		 * con Mockito, y este codigo se puede refactorizando creando una variable final
		 * List<Examen> datos = Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lengua Extranjera"),
	            new Examen(7L, "Espanol"));
		 */
		
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		Optional<Examen> examen = examenService.findExamenByName("Matematicas");
		assertNotNull(examen);
		assertEquals(5L, examen.get().getId());
		assertEquals("Matematicas", examen.get().getNombre());
	}
	
	@Test
	void testFindExamenByNameEmpty() {
		List<Examen> datos = Collections.emptyList();
		when(repository.findAll()).thenReturn(datos);
		Optional<Examen> examen = examenService.findExamenByName("Matematicas");
		assertFalse(examen.isPresent());
	}
	
	
	@Test
	void testQuestionsExamen() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntasReposiroty.findQuestionsByExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		Examen examen = examenService.findExamenByNamewithQuestions("Espanol");
		assertEquals(5,examen.getPreguntas().size());
		assertTrue(examen.getPreguntas().contains("geometría"));
	}
	
	@Test
	void testQuestionsExamenVerify() {
		when(repository.findAll()).thenReturn(Datos.EXAMENES);
		when(preguntasReposiroty.findQuestionsByExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
		Examen examen = examenService.findExamenByNamewithQuestions("Espanol");
		assertEquals(5,examen.getPreguntas().size());
		assertTrue(examen.getPreguntas().contains("geometría"));
		verify(repository).findAll();
		verify(preguntasReposiroty).findQuestionsByExamenId(7L);
	}

}
