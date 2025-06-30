package com.kainmvc.cart_ban_hoa.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Candy,Integer> candies = new HashMap<>();

    public Cart(){}

    public Cart(Map<Candy, Integer> candies) {
        this.candies = candies;
    }

    public Map<Candy, Integer> getCandies() {
        return candies;
    }

    private boolean checkItemInCart(Candy candy){
        for(Map.Entry<Candy, Integer> entry: candies.entrySet()){
            if(entry.getKey().getId().equals(candy.getId())){
                return true;
            }
        }
        return false;
    }


    private Map.Entry<Candy,Integer> selectItemInCart(Candy candy){
        for (Map.Entry<Candy, Integer> entry : candies.entrySet()){
            if(entry.getKey().getId().equals(candy.getId())){
                return entry;
            }
        }
        return null;
    }


    public void addCandy(Candy candy){
        if(!checkItemInCart(candy)){
            candies.put(candy,1);
        }else{
            Map.Entry<Candy,Integer> candyIntegerEntry=selectItemInCart(candy);
            Integer newQuantity = candyIntegerEntry.getValue() +1;
            candies.replace(candyIntegerEntry.getKey(),newQuantity);
        }
    }



    public void minusCandy(Candy candy){
        Map.Entry<Candy,Integer> candyEntry = selectItemInCart(candy);
        if(candyEntry!=null){
            Integer newQuantity = candyEntry.getValue() - 1;
            if(newQuantity==0){
                candies.remove(candyEntry.getKey());
            }else{
                candies.replace(candyEntry.getKey(),newQuantity);
            }
        }
    }

    public void deleteCandy(Candy candy){
        Map.Entry<Candy,Integer> candyEntry=selectItemInCart(candy);
        if(candyEntry!=null) {
            candies.remove(candyEntry.getKey());
        }
    }

    public Integer countCandyQuantity(){
        Integer candyQuantity = 0;
        for(Map.Entry<Candy,Integer> entry : candies.entrySet()){
            candyQuantity += entry.getValue();
        }
        return candyQuantity;
    }

    public Integer countItemQuantity(){
        return candies.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for(Map.Entry<Candy, Integer> entry: candies.entrySet()){
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
