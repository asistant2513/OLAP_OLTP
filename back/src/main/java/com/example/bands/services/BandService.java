package com.example.bands.services;

import com.example.bands.data.BandDAO;
import com.example.bands.models.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    private final BandDAO bandRepository;

    @Autowired
    public BandService(BandDAO bandRepository){
        this.bandRepository = bandRepository;
    }

    public List<Band> getAll(){
        return bandRepository.getAll();
    }

    public void add(Band band){
        bandRepository.save(band);
    }

    public void delete(int id){
        bandRepository.deleteById(id);
    }

    public void update(Band band){
        bandRepository.update(band);
    }
}
