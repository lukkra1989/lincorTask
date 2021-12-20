package lincor.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "items")
public class Item {
//    public Item() {
//        uuid = UUID.fromString("3856c3da-ea56-4717-9f58-85f6c5f560a5");
//    }

    public UUID getUuid() {
        return uuid;
    }

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
