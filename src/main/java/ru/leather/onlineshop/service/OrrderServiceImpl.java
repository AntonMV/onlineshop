package ru.leather.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leather.onlineshop.model.Orrder;
import ru.leather.onlineshop.repository.OrrderRepository;

import java.util.List;

@Service
public class OrrderServiceImpl implements OrrderService {

    @Autowired
    private OrrderRepository orrderRepository;

    @Override
    public Orrder addOrrder(Orrder orrder) {
        return orrderRepository.saveAndFlush(orrder);
    }

    @Override
    public void deleteOrrder(Integer id) {
        orrderRepository.delete(id);
    }

    @Override
    public Orrder editOrrder(Orrder orrder) {
        return orrderRepository.saveAndFlush(orrder);
    }

    @Override
    public Orrder getOrrderbyId(Integer id) {
        return orrderRepository.getOne(id);
    }

    @Override
    public List<Orrder> getAll() {
        return orrderRepository.findAll();
    }
}
