package lincor.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ItemDto {
    private UUID id;
    private String name;
    private String description;
}
