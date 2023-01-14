package com.example.integrationtest;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

import java.util.Collections;
import java.util.stream.Stream;

@Log4j2
@Testcontainers
@ContextConfiguration(initializers = AbstractDockerTest.Initializer.class)
public abstract class AbstractDockerTest {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractDockerTest.class);
  private static final int MYSQL_PORT = 3306;
  private static final int LOCALSTACK_PORT = 4566;
  private static final int REDIS_PORT = 6379;

  public static GenericContainer redis = new GenericContainer("redis:alpine").withExposedPorts(REDIS_PORT);

  private static final MySQLContainer<?> MYSQL = new MySQLContainer<>(DockerImageName.parse("mysql"))
      .withReuse(true)
      .withDatabaseName("test")
      .withUrlParam("connectionTimeZone", "UTC")
      .withUrlParam("zeroDateTimeBehavior", "convertToNull")
      .withExposedPorts(MYSQL_PORT)
      .withCreateContainerCmdModifier(cmd -> cmd
          .withEntrypoint("/bin/bash")
          .getHostConfig()
          .withSecurityOpts(Collections.singletonList("seccomp=unconfined")))
      .withCommand("-c", "chown -R 999:999 /etc/mysql/conf.d/ && ./entrypoint.sh mysqld")
      .withInitScript("init.sql");

  public static GenericContainer localstack =
      new GenericContainer("379124286668.dkr.ecr.us-west-2.amazonaws.com/xact-localstack:1.0.0")
          .withExposedPorts(LOCALSTACK_PORT)
          .waitingFor(Wait.forHttp("/health").forPort(8080))
          .waitingFor(Wait.forLogMessage(".*Exactuals Localstack Init Completed.*", 1))
          .withEnv("SERVICES", "s3,transfer")
          .withEnv("DEFAULT_REGION", "us-west-2")
          .withEnv("USE_SSL", "false")
          .withEnv("AWS_ACCESS_KEY_ID", "foobar")
          .withEnv("AWS_SECRET_ACCESS_KEY", "foobar")
          .withEnv("DEBUG", "1")
          .withEnv("CREATE_BUCKETS", "test-bucket")
          .withEnv("SFTP_SERVER", "s-fe39c2d6353042dbb")
          .withEnv("SFTP_INBOUND_ROLE", "test");

  {
    redis.start();
    MYSQL.start();
    localstack.start();
  }

  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final String awsEndpointTemplate = "http://%s:%d";

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      startContainers();
      TestPropertyValues values = TestPropertyValues
          .of("USER_REDIS_HOST=" + redis.getHost(), "USER_REDIS_PORT=" + redis.getMappedPort(REDIS_PORT),
              "DEXCHANGE_DB_USER=" + MYSQL.getUsername(), "DEXCHANGE_DB_PWD=" + MYSQL.getPassword(),
              "DEXCHANGE_DB_SCHEMA=" + MYSQL.getDatabaseName(), "xact.domain.ops.datasource.url=" + MYSQL.getJdbcUrl(),
              "DEXCHANGE_DB_HOST=" + MYSQL.getHost(), "DEXCHANGE_DB_PORT=" + MYSQL.getMappedPort(MYSQL_PORT),
              "AWS_ENDPOINT=" + String
                  .format(awsEndpointTemplate, localstack.getHost(), localstack.getMappedPort(LOCALSTACK_PORT)));

      values.applyTo(configurableApplicationContext);
    }

    private void startContainers() {
      Startables.deepStart(Stream.of(MYSQL, localstack)).join();
    }
  }
}
