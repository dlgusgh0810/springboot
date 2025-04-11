package com.Lect.week03;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalService {
	private List<Animal> animals;
	private Map<String, Animal> animalMap;
}
