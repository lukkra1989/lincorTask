package lincor.task.mapper;

import lincor.task.domain.Item;
import lincor.task.domain.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemMapper {

    public Item mapToItem(final ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription()
        );
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getUuid(),
                item.getName(),
                item.getDescription()
        );
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> itemList) {
        return itemList.stream()
                .map(this::mapToItemDto)
                .collect(Collectors.toList());
    }

    public List<Item> mapToItemList(final List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(this::mapToItem)
                .collect(Collectors.toList());
    }
}
