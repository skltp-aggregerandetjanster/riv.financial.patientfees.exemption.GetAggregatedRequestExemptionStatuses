package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;
import se.skltp.aggregatingservices.data.TestDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
public class GARESCreateRequestListTest extends CreateFindContentTest {

  private static GARESAgpServiceConfiguration configuration = new GARESAgpServiceConfiguration();
  private static AgpServiceFactory<RequestExemptionStatusesResponseType> agpServiceFactory = new GARESAgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();


  public GARESCreateRequestListTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @BeforeClass
  public static void before() {
    configuration = new GARESAgpServiceConfiguration();
    agpServiceFactory = new GARESAgpServiceFactoryImpl();
    agpServiceFactory.setAgpServiceConfiguration(configuration);
  }
}