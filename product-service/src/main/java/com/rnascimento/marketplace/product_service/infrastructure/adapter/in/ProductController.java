package com.rnascimento.marketplace.product_service.infrastructure.adapter.in;

import com.rnascimento.marketplace.product_service.application.service.ProductService;
import com.rnascimento.marketplace.product_service.dto.ProductRequestDto;
import com.rnascimento.marketplace.product_service.dto.ProductResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Listar todos os produtos")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")})
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @Operation(summary = "Buscar produto por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @Parameter(description = "ID do produto", example = "1") @PathVariable Long id) {
        ProductResponseDto product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Criar produto")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Produto criado com sucesso")})
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @Parameter(description = "Dados do produto para criação") @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto createdProduct = productService.create(productRequestDto);
        return ResponseEntity.ok(createdProduct);
    }

    @Operation(summary = "Atualizar produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @Parameter(description = "ID do produto", example = "1") @PathVariable Long id,
            @Parameter(description = "Dados do produto para atualização") @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto updatedProduct = productService.update(id, productRequestDto);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Deletar produto")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID do produto", example = "1") @PathVariable Long id) {
        boolean deleted = productService.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
