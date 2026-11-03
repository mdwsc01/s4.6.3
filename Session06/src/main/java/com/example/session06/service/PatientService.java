package com.example.session06.service;

import com.example.session06.model.entity.Patient;
import com.example.session06.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        patient.setId(null);
        return patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        if(!patientRepository.existsById(id)) {
            throw new NoSuchElementException("Không tìm thấy bệnh nhân với id:"+id);
        }
        patientRepository.deleteById(id);
    }

}
