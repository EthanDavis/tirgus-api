package com.tirgusapi;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DatabaseConfig {

   @Autowired
   private Environment env;

   @ConfigurationProperties(prefix = "datasource.postgres")
   @Bean
   @Primary
   public DataSource dataSource() {
      JsonNode secrets = this.getDbSecrets();
      if (secrets == null) {
         throw new RuntimeException("Unable to connect to DB, Could not retrieve secrets");
      }

      return DataSourceBuilder
          .create()
          .username(secrets.get("user").textValue())
          .password(secrets.get("password").textValue())
          .url(secrets.get("host").textValue() + ":" + secrets.get("port").textValue() + "/trigus_api_db")
          .driverClassName("org.postgresql.Driver")
          .build();
   }

   private JsonNode getDbSecrets() {
      String secretName = env.getProperty("spring.aws.secretsmanager.secretName");
      String endpoints = env.getProperty("spring.aws.secretsmanager.endpoint");
      String AWS_Region = env.getProperty("spring.aws.secretsmanager.region");
      AwsClientBuilder.EndpointConfiguration config = new AwsClientBuilder.EndpointConfiguration(endpoints, AWS_Region);
      AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
      clientBuilder.setEndpointConfiguration(config);
      AWSSecretsManager client =
          clientBuilder.build();

      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode secretsJson = null;

      GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);

      GetSecretValueResult getSecretValueResponse = null;

      try {
         getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
      } catch (ResourceNotFoundException e) {
         System.out.println("The requested secret " + secretName + " was not found");
      } catch (InvalidRequestException e) {
         System.out.println("The request was invalid due to: " + e.getMessage());
      } catch (InvalidParameterException e) {
         System.out.println("The request had invalid params: " + e.getMessage());
      }

      if (getSecretValueResponse == null) {
         return null;
      }

      String secret = getSecretValueResponse.getSecretString();

      if (secret != null) {
         try {
            secretsJson = objectMapper.readTree(secret);
         } catch (IOException e) {
            System.out.println("Exception while retrieving secret values: " + e.getMessage());
         }
      } else {
         return null;
      }
      return secretsJson;
   }
}


