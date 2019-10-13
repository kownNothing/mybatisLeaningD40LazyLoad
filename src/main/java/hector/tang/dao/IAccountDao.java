package hector.tang.dao;

import hector.tang.domain.Account;
import hector.tang.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    List<Account> findAccount();

    List<Account> findAccountByUID();
}
