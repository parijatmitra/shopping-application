package com.shoppingapplication.shoppingapplication.controller;

import com.shoppingapplication.shoppingapplication.model.Shop;
import com.shoppingapplication.shoppingapplication.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value="/shops", method = RequestMethod.GET)
    public ResponseEntity<List<Shop>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @RequestMapping(value="/shops/full/{id}", method = RequestMethod.GET)
    public ResponseEntity<Shop> getShopById(@PathVariable("id") int shopId) {
        Shop shop = shopService.getShopWithAllMenuItemsById(shopId);
        if(shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop, HttpStatus.FOUND);
    }

    @RequestMapping(value="/shops", method = RequestMethod.POST)
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        if(createdShop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/shops/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Shop> updateShop(@PathVariable("id") int shopId, @RequestBody Shop shop) {
           shop.setId(shopId);
           Shop updatedShop = shopService.updateShop(shop);
           if(updatedShop == null) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
           return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    @RequestMapping(value = "/shops/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Shop>deleteShop(@PathVariable("id") int shopId) {
        shopService.deleteShop(shopId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
