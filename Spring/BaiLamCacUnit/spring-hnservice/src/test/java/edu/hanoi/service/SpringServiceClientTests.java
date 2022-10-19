package edu.hanoi.service;

import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(JUnit4.class)
@SpringBootTest(classes = SpringServiceClientTests.class)
@WebAppConfiguration
public class SpringServiceClientTests {

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }

    @Test
    public void contextLoads() {
//        String address = "http://localhost:8080/list/groups/";
//        ResponseEntity<Group[]> groupEntity = restTemplate.getForEntity(address, Group[].class);
//        Group[] groups = groupEntity.getBody();
//        Assert.assertTrue(groups.length > 0);
//        for (int i = 0; i < groups.length; i++) {
//            System.out.println(groups[i].getId());
//        }


//        User user=new User();
//        user.setUsername("haiphung");
//        user.setPassword("123456");
//        user.setAge(25);
//        user.setGroupId(1);
//        user.setEmail("test1@gmail.com");
//        String add="http://localhost:8080/add/user/";
//        ResponseEntity<String> insertEntity=restTemplate.postForEntity(add,user,String.class);
//        Assert.assertEquals(user.getUsername(),insertEntity.getBody());

        //test check exist
//        String addressU="http://localhost:8080/get/user/haiphung";
//        ResponseEntity<User> entity=restTemplate.getForEntity(addressU,User.class);
//        Assert.assertEquals("123456",entity.getBody().getPassword());

        //test delete
//        String addressDel = "http://localhost:8080/delete/user/haiphung";
//        ResponseEntity<Void> delEntity = restTemplate.getForEntity(addressDel, Void.class);
//        String addressU="http://localhost:8080/get/user/haiphung";
//        ResponseEntity<User> entity=restTemplate.getForEntity(addressU,User.class);
//        Assert.assertEquals("123456",entity.getBody().getPassword());

        String address = "http://localhost:8080/get/user/haiphung";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
        User user = getEntity.getBody();
        Assert.assertNotNull(user);

        user.setPassword("654321");
        address = "http://localhost:8080/update/user/";
        restTemplate.postForEntity(address, user, Void.class);

        address = "http://localhost:8080/get/user/haiphung";
        ResponseEntity<User> getEntity2 = restTemplate.getForEntity(address, User.class);
        Assert.assertEquals(user.getPassword(), getEntity2.getBody().getPassword());
    }
}
