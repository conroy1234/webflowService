package org.webflowService.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.webflowService.dto.ProductDto;
import org.webflowService.model.Product;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    public static final String BASE_URL = "/product/";
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ApiController apiController;

    @Test
    public void findByIdTest() throws Exception {

        ProductDto product = new ProductDto();
        product.setId(1);
        product.setName("T Shirt");
        product.setPrice(35.4);
        product.setQuantity(5);


        ResponseEntity<ProductDto> responseEntity = ResponseEntity.ok(product);

        when(apiController.findById(anyInt())).thenReturn(responseEntity);
        mockMvc.perform(get(BASE_URL + "/" + 1)
                )
                .andDo(print())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("name").value("T Shirt"))
                .andExpect(jsonPath("price").value("35.4"))
                .andExpect(jsonPath("quantity").value("5")
                ).andExpect(status().isOk())
                .andReturn();
    }




}