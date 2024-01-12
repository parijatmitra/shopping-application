package com.shoppingapplication.shoppingapplication.service;

import com.shoppingapplication.shoppingapplication.model.MenuItem;
import com.shoppingapplication.shoppingapplication.model.Shop;
import com.shoppingapplication.shoppingapplication.repository.MenuItemRepository;
import com.shoppingapplication.shoppingapplication.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    ShopRepository shopRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getAllMenuItemsByShopId(int shopId) {
         Shop shop = shopRepository.findById(shopId).orElse(null);
         if(shop == null) return null;
         return menuItemRepository.findByShop(shop);
    }

    public List<MenuItem> getAllMenuItemsByName(String name) {
        return menuItemRepository.findByNameLikeIgnoreCase("%" + name + "%");
    }

    public MenuItem getMenuItemById(int menuItemId) {
        return menuItemRepository.findById(menuItemId).orElse(null);
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
       if(menuItem.getId() > 0) return null;
       Shop parentShop = shopRepository.findById(menuItem.getShop_id()).orElse(null);
       if(parentShop == null) return null;
       menuItem.setId(0);
       menuItem.setShop(parentShop);
       return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        if(menuItemRepository.findById(menuItem.getId()).orElse(null) == null) return null;
        return  menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(int menuItemId) {
        menuItemRepository.deleteById(menuItemId);
    }
}
