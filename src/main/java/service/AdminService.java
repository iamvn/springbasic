package service;

import dao.AdminDao;
import dao.PersonDao;
import model.Admin;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AdminService {
   private final AdminDao adminDao;
@Autowired
  public AdminService(AdminDao adminDao){
    this.adminDao=adminDao;

  }
  public int addAdmin(@Qualifier("fakeDaoadmin") Admin admin){
      return adminDao.insertAdmin(admin);
  }


    public List<Admin> getAllAdmin()
    {
        return adminDao.getAllAdmin();
    }

    public Optional<Admin> selectAdminById(UUID id){
    return adminDao.selectAdminbyID(id);
    }

    public int deleteAdminById(UUID id){
    return adminDao.deleteAdminById(id);
    }
    public int updateAdminById(UUID id, Admin newadmin){
  return adminDao.UpdateAdminById(id,newadmin);
    }
}
