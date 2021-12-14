package Test20Cucumber;

import io.cucumber.java8.Ru;

import static org.junit.Assert.assertTrue;

public class StepsTest20 implements Ru {

    private Application app = new Application();

    private int AmountOfProductsToAdd;
    private String ProductCategory;
    private int QuantityOfSpecificProduct;
    private String SizeOfSpecificProduct;

    public StepsTest20() {
        Допустим("{string} это количество товаров, которые мы хотим добавить в корзину", (String amount) -> {
            AmountOfProductsToAdd = Integer.valueOf(amount);});
        И("{string} категория товаров на главной странице", (String category) -> {
            ProductCategory = category;});
        И("{string} это количество, а {string} - это размер каждого добавляемогоо товара", (String quantity, String size) -> {
            QuantityOfSpecificProduct = Integer.valueOf(quantity);
            SizeOfSpecificProduct = size;});
        Когда("на главной странице выбираем товар и нажимаем на него", () -> {
            app.chooseParameters(ProductCategory);});
        Тогда("открывается страница товара", () -> {
            assertTrue(Product.prodOpened());});
        Когда("выбираем количество и размер товара, нажав кнопку AddToCart", () -> {
            app.addToCart(QuantityOfSpecificProduct,SizeOfSpecificProduct);});
        Тогда("товары добавляются в корзину", () -> {
            assertTrue(ConditionCart.confirmProd());
            AmountOfProductsToAdd--;});
        Когда("добавили в корзину все необходимые товары", () -> {
            while (AmountOfProductsToAdd>0){
                app.chooseParameters(ProductCategory);
                app.addToCart(QuantityOfSpecificProduct,SizeOfSpecificProduct);
                AmountOfProductsToAdd--;}
            Cart.open();});
        Тогда("открывается страница корзины", () -> {
            assertTrue(Cart.cartOpened());});
        Когда("убираем поочередно все товары из корзины", () -> {
            app.deleteCart();});
        Тогда("корзина опустеет", () -> {
            assertTrue(Cart.cartIsEmpty());
            app.closeApplication();});
    }
}
