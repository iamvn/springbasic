package dao;

import model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB =new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPersonAll() {
        return DB;
    }

    @Override
    public Optional<Person> slectPersonbyId(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
         Optional<Person> personMaybe = slectPersonbyId(id);
           if(personMaybe.isEmpty()){
               return 0;
           }
           DB.remove(personMaybe.get());
           return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person updateperson) {
        return slectPersonbyId(id)
                .map(person -> {
                  int indexofPersonToUpdate = DB.indexOf(person);
                  if (indexofPersonToUpdate >= 0) {
                       DB.set(indexofPersonToUpdate, new Person(id,updateperson.getName()));
                       return 1;
                 }
                  return 0;
                          })
                .orElse(0);
    }

}
