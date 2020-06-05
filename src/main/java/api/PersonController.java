package api;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService=personService;
    }


    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);

    }
    @GetMapping
    public List<Person>getAllPeople(){
        return personService.getAllPeron();
    }
   @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonbyId(id).orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletepersonbyid(@PathVariable("id") UUID id)
    {
        personService.deleteperson(id);
    }

    @PutMapping (path="{id}")
    public void updateperson(@PathVariable("id") UUID id,  @Valid @NonNull @RequestBody Person newPerson)
    {
        personService.updateperson(id, newPerson);
    }

}
