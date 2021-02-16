package junia.projet.core.service;

import junia.projet.core.dao.FormatDAO;
import junia.projet.core.entity.Format;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormatService {

    private FormatDAO formatDAO;

    public FormatService(FormatDAO formatDAO) {
        this.formatDAO = formatDAO;
    }

    public void save(Format format){
        formatDAO.save(format);
    }

    public Format getById(long id){
        return formatDAO.findById(id);

    }

    public void deleteAll(){
        formatDAO.deleteAll();
    }

}
