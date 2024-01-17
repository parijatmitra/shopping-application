package com.shoppingapplication.shoppingapplication.service;

import com.shoppingapplication.shoppingapplication.model.Shop;
import com.shoppingapplication.shoppingapplication.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return shopRepository.findAllShopsWithoutMenuItemList();
    }

    public Shop getShopWithAllMenuItemsById(int shopId) {
        Optional<Shop>shopOptional = shopRepository.findById(shopId);
        return shopOptional.orElse(null);
    }

    public Shop createShop(Shop shop) {
        if(shop.getId() > 0) return null;
        shop.setId(0);
        return shopRepository.save(shop);
    }

    public Shop updateShop(Shop shop) {
        if(shopRepository.findById(shop.getId()).orElse(null) == null) {
            return null;
        }
        return shopRepository.save(shop);
    }
    //git
    public void deleteShop(int shopId) {
       shopRepository.deleteById(shopId);
    }
}
