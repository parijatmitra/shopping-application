package com.shoppingapplication.shoppingapplication.repository;

import com.shoppingapplication.shoppingapplication.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query("select new Shop(a.id, a.name, a.city, a.address, a.email, a.phone, a.open_at, a.close_at) from Shop a")
    public List<Shop> findAllShopsWithoutMenuItemList();
}
