package service;

import dao.PersonDao;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeron(){
        return personDao.getPersonAll();
    }

    public Optional<Person> getPersonbyId(UUID id){
        return personDao.slectPersonbyId(id);
    }
    public int deleteperson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updateperson(UUID id,Person newperson){
        return personDao.updatePersonById(id, newperson);
    }

}
