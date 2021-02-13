package junia.projet.core.junia.projet.core.service;

import junia.projet.core.dao.DownloadLinkDAO;
import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import org.springframework.stereotype.Service;

@Service
public class DownloadLinkService {

    private DownloadLinkDAO downloadLinkDAO;

    public DownloadLinkService(DownloadLinkDAO downloadLinkDAO) {
        this.downloadLinkDAO = downloadLinkDAO;
    }

    public void save(DownloadLink downloadLink){
        downloadLinkDAO.save(downloadLink);
    }

    public DownloadLink getById(long id){
        return downloadLinkDAO.findById(id);
    }

    /**En réalité j'aimerai que la fonction me renvoie un booléen en réponse à la question suivante: pour mon download link d'id id, le profile entré est-il contenu dans l'access du format associé au link**/
    public DownloadLink check(Profile profile, long id){
        return downloadLinkDAO.findByFormatAccessProfileListContainingAndIdEquals(profile,id);
    }

    public void deleteAll(){
        downloadLinkDAO.deleteAll();
    }


}
