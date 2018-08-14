package com.polygalov.restspring.repository;

import com.polygalov.restspring.entity.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<Goods, Long> {

}
