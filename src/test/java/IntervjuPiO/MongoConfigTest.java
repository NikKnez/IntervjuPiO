package IntervjuPiO;

import IntervjuPiO.config.MongoConfig;
import com.mongodb.client.MongoClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MongoConfigTest {

    @Test
    public void testMongoClientBean() {
        // Create a mock MongoClient instance
        MongoClient mockMongoClient = Mockito.mock(MongoClient.class);

        // Create a MongoConfig instance
        MongoConfig mongoConfig = new MongoConfig() {
            @Override
            public MongoClient mongoClient() {
                return mockMongoClient;
            }
        };

        // Verify that the mongoClient bean returns the mock MongoClient
        assertEquals(mockMongoClient, mongoConfig.mongoClient());
    }

    @Test
    public void testMongoTemplateBean() {
        // Create a mock MongoTemplate instance
        MongoTemplate mockMongoTemplate = Mockito.mock(MongoTemplate.class);

        // Create a mock MongoClient instance
        MongoClient mockMongoClient = Mockito.mock(MongoClient.class);

        // Create a MongoConfig instance
        MongoConfig mongoConfig = new MongoConfig() {
            @Override
            public MongoTemplate mongoTemplate() {
                return mockMongoTemplate;
            }

            @Override
            public MongoClient mongoClient() {
                return mockMongoClient;
            }
        };

        // Verify that the mongoTemplate bean returns the mock MongoTemplate
        assertEquals(mockMongoTemplate, mongoConfig.mongoTemplate());
    }
}

