package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    @DisplayName("저장테스트")
    public void save() throws Exception {
        // given
        Item item = new Item("itemA", 10000, 10);

        // when
        Item savedItem = itemRepository.save(item).get();

        // then
        Item findItem = itemRepository.findById(savedItem.getId()).get();
        assertEquals(findItem, savedItem);

    }

    @Test
    @DisplayName("전체 검색")
    public void findAll() throws Exception {
        // given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 10000, 10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> result = itemRepository.findAll().get();

        // then
        assertEquals(2, result.size());
        assertEquals(true, result.contains(item1));
        assertEquals(true, result.contains(item2));
    }

    @Test
    @DisplayName("수정테스트")
    public void update() throws Exception {
        // given
        Item item1 = new Item("itemA", 10000, 10);

        Item savedItem = itemRepository.save(item1).get();
        Long id = savedItem.getId();

        // when
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(id, updateParam);

        // then
        Item findItem = itemRepository.findById(id).get();
        assertEquals(updateParam.getItemName(), findItem.getItemName());
        assertEquals(updateParam.getPrice(), findItem.getPrice());
        assertEquals(updateParam.getQuantity(), findItem.getQuantity());
    }
}
