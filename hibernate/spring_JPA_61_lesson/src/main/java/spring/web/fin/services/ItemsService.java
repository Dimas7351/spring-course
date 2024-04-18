package spring.web.fin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.web.fin.models.Item;
import spring.web.fin.models.Person;
import spring.web.fin.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByItemName(String itemName){
        return itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }


}
