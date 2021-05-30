package com.example.bands.conrollers;

import com.example.bands.config.DBConnection;
import com.example.bands.models.Band;
import com.example.bands.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandsController {

    private final BandService bandService;

    @Autowired
    public BandsController(BandService bandService){
        this.bandService = bandService;
    }

    @GetMapping
    public List<Band> getAll(){
        return bandService.getAll();
    }

    @PostMapping("/add")
    public void addBand(@RequestBody Band band){
        System.out.println(band.toString());
        bandService.add(band);
    }

    @DeleteMapping("/delete/{id}")
    public void remBand(@PathVariable int id){
        System.out.println("Deleting " + id);
        bandService.delete(id);
    }

    @PutMapping("/update")
    public void updateBand(@RequestBody Band band){
        System.out.println("editing\n" + band);
        bandService.update(band);
    }

}
