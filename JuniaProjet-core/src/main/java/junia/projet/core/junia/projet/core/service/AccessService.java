package junia.projet.core.junia.projet.core.service;

import junia.projet.core.dao.AccessDAO;
import junia.projet.core.entity.Access;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessService {

    private AccessDAO accessDAO;

    public AccessService(AccessDAO accessDAO) {
        this.accessDAO = accessDAO;
    }

    public void save(Access access){
        accessDAO.save(access);
    }

    public Access getAccessById(long id){
        return accessDAO.findById(id);
    }

    public List<Access> getAccessByProfile(long profileId){
        List<Access> accessList=accessDAO.getListOfAccessByProfile(profileId);
        return accessList;
    }
}
