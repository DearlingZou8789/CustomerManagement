package Demo;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import dao.CustomerDao;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by codingBoy on 16/10/23.
 */
public class Demo
{
    QueryRunner qr=new TxQueryRunner();
    public static void main(String[] args)
    {
        CustomerDao customerDao=new CustomerDao();

        String[] names = {"zmj", "wjl", "zmj_son", "zmj_daught", "wjl_son", "wjl_daught"};
        for (int i=0;i<4000;i++)
        {
            Customer customer=new Customer();
            customer.setId(CommonUtils.uuid());
            int num = (int)Math.random() % (names.length);
            customer.setName(names[num]+i);
            customer.setGender(i%2==0?"male":"female");
            customer.setPhone("13476"+i);
            customer.setEmail("customer"+i+"@163.com");
            customer.setDescription("helle world");

            customerDao.add(customer);
        }
    }
}
