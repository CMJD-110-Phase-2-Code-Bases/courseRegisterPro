package lk.ijse.cmjd_110.courseRegisterPro.controller.common;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.impl.userRelated.AdminServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController extends GenericController<UserDTO> {
    public AdminController(AdminServiceIMPL adminServiceIMPL) {
        super(adminServiceIMPL);
    }
}

