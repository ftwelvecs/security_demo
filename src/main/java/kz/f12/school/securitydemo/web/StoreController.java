package kz.f12.school.securitydemo.web;

import kz.f12.school.securitydemo.dto.ProductDto;
import kz.f12.school.securitydemo.service.StoreService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('STORE_READ')")
    public List<ProductDto> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('STORE_WRITE')")
    public void create(@RequestBody ProductDto productDto) {
        service.create(productDto);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('STORE_WRITE')")
    public void update(@RequestBody ProductDto productDto) {
        service.update(productDto);
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAuthority('STORE_WRITE')")
    public void delete(@PathVariable("id") Long productId) {
        service.delete(productId);
    }
}
