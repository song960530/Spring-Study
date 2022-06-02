package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Optional<Item> save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);

        return Optional.of(item);
    }

    public Optional<Item> findById(Long id) {
        return Optional.of(store.get(id));
    }

    public Optional<List<Item>> findAll() {
        return Optional.of(new ArrayList<>(store.values()));
    }

    public void update(Long itemId, Item updateParam) {
        Item item = findById(itemId).get();
        item.setItemName(updateParam.getItemName());
        item.setPrice(updateParam.getPrice());
        item.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

}
