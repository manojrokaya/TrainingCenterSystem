package com.trainingcenter.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingcenter.entity.TrainingCenter;
import com.trainingcenter.service.TrainingCenterService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {
	
	 private final TrainingCenterService service;

	    public TrainingCenterController(TrainingCenterService service) {
	        this.service = service;
	    }
	    
	    @PostMapping
	    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
	        return ResponseEntity.ok(service.save(trainingCenter));
	    }

	    @GetMapping
	    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
	        return ResponseEntity.ok(service.getAll());
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updateTrainingCenter(
	            @PathVariable Long id, 
	            @Valid @RequestBody TrainingCenter trainingCenter) {
	        return ResponseEntity.ok(service.update(id, trainingCenter));
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteTrainingCenter(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.ok("Training Center deleted successfully!");
	    }

}
