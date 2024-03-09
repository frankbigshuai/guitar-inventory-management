package iu.edu.jackliang.demo.repository;

import iu.edu.jackliang.demo.enums.Builder;
import iu.edu.jackliang.demo.enums.Type;
import iu.edu.jackliang.demo.enums.Wood;
import iu.edu.jackliang.demo.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryRepository {
    private List<Guitar> guitars;
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "db.txt";

    public InventoryRepository() {
        guitars = new ArrayList<>();
    }


    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }

    public boolean addGuitar(Guitar guitar)throws IOException {

        Path path = Paths.get(DATABASE_NAME);
        String data = guitar.getSerialNumber() + "," + guitar.price() + "," + guitar.getBuilder() + "," + guitar.getModel()+ "," +guitar.getType()+ "," +guitar.getBackWood()+ "," +guitar.getTopWood();
        appendToFile(path,data + NEW_LINE);
        guitars.add(guitar);
        return true;
    }



    public List<Guitar> dbToList(Path path) throws IOException {
        List<Guitar> guitars= new ArrayList<>();
        List<String> data = Files.readAllLines(path);
        for(String line : data){
            String[] words = line.split(",");
            guitars.add(new Guitar(words[0],Double.valueOf(words[1]), Builder.valueOf(words[2].toUpperCase()),words[3], Type.valueOf(words[4].toUpperCase()), Wood.valueOf(words[5].toUpperCase()),Wood.valueOf(words[6].toUpperCase())));
        }
        return guitars;
    }
    public Guitar getGuitar(String serialNumber) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        List<Guitar> gList = dbToList(path);
        for (Guitar guitar : gList) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
    public List<Guitar> search(Guitar searchGuitar) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        List<Guitar> gList = dbToList(path);

        for (Guitar guitar : guitars) {
            if ((searchGuitar.getBuilder() == null || guitar.getBuilder().equals(searchGuitar.getBuilder())) &&
                    (searchGuitar.getModel() == null || guitar.getModel().equals(searchGuitar.getModel())) &&
                    (searchGuitar.getType() == null || guitar.getType().equals(searchGuitar.getType())) &&
                    (searchGuitar.getBackWood() == null || guitar.getBackWood().equals(searchGuitar.getBackWood())) &&
                    (searchGuitar.getTopWood() == null || guitar.getTopWood().equals(searchGuitar.getTopWood()))) {
                gList.add(guitar);
            }
        }
        return gList;
    }


}
