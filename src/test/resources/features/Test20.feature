# language: ru
Функция:Добавление и удаление товаров

  Сценарий:
    Допустим '3' это количество товаров, которые мы хотим добавить в корзину
    И 'Campaigns' категория товаров на главной странице
    И '1' это количество, а 'Medium' - это размер каждого добавляемогоо товара
    Когда на главной странице выбираем товар и нажимаем на него
    Тогда открывается страница товара
    Когда выбираем количество и размер товара, нажав кнопку AddToCart
    Тогда товары добавляются в корзину
    Когда добавили в корзину все необходимые товары
    Тогда открывается страница корзины
    Когда убираем поочередно все товары из корзины
    Тогда корзина опустеет
