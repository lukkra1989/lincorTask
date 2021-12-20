package java.lincor.task.controller;

import com.google.gson.Gson;
import lincor.task.controller.ItemController;
import lincor.task.domain.ItemDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @MockBean
    private ItemController itemController;
    @Autowired
    private MockMvc mockMvc;



    @Test
    void AddItem()throws Exception{
        //Given
        ItemDto itemDto= new ItemDto(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "New Item", "Top-10, Brand New Item");
        //ItemDto newItem= new ItemDto()
        when(itemController.addItem(any(ItemDto.class))).thenReturn(itemDto);
        Gson gson=new Gson();
        String jsonContent= gson.toJson(itemDto);

        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("1/item/addItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("name",Matchers.is("This item has been created")));
    }

    @Test
    void getItem() throws Exception {
        //Given
        ItemDto itemDto = new ItemDto(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "New Item", "Top-10, Brand New Item");
        when(itemController.getItem(any(UUID.class))).thenReturn(itemDto);
        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("1/item/getItem")
                        .param("itemId","3856c3da-ea56-4717-9f58-85f6c5f560a5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("New Item")));


    }


}
