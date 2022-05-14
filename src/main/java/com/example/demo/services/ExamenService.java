package com.example.demo.services;

import java.util.Optional;

import com.example.demo.models.Examen;

public interface ExamenService {
	Optional<Examen> findExamenByName(String nombre);
	Examen findExamenByNamewithQuestions(String nombre);
}
