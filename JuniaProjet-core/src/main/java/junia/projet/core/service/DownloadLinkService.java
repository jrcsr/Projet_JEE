package junia.projet.core.service;

import junia.projet.core.dao.DownloadLinkDAO;
import junia.projet.core.entity.DownloadLink;
import junia.projet.core.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    public List<DownloadLink> getDownloadLinkByWallpaperIdAndProfile(long id, Profile profile){
        return downloadLinkDAO.findAllByWallpaperIdAndFormatAccessProfileListContaining(id,profile);
    }

    public void deleteAll(){
        downloadLinkDAO.deleteAll();
    }


}
