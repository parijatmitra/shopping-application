package com.shoppingapplication.shoppingapplication.repository;

import com.shoppingapplication.shoppingapplication.model.MenuItem;
import com.shoppingapplication.shoppingapplication.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
         public List<MenuItem> findByShop(Shop shop);
         public MenuItem findByShopAndName(Shop shop, String name);
         public List<MenuItem> findByNameLikeIgnoreCase(String name);
}
