
import hector.tang.Util.MyLog;
import hector.tang.Util.QueryVo;
import hector.tang.dao.IAccountDao;
import hector.tang.dao.IUserDao;
import hector.tang.domain.Account;
import hector.tang.domain.AccountUser;
import hector.tang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用实现Dao的方式实现增删改查
 */
public class MybatisText {
    String resource="sqlMapConfig.xml";
    SqlSession session=null;
    InputStream is;
    IUserDao userDao;
    IAccountDao accountDao;

    public static void main(String[] args) throws Exception{
        String resource="sqlMapConfig.xml";
        //读取配置文件
        InputStream is= Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        //使用factory生成sqlSession
        SqlSession session=factory.openSession();
        //执行代理对象的方法
        IUserDao userDao=session.getMapper(IUserDao.class);

        List<User> users=userDao.findAllUser();

        for (User user:users
             ) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        is.close();
    }
    @Before
    public void before() throws Exception{
        is= Resources.getResourceAsStream(resource);
        session=new SqlSessionFactoryBuilder().build(is).openSession();
        userDao=session.getMapper(IUserDao.class);
        accountDao=session.getMapper(IAccountDao.class);
    }


    @After
    public void after()throws Exception{
        session.commit();
        session.close();
        is.close();
    }


    @Test
    public void findAll(){
        List<User> users =userDao.findAllUser();

        for(User u:users){
            MyLog.info(u);
            if(u.getAccounts()!=null)
                MyLog.info(u.getAccounts());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void findUserByID(){
        User user=userDao.findUserByID(5);

        MyLog.info(user);
    }

    @Test
    public void findAllAccount(){
        List<Account> accounts=accountDao.findAll();
        for(Account account:accounts){
            MyLog.info(account);
            if(account.getUser()!=null)
                MyLog.info(account.getUser());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void findAccount(){
        List<Account> accounts=accountDao.findAccount();
        for(Account account:accounts){
            MyLog.info(account);
        }
    }

    @Test
    public void findUserAndAccount(){
        List<User> users=userDao.findUserAndAccount();

        for(User u:users){
            MyLog.info(u);
            if(u.getAccounts()==null||u.getAccounts().size()==0){

            }else{

                MyLog.info(u.getAccounts());
            }
        }
    }


}
