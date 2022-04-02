package kz.f12.school.securitydemo.service;

import kz.f12.school.securitydemo.dto.ProductDto;
import org.springframework.stereotype.Service;

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

    public void update(ProductDto productDto) {
        Optional<ProductDto> optionalProductDto = products.stream()
                .filter(product -> product.getId().equals(productDto.getId()))
                .findFirst();

        if (optionalProductDto.isPresent()) {
            ProductDto product = optionalProductDto.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
        }
    }

    public void create(ProductDto productDto) {

    }

    public void delete(Long productId) {

    }
}
