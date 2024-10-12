package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.emtities.Product;
import br.com.senai.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController//suporta apenas dados
    @RequestMapping("/product")//localhost:8080/product

    public class ProductController {
        //injeçao de dependencia
        @Autowired
        private ProductRepository productRepository;

        //metodo pra criar usuario
        @PostMapping
        public Product createUsuario(@RequestBody Product product){
            return  productRepository.save(product);
        }
        //listar todos os usuarios banco dados
        @GetMapping
        public List<Product> getAllproducts(){
            //SELECT * FROM product
            return productRepository.findAll();
        }
        //pegar um usuario pelo seu id
        @GetMapping("/{id}")
        public Product getproductById(@PathVariable Long id){
            return  productRepository.findById(id).orElse(null);
        }
        //deletar um usuario
        @DeleteMapping("/{id}")
        public void deleteproduct(@PathVariable Long id){
            productRepository.deleteById(id);
        }
        //atualizar informaçoes do usuario pelo id
        @PutMapping("/{id}")
        public Product updateproduct(@PathVariable Long id,
                                     @RequestBody Product product){
            Product usuario = productRepository.findById(id).orElse(null);
            if (product!= null){
                product.setName(product.getName());
                product.setPrice(product.getPrice());
                product.setBrand(product.getBrand());
                product.setColor(product.getColor());
                return productRepository.save(product);
            }
            return  null;
        }


    }


