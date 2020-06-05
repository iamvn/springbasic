package dao;

import model.Admin;
import model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDaoadmin")
public  class FakeAdminDataAccessService implements AdminDao {

    private static List<Admin> AD = new ArrayList<>();


    @Override
    public int insertAdmin(UUID id, Admin admin) {
        AD.add(new Admin(id, admin.getName()));
        return 1;
    }


    @Override
    public List<Admin> getAllAdmin() {
        return AD;
    }

    @Override
    public Optional<Admin> selectAdminbyID(UUID id) {
        return AD.stream().filter(admin -> admin.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteAdminById(UUID id) {
        Optional<Admin> adminMaybe = selectAdminbyID(id);
        if (adminMaybe.isEmpty()) {
            return 0;
        }
        AD.remove(adminMaybe.get());
        return 1;
    }

    @Override
    public int UpdateAdminById(UUID id, Admin adminupdate) {
        return selectAdminbyID(id).map(admin1 -> {
            int indexofAdmin = AD.indexOf(admin1);
            if (indexofAdmin >= 0) {
                AD.set(indexofAdmin, new Admin(id, adminupdate.getName()));
                return 1;
            }
            return 0;
        })
                .orElse(0);

    }
}




