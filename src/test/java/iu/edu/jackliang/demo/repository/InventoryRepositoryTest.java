package iu.edu.jackliang.demo.repository;

import iu.edu.jackliang.demo.enums.Builder;
import iu.edu.jackliang.demo.enums.Type;
import iu.edu.jackliang.demo.enums.Wood;
import iu.edu.jackliang.demo.model.Guitar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void testAddGuitarSuccess() throws IOException {
        InventoryRepository repo = new InventoryRepository();

        Guitar guitar = new Guitar("123", 1500.0, Builder.FENDER, "Stratocaster", Type.ELECTRIC, Wood.ALDER, Wood.MAPLE);
        assertTrue(repo.addGuitar(guitar));
    }

    @Test
    void testGetGuitar() throws IOException {
        InventoryRepository repo = new InventoryRepository();
        Guitar guitar = new Guitar("123", 1500.0, Builder.FENDER, "Stratocaster", Type.ELECTRIC, Wood.ALDER, Wood.MAPLE);
        repo.addGuitar(guitar);
        Guitar retrievedGuitar = repo.getGuitar("123");
        assertNotNull(retrievedGuitar);
        assertEquals("123", retrievedGuitar.getSerialNumber());
    }

    @Test
    void testSearch() throws IOException {
        InventoryRepository repo = new InventoryRepository();

        repo.addGuitar(new Guitar("123", 1500.0, Builder.FENDER, "Stratocaster", Type.ELECTRIC, Wood.ALDER, Wood.MAPLE));
        repo.addGuitar(new Guitar("456", 2000.0, Builder.GIBSON, "Les Paul", Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE));


        Guitar searchParam = new Guitar(null, null, Builder.FENDER, null, null, null, null);
        List<Guitar> result = repo.search(searchParam);

        assertFalse(result.isEmpty());
        assertEquals(Builder.FENDER, result.get(0).getBuilder());

    }
}