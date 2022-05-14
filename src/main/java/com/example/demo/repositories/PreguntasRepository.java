package com.example.demo.repositories;

import java.util.List;

public interface PreguntasRepository {
	List<String> findQuestionsByExamenId(Long id);
}
