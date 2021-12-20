package java.lincor.task.mapper;

import lincor.task.domain.Item;
import lincor.task.domain.ItemDto;
import lincor.task.mapper.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void mapToItem() {
        //Given
        ItemDto itemDto = new ItemDto(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "New Item", "Our brand new product ");

        //When
        Item item = itemMapper.mapToItem(itemDto);

        //Then
        assertEquals(item.getUuid(), "3856c3da-ea56-4717-9f58-85f6c5f560a5");
        assertEquals(item.getName(), "New Item");
        assertEquals(item.getDescription(), "Our brand new product ");
    }

    @Test
    void mapToItemDto() {
        //Given
        Item item = new Item(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "New Item", "Our brand new product ");

        //When
        ItemDto itemDto = itemMapper.mapToItemDto(item);

        //Then
        assertEquals(itemDto.getId(), "3856c3da-ea56-4717-9f58-85f6c5f560a5");
        assertEquals(itemDto.getName(), "New Item");
        assertEquals(itemDto.getDescription(), "Our Brand new product ");
    }

    @Test
    void mapToItemDtoList() {
        //Given
        Item item1 = new Item(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "test1", "test description1");
        Item item2 = new Item(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a6"), "test2", "test description2");

        //When
        List<ItemDto> itemList = itemMapper.mapToItemDtoList(List.of(item1, item2));

        //Then
        assertEquals(itemList.size(), 2);
    }

    @Test
    void mapToItemList() {
        //Given
        ItemDto itemDto1 = new ItemDto(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5"), "test1", "test description1");
        ItemDto itemDto2 = new ItemDto(UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a6"), "test2", "test description2");

        //When
        List<Item> itemList = itemMapper.mapToItemList(List.of(itemDto1, itemDto2));

        //Then
        assertEquals(itemList.size(), 2);

    }
}
