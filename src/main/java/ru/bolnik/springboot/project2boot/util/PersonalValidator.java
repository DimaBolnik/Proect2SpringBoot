package ru.bolnik.springboot.project2boot.util;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.bolnik.springboot.project2boot.models.Person;
import ru.bolnik.springboot.project2boot.services.PeopleService;

@Component
public class PersonalValidator implements Validator {

    private final PeopleService peopleService;

    public PersonalValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if(peopleService.getPersonByFullName(person.getFullName()).isPresent())
        {
            errors.rejectValue("fullName", "","Человек с таким ФИО существует.");
        }
    }
}
