package com.polygalov.restspring.controller;

import com.polygalov.restspring.entity.Goods;
import com.polygalov.restspring.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {

        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Goods> goods = goodsRepository.findAll();

        model.put("goods", goods);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String title, @RequestParam String description,@RequestParam String category, Map<String, Object> model) {
        Goods goods = new Goods(title, description, category);
        goodsRepository.save(goods);

        Iterable<Goods> goodsIterable = goodsRepository.findAll();
        model.put("goods", goodsIterable);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Goods> goods;

        if (filter != null && !filter.isEmpty()) {
            goods = goodsRepository.findByTitle(filter);
        } else {
            goods = goodsRepository.findAll();
        }

        model.put("goods", goods);

        return "main";
    }
}