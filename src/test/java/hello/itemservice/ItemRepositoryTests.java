package hello.itemservice;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ItemRepositoryTests {

	ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void afterEach(){
		itemRepository.clearStore();
	}

	@Test
	void save(){

		//given
		Item item = new Item("itemA", 10000,10);
		//when
		Item saveItem = itemRepository.save(item);
		//then
		Item findItem = itemRepository.findById(saveItem.getId());
		Assertions.assertThat(findItem).isEqualTo(saveItem);

	}

	@Test
	void findAll(){

		//given
		Item item1 = new Item("item1", 10000,10);
		Item item2 = new Item("item2", 210000,105);

		itemRepository.save(item1);
		itemRepository.save(item2);

		//when
		List<Item> itemList = itemRepository.findALl();

		//then
		Assertions.assertThat(itemList.size()).isEqualTo(2);
	}

	@Test
	void update(){
		//given
		Item itemA = new Item("itemA", 10, 10);
		itemRepository.save(itemA);
		//when
		Item updateParam = new Item("itemA", 200, 200);
		itemRepository.update(itemA.getId(), updateParam);
		//then
		Assertions.assertThat(itemA.getPrice()).isEqualTo(200);
	}

	@Test
	void findById(){
		//given

		//when
		//then

	}
}
