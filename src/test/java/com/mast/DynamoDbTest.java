// package com.mast;

// import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
// import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
// import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
// import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
// import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
// import com.mast.Application;
// import com.mast.model.User;
// import com.mast.data.dynamodb.repositories.UserRepository;
// import com.mast.rule.LocalDbCreationRule;
// import org.junit.Before;
// import org.junit.ClassRule;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import com.mast.data.UserType;

// import java.util.List;

// import static org.hamcrest.Matchers.greaterThan;
// import static org.hamcrest.core.Is.is;
// import static org.hamcrest.core.IsEqual.equalTo;
// import static org.junit.Assert.assertThat;

// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringBootTest(classes = Application.class)
// @WebAppConfiguration
// @ActiveProfiles("local")
// @TestPropertySource(properties = { "amazon.dynamodb.endpoint=http://localhost:8000/", "amazon.aws.accesskey=test1", "amazon.aws.secretkey=test231" })
// public class DynamoDbTest {

//     @ClassRule
//     public static LocalDbCreationRule dynamoDB = new LocalDbCreationRule();

//     private DynamoDBMapper dynamoDBMapper;

//     @Autowired
//     private AmazonDynamoDB amazonDynamoDB;

//     @Autowired
//     UserRepository repository;

//     private static final String EXPECTED_COST = "20";
//     private static final String EXPECTED_PRICE = "50";

//     @Before
//     public void setup() throws Exception {

//         try {
//             dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

//             CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(User.class);

//             tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

//             amazonDynamoDB.createTable(tableRequest);
//         } catch (ResourceInUseException e) {
//             // Do nothing, table already created
//         }

//         // TODO How to handle different environments. i.e. AVOID deleting all entries in ProductInfo on table
//         dynamoDBMapper.batchDelete((List<User>) repository.findAll());
//     }

//     @Test
//     public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
        
//         User user = new User(1L,"matt","good","goodrea","goodrea@umd.edu",UserType.STUDENT);
//         repository.save(user);

//         List<User> result = (List<User>) repository.findAll();
//         assertThat(result.size(), is(greaterThan(0)));
//         assertThat(result.get(0).getFirstName(), is(equalTo("matt")));
//     }
// }
