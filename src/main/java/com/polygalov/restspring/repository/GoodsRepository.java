package com.polygalov.restspring.repository;

import com.polygalov.restspring.entity.Goods;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods, Long> {

    List<Goods> findByTitle(String title);
}
