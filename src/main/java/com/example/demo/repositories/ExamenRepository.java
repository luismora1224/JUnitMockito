package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Examen;

public interface ExamenRepository {
	List<Examen> findAll();
}
