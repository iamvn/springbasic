package dao;

import model.Admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminDao {
   int insertAdmin(UUID id,Admin admin);

   default int insertAdmin(Admin admin){
       UUID id=UUID.randomUUID();
       return insertAdmin(id,admin);
   }

   List<Admin> getAllAdmin();

   Optional<Admin> selectAdminbyID(UUID id);

   int deleteAdminById(UUID id);

   int UpdateAdminById(UUID id, Admin admin);

}
