package com.revature.blockbusster.util.interfaces;

import java.util.List;

public interface Serviceable<C> {

    // Create
    C create(C newObject);

    // Read
  //  List<C> readAll();
    C readById(String id);

    // Update
    C update(C updatedObject);

    // Delete
    boolean delete(String id);

   // boolean validateInput(C object);


}

