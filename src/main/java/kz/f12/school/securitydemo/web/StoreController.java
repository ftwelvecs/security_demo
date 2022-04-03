package kz.f12.school.securitydemo.web;

import kz.f12.school.securitydemo.dto.ProductDto;
import kz.f12.school.securitydemo.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService service;

    // когда используется конструктор Autowired не нужен
    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/create")
    public void create(@RequestBody ProductDto productDto) {
        service.create(productDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductDto productDto) {
        service.update(productDto);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long productId) {
        service.delete(productId);
    }
}
