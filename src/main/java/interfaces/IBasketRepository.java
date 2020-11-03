package interfaces;

import models.Basket;

import java.util.List;

public interface IBasketRepository extends IEntityRepository<Basket>{
    List<Basket> getMyBasket(String username);

    void moveBackTheBook(int id,String username);

    void removeOrderSByBookID(int bookId);

    Basket checkBasket(int id,String username);
}
