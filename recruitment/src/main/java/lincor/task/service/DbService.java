package lincor.task.service;

import lincor.task.domain.Item;
import lincor.task.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ItemRepository repository;

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Optional<Item> getItemById(UUID id) {
        return repository.findById(id);
    }

    public Item addItem(final Item item) {
        return repository.save(item);
    }

    public void deleteItem(UUID id){
        repository.deleteById(id);
    }
}
