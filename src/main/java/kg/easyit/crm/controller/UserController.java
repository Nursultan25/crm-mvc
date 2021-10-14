package kg.easyit.crm.controller;

import kg.easyit.crm.dto.ManagerDTO;
import kg.easyit.crm.dto.UserDTO;
import kg.easyit.crm.service.ManagerService;
import kg.easyit.crm.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final ManagerService managerService;

    @RequestMapping(value = "/register")
    public String registerV2() {
        return "registerV2-form";
    }

    @RequestMapping(value = "/confirmation")
    public String confirmation(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam String phoneNumber) {

        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setFirstName(firstName);
        managerDTO.setLastName(lastName);
        managerDTO.setEmail(email);
        managerDTO.setPhoneNumber(phoneNumber);
        managerService.save(managerDTO);
        return "confirmation-form";
    }
}
