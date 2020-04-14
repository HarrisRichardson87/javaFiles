package academy.learnprogramming;



import java.util.List;

public class Cart {
    private List<Product> shoppingCart;

    public Cart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    //getters
    public int getTotal() {
        int total = 0;
        int count = 0;
        for (int i = 0; i < shoppingCart.size() - 1; i++) {
            total += shoppingCart.get(i).getPrice();
            if (shoppingCart.get(i).getName() == shoppingCart.get(i + 1).getName()) {
                count++;
                System.out.println(count);
                if (count == 3) {
                    count = 0;
                    total = total - shoppingCart.get(i).getPrice();
                    System.out.println(shoppingCart.get(i).getName());
                }
            }
        }
        total = total + (shoppingCart.get(shoppingCart.size() - 1).getPrice());
        if (shoppingCart.size() >= 5) {
            total = (int) (total - (total * .1));
        }

        return total;
    }

    //setter



    public void setShoppingCart(String name, Product replacement) {
        for (int i = 0; i < shoppingCart.size(); i++){
            if(name == shoppingCart.get(i).getName()){
                shoppingCart.set(i,replacement);
                System.out.println(shoppingCart.get(i).getName());
            }
        }


    }
}


