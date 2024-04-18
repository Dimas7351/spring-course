package spring.web.fin.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.web.fin.models.Item;
import spring.web.fin.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String itemName);

    // person.getItems()
    List<Item> findByOwner(Person owner);  // Owner - то, что есть в сущности
}
