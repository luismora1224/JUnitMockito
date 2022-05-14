package com.example.demo.contants;

import java.util.Arrays;
import java.util.List;

import com.example.demo.models.Examen;

public class Datos {
	public final static List<Examen> EXAMENES =  Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lengua Extranjera"),
            new Examen(7L, "Espanol"));
	
	public final static List<String> PREGUNTAS = Arrays.asList("aritmética", "integrales",
			"derivadas", "trigonometría","geometría");
}
