package ru.leather.onlineshop.service;

import ru.leather.onlineshop.model.Orrder;

import java.util.List;

public interface OrrderService {

    Orrder addOrrder(Orrder orrder);

    void deleteOrrder(Integer id);

    Orrder editOrrder(Orrder orrder);

    Orrder getOrrderbyId(Integer id);

    List<Orrder> getAll();
}
