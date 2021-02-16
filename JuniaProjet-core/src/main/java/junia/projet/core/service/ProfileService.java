package junia.projet.core.service;

import junia.projet.core.dao.ProfileDAO;
import junia.projet.core.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService {

    private ProfileDAO profileDAO;

    public ProfileService(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public void save(Profile profile){
        profileDAO.save(profile);
    }

    public Profile getById(long id){
        return profileDAO.findById(id);
    }

    public void deleteAll(){
        profileDAO.deleteAll();
    }
}
