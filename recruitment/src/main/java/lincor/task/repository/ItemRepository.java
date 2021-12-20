package lincor.task.repository;

import lincor.task.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends CrudRepository<Item, UUID> {
    Item save(Item item);

    Optional<Item> findById(UUID id);

    List<Item> findAll();

    void deleteById(UUID id);
}
