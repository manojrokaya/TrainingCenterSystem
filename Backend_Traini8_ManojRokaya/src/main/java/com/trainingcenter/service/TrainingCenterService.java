package com.trainingcenter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trainingcenter.entity.TrainingCenter;
import com.trainingcenter.repository.TrainingCenterRepository;

import jakarta.validation.Valid;

@Service
public class TrainingCenterService {
	
	private final TrainingCenterRepository repository;
	
	public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }
	
	public TrainingCenter save(TrainingCenter center) {
        return repository.save(center);
    }

    public List<TrainingCenter> getAll() {
        return repository.findAll();
    }

	public Object update(Long id, @Valid TrainingCenter trainingCenter) {
		// TODO Auto-generated method stub
		return repository.findById(id).map(center ->{
			center.setCenterName(trainingCenter.getCenterName());
			center.setCenterCode(trainingCenter.getCenterCode());
			center.setAddress(trainingCenter.getAddress());
			center.setStudentCapacity(trainingCenter.getStudentCapacity());
	        center.setCoursesOffered(trainingCenter.getCoursesOffered());
	        center.setContactEmail(trainingCenter.getContactEmail());
	        center.setContactPhone(trainingCenter.getContactPhone());
	            return repository.save(center);
		}).orElseThrow(()->new RuntimeException("Training Center is not found"));
		
	}
		
		
		public void delete(Long id) {
	        TrainingCenter center = repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Training Center not found"));
	        repository.delete(center);
	    }
	
	
	
}
