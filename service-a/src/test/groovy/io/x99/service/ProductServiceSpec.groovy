package io.x99.service

import io.x99.service_a.error.BadRequestException
import io.x99.service_a.error.NotFoundException
import io.x99.service_a.model.ProductEntity
import io.x99.service_a.repository.ProductRepository
import io.x99.service_a.service.ProductService
import spock.lang.Specification

class ProductServiceSpec extends Specification {
    def productRepo = Mock(ProductRepository)
    def productService = new ProductService(productRepository: productRepo)

    def "productService.getAllProducts() must be invoked findAll()"() {
        when:
        def products = productService.getAllProducts()

        then:
        1 * productRepo.findAll() >> [new ProductEntity()]
        products.size() == 1
    }

    def "productService.getProductById() must be invoked findById()"() {
        when:
        def product = productService.getProductById(1)

        then:
        1 * productRepo.findById(_) >> Optional.of(new ProductEntity())
        product != null
    }

    def "productService.getProductById() must throw NotFoundException when the id doesn't exist"() {
        when:
        productService.getProductById(1)

        then:
        1 * productRepo.findById(_) >> Optional.empty()
        thrown NotFoundException
    }

    def "productService.addProduct() must be invoked save()"() {
        given:
        String name = "NewProduct"
        BigDecimal price = 10.0

        when:
        def product = productService.addProduct(name, price)

        then:
        1 * productRepo.save(_ as ProductEntity) >> { args ->
            assert args[0].name == name && args[0].price == price
            return args[0]
        }
        product != null
        product.name == name
        product.price == price
    }

    def "productService.addProduct(#name, #price) must throw BadRequestException"() {
        when:
        productService.addProduct(name, price)

        then:
        0 * productRepo.save(_)
        thrown BadRequestException

        where:
        name     | price
        null     | 10.0
        "rtpk"   | null
        "rtpk"   | -0.1
    }

    def "productService.deleteProduct() must be invoked deleteById()"() {
        when:
        def product = productService.deleteProduct(1)

        then:
        1 * productRepo.findById(_) >> Optional.of(new ProductEntity())
        1 * productRepo.delete(_)
        product != null
    }

    def "productService.deleteProduct() must throw NotFoundException when the id doesn't exist"() {
        when:
        productService.deleteProduct(1)

        then:
        1 * productRepo.findById(_) >> Optional.empty()
        0 * productRepo.delete(_)
        thrown NotFoundException
    }

}
