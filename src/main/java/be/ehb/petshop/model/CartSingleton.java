package be.ehb.petshop.model;

import java.util.HashMap;

public enum CartSingleton {

    INSTANCE;

    private final HashMap<TJProduct, Integer> cart;

    CartSingleton() {
        this.cart = new HashMap<>();
    }

    public HashMap<TJProduct, Integer> getCart() {
        return cart;
    }

    public void addToCart(TJProduct product){
        if(cart.containsKey(product)){
            int amount = cart.get(product);
            amount++;
            cart.put(product, amount);
        }else{
            cart.put(product, 1);
        }
    }

    public void removeFromCart(TJProduct product){
        cart.remove(product);
    }

    public float getTotal() {
        float total = 0;
        for(TJProduct p : cart.keySet()){
            total += (p.getPrice() * cart.get(p));
        }
        return total;
    }
}
