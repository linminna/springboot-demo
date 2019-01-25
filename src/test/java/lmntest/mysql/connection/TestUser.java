package lmntest.mysql.connection;

import com.lmn.mybatis.MyBatisApplication;
import com.lmn.mybatis.model.User;
import com.lmn.mybatis.service.UserSearchRepository;
import com.lmn.mybatis.service.UserService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.util.List;

/**
 * @program: lmntest
 * @description: 测试
 * @author: linminna
 * @create: 2018-12-05 20:13
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyBatisApplication.class)
public class TestUser {
    @Autowired
    protected UserService userService;

    @Autowired
    private UserSearchRepository userSearchRepository;

    @Test
    public void test() {
        User user = userService.getUserById(1686217);
        System.out.println(user.getUserId() + ":" + user.getRealName());
    }

    @Test
    public void testES() {
        List<User> userList = userSearchRepository.findUserByRealName("钱丙荣");
        for (User user : userList) {
            System.out.println(user.getUserId() + ":" + user.getRealName());
        }


        try {
            Settings settings = Settings.builder().put("cluster.name", "kqzo-sB").build();//elasticsearch
            Client client = TransportClient.builder().settings(settings)
                    .build().addTransportAddress(
                            new InetSocketTransportAddress(
                                    InetAddress.getByName("127.0.0.1"), 9300));

            //GetResponse response = client.prepareGet("lmntest", "persons", "1").get();

            SearchResponse res = client.prepareSearch("lmntest")
                    .setTypes("persons").get();
            System.out.println(res);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
