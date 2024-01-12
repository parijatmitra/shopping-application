package com.shoppingapplication.shoppingapplication.controller;

import com.shoppingapplication.shoppingapplication.model.MenuItem;
import com.shoppingapplication.shoppingapplication.service.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class MenuItemController {
    @Autowired
    MenuItemService menuItemService;

    @RequestMapping(value = "/menu-items", method = RequestMethod.GET)
    public ResponseEntity<List<MenuItem>> getAllMenuItems(@RequestParam(name = "shop-id", required = false) Integer shopId,
                                                          @RequestParam(name = "name", required = false) String menuItemName) {
         List<MenuItem>menuItems = menuItemService.getAllMenuItems();
         if(shopId != null) {
             menuItems = menuItemService.getAllMenuItemsByShopId(shopId);
         } else if(menuItemName != null && !menuItemName.trim().isEmpty()) {
             menuItems = menuItemService.getAllMenuItemsByName(menuItemName);
         }
         if(menuItems == null || menuItems.isEmpty()) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(menuItems, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/menu-items/{id}", method = RequestMethod.GET)
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable("id") int menuItemId) {
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);
        if(menuItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menuItem, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/menu-items", method = RequestMethod.POST)
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem newMenuItem = menuItemService.createMenuItem(menuItem);
        if(newMenuItem == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newMenuItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/menu-items/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable("id") int menuItemId, @RequestBody MenuItem menuItem) {
        menuItem.setId(menuItemId);
        MenuItem newMenuItem = menuItemService.updateMenuItem(menuItem);
        if(newMenuItem == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newMenuItem, HttpStatus.OK);
    }

    @RequestMapping(value = "/menu-items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MenuItem> deleteMenuItem(@PathVariable("id") int menuItemId) {
        menuItemService.deleteMenuItem(menuItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
