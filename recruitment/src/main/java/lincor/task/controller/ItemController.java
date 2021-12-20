package lincor.task.controller;

import lincor.task.domain.Item;
import lincor.task.domain.ItemDto;
import lincor.task.mapper.ItemMapper;
import lincor.task.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("1/item")
@RequiredArgsConstructor
public class ItemController {
    private final DbService dbService;
    private final ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addItem",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        Item item = itemMapper.mapToItem(itemDto);
        return itemMapper.mapToItemDto(dbService.addItem(item));
    }

    public ItemDto getItem(@RequestParam UUID itemId)throws ItemNotFoundException{
        return itemMapper.mapToItemDto(
                dbService.getItemById(itemId).orElseThrow(ItemNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = "getItems")
    public List<ItemDto> getItems() {
        List<Item> items = dbService.getAllItems();
        return itemMapper.mapToItemDtoList(items);
    }


    @RequestMapping(method = RequestMethod.DELETE, value="deleteItem")
    public void deleteItem(@RequestParam UUID itemId) {
        dbService.deleteItem(itemId);
    }
}
