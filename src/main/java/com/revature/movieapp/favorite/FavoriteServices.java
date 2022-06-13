package com.revature.movieapp.favorite;

import com.revature.movieapp.creditcard.CreditCardDao;
import com.revature.movieapp.order.OrderDao;
import com.revature.movieapp.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FavoriteServices implements Serviceable<Favorite> {
    private final FavoriteDao favoriteDao;
    private final OrderDao orderDao;

    private final CreditCardDao creditCardDao;

    @Autowired
    public FavoriteServices(FavoriteDao favoriteDao, OrderDao orderDao, CreditCardDao creditCardDao){

        this.favoriteDao = favoriteDao;
        this.orderDao = orderDao;
        this.creditCardDao = creditCardDao;

    }

    @Override
    public Favorite create(Favorite newFavorite) {
        return favoriteDao.save(newFavorite);
    }

    @Override
    public List<Favorite> readAll() {
            return (List<Favorite>)  favoriteDao.findAll();
    }

    @Override
    public Favorite readById(String favoriteName) {
        return  favoriteDao.findById(favoriteName).get();
    }

    @Override
    public Favorite update(Favorite updatedFavorite) {
        favoriteDao.save(updatedFavorite);
        return updatedFavorite;
    }

    @Override
    public boolean delete(String name) {
        try {
            favoriteDao.deleteById(name);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean validateInput(Favorite object) {
        return false;
    }
}
