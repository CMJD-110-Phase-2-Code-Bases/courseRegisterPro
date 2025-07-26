package lk.ijse.cmjd_110.courseRegisterPro.controller.common;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.impl.userRelated.LecturerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lecturer")
public class LecturerController extends GenericController<UserDTO> {
    @Autowired
    public LecturerController(LecturerServiceIMPL lecturerService) {
        super(lecturerService);
    }
}

