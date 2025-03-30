package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepositoy;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAll(Pageable pageable){
		Page<Event> result = eventRepositoy.findAll(pageable);
		return result.map(event -> new EventDTO(event));
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity.setDate(dto.getDate());
		entity.setCity(cityRepository.getReferenceById(dto.getCityId()));
		entity = eventRepositoy.save(entity);
		return new EventDTO(entity);
	}
}
