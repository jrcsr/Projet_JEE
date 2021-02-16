package junia.projet.core.service;

import junia.projet.core.dao.AccessDAO;
import junia.projet.core.entity.Access;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccessService {

    private AccessDAO accessDAO;

    public AccessService(AccessDAO accessDAO) {
        this.accessDAO=accessDAO;
    }

    public void save(Access access){
        accessDAO.save(access);
    }

    public Access getAccessById(long id){
        return accessDAO.findById(id);
    }

    public void deleteAll(){
        accessDAO.deleteAll();
    }

}
