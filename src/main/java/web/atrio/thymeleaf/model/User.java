package web.atrio.thymeleaf.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String birthdayStr;
    private LocalDate birthday;
    private Integer age;

    //Empty constructor used for userForm object from thymeleaf view model
    public User(){};

    public User(String fname, String lname, String birthday) throws DateTimeException{
        this.firstName = fname;
        this.lastName = lname;
        this.birthdayStr = birthday;
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE);
        //Age computation
        LocalDate now = LocalDate.now();
        Period agePeriod = Period.between(this.birthday, now);
        if( agePeriod.getYears() > 0)
            this.age = agePeriod.getYears();
        else
            throw new DateTimeException("Date de naissance impossible ! (Age <= 0ans)");
    }
    
    @Override
    public String toString(){
        return "[User] id="+this.id+" "+
            "firstName="+this.firstName+" "+
            "lastName="+this.lastName+" "+
            "birthday="+this.birthday.format(DateTimeFormatter.ISO_LOCAL_DATE)+" "+
            "age="+age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate dateOfBirth) {
        this.birthday = dateOfBirth;
    }
    
    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
