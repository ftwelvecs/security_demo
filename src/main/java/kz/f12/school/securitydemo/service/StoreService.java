package kz.f12.school.securitydemo.service;

import kz.f12.school.securitydemo.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StoreService {

    private List<ProductDto> products = Stream.of(
            new ProductDto(1L, "Нан", "Цесна наны", 50),
            new ProductDto(2L, "Сүт", "Айналайын сүті", 200),
            new ProductDto(3L, "Жұмыртқа", "Ауыл жұмыртқасы", 200)
    ).collect(Collectors.toList());

    public List<ProductDto> getProducts() {
        return products;
    }

    public void update(ProductDto newProduct) {
        Optional<ProductDto> optionalProductDto = products.stream()
                .filter(product -> product.getId().equals(newProduct.getId()))
                .findFirst();

        if (optionalProductDto.isPresent()) {
            ProductDto oldProduct = optionalProductDto.get();
            oldProduct.setName(newProduct.getName());
            oldProduct.setDescription(newProduct.getDescription());
            oldProduct.setPrice(newProduct.getPrice());
        }
    }

    public void create(ProductDto productDto) {
        products.add(productDto);
    }

    public void delete(Long productId) {
        /*
        // Старый подход
        Iterator<ProductDto> iterator = products.iterator();
        while (iterator.hasNext()) {
            ProductDto productDto = iterator.next();
            if (productDto.getId().equals(productId))
                iterator.remove();
        }*/
        // новый подход
        products.removeIf(product -> product.getId().equals(productId));
    }
}
