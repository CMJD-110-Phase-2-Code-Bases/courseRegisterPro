package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;

import java.util.List;

public interface GenericUserService<T> {
    void saveUser(T lecturer);
    T getSelectedUser(String studentId) throws Exception;
    List<T> getAllUsers();
    void updateUser(String lecturerId,T toBeUpdatedLecturer);
    void deleteUser(String lecturerId);
}
