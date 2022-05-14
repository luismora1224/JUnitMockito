package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Examen;
import com.example.demo.repositories.ExamenRepository;
import com.example.demo.repositories.PreguntasRepository;
import com.example.demo.services.ExamenService;

public class ExamenServicesImpl implements ExamenService {
	
	private PreguntasRepository preguntasRepository;
	private ExamenRepository examenRepository;
	
	@Autowired
	public ExamenServicesImpl(ExamenRepository examenRepository, PreguntasRepository preguntasRepository) {
		this.examenRepository = examenRepository;
		this.preguntasRepository = preguntasRepository;
	}
	
	@Override
	public Optional<Examen> findExamenByName(String nombre) {
		return examenRepository.findAll()
				.stream()
				.filter(e -> e.getNombre().contains(nombre))
				.findFirst();
	}

	@Override
	public Examen findExamenByNamewithQuestions(String nombre) {
		Optional<Examen> examenOptional = findExamenByName(nombre);
		Examen examen = null;
		if(examenOptional.isPresent()) {
			examen = examenOptional.orElseThrow(null);
			List<String> preguntas = preguntasRepository.findQuestionsByExamenId(examen.getId());
			examen.setPreguntas(preguntas);
		}
		return examen;
	}
	

}
