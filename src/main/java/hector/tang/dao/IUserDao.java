package hector.tang.dao;

import hector.tang.Util.QueryVo;
import hector.tang.domain.User;

import java.util.List;

public interface IUserDao {

    User findUserByID(int id);

    List<User> findAllUser();

    /**
     * 查询用户及其账户信息，并不是所有的用户都有帐户信息
     * @return
     */
    List<User> findUserAndAccount();
}
