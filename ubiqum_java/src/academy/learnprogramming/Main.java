package academy.learnprogramming;

import academy.learnprogramming.Product;
import academy.learnprogramming.Cart;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Product test = new Product("pencil", 3);
        Product vacuum = new Product("vacuum", 10);

        List<Product> testCart = new ArrayList<>();
        testCart.add(test);
        testCart.add(test);
        testCart.add(test);
        testCart.add(test);
        testCart.add(vacuum);

        Cart mainCart = new Cart (testCart);
        System.out.println("total is " + mainCart.getTotal());
        mainCart.setShoppingCart("pencil",new Product("stuff",10));
    }
}
