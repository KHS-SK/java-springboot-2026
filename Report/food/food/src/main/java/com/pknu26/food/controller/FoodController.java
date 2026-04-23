package com.pknu26.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pknu26.food.dto.Food;
import com.pknu26.food.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods(){
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
        public Food getFoodById(@PathVariable Long id){
            return foodService.getFoodById(id);
        }
    

    @PostMapping
    public String addFood(@RequestBody Food food) {
        int result = this.foodService.addFood(food);
        return result == 1 ? "등록 성공" : "등록 실패";
    }
}
