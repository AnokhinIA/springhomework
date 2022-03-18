package lesson30.JPA.controller;

import lesson30.JPA.model.Insurers;
import lesson30.JPA.repositories.InsurersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

@Service
@ShellComponent
public class InsurersController  {

    @Autowired
    private InsurersRepositories insurersRepositories;

    @ShellMethod(value = "Add Insurer", key = "add")
    public void addInsurer(@Size(max = 255) String name, @Size(max = 255) String address) {
        //Созданим нового Страховщика
        //TODO Настроить занесение всех параметров согласно данным ЦБ РФ

        Insurers insurer = new Insurers();
        //insurer.setFederalDistrict("Центральный федеральный округ");
        insurer.setName(name);
        insurer.setAddress(address);
        //insurer.setLineOfBusiness("Добровольное личное страхование, за исключением добровольного страхования жизни");
        //insurer.setPersonalTaxReferenceNumber((int) 7704311252.00);
        //insurer.setMotor(true);
        insurersRepositories.save(insurer);
        System.out.println(insurer.getName() + " Сохранение прошло успешно");
    }

    @ShellMethod (value = "Delete insurers", key = "Del")
    public void deleteInsurer (long ID){
        insurersRepositories.deleteAllById(Collections.singleton(ID));
    }

    @ShellMethod (value = "Show all insurers", key = "Show")
    public void showAll(){
       List<Insurers> insurersList = insurersRepositories.findAll();
       int count = 0;
       for (Insurers i:insurersList){
           count ++;
           System.out.println(count + ". " + "| ID " + i.getId() + "  | " + i.toString());
       }
    }
}

