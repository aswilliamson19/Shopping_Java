import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket1;
    private ShoppingBasket shoppingBasket2;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Before
    public void before(){
        product1 = new Product("apple", 0.5, false);
        product2 = new Product("loaf", 1, true);
        product3 = new Product("butter", 1.5, false);
        product4 = new Product("pizza", 6.5, true);

        shoppingBasket1 = new ShoppingBasket(true);
        shoppingBasket2 = new ShoppingBasket(false);
        shoppingBasket1.addItem(product1);
        shoppingBasket1.addItem(product4);

        shoppingBasket2.addItem(product4);
        shoppingBasket2.addItem(product2);
        shoppingBasket2.addItem(product3);
    }

    @Test
    public void hasALoyaltyCard(){
        assertEquals(true, shoppingBasket1.hasALoyaltyCard());
    }

    @Test
    public void canGetItems(){
        assertEquals(3, shoppingBasket2.countItems());
    }

    @Test
    public void canGetBasketTotal(){
        assertEquals(9, shoppingBasket2.getBasketTotal(), 0.01);
    }

    @Test
    public void canAddTotalWithOffers(){
        assertEquals(6.86, shoppingBasket1.totalPrice(), 0.01);
    }

    @Test
    public void canAddBasketWithoutLoyalityCard(){
        assertEquals(9, shoppingBasket2.totalPrice(), 0.01);
    }

    @Test
    public void canRemoveAnItem(){
        shoppingBasket1.removeItem(product1);
        assertEquals(6.5, shoppingBasket1.getBasketTotal(), 0.01);
    }

    @Test
    public void canEmptyShoppingBasket(){
        shoppingBasket1.emptyItems();
        assertEquals(0, shoppingBasket1.countItems());
        assertEquals(0, shoppingBasket1.getBasketTotal(), 0.01);
    }

}
