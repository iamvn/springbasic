package api;

import model.Admin;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }
    @PostMapping
    public void addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
    }

   @GetMapping
   public  List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @GetMapping(path = "{id}")
    public Admin selectAdminbyId(@PathVariable("id") UUID id){

        return adminService.selectAdminById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteAdminById(@PathVariable("id") UUID id){
        adminService.deleteAdminById(id);
    }

    @PutMapping(path = "{id}")
    public void updateAdminById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Admin newadmin){
        adminService.updateAdminById(id,newadmin);

    }





}


