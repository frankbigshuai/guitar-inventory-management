package iu.edu.jackliang.demo.controllers;

import iu.edu.jackliang.demo.enums.Builder;
import iu.edu.jackliang.demo.enums.Type;
import iu.edu.jackliang.demo.enums.Wood;
import iu.edu.jackliang.demo.model.Guitar;
import iu.edu.jackliang.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/guitars")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository = new InventoryRepository();

    public void setInventoryRepository(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = false) String serialNumber,
                                               @RequestParam(required = false) Double price,
                                               @RequestParam(required = false) Builder builder,
                                               @RequestParam(required = false) String model,
                                               @RequestParam(required = false) Type type,
                                               @RequestParam(required = false) Wood backWood,
                                               @RequestParam(required = false) Wood topWood) throws IOException {
        Guitar searchPram = new Guitar(serialNumber,price,builder,model,type,backWood,topWood);
        return inventoryRepository.search(searchPram);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Guitar guitar) {
        try{
            return inventoryRepository.addGuitar(guitar);
        }catch (IOException e){
            return false;
        }
    }
    @GetMapping("/find/{serialNumber}")
    public Guitar find(@PathVariable("serialNumber") String sN) throws IOException {
        return inventoryRepository.getGuitar(sN);
    }

    @GetMapping("/getall")
    public List<Guitar> search() throws IOException {
        Path path = Paths.get("db.txt");
        return inventoryRepository.dbToList(path);
    }
}
