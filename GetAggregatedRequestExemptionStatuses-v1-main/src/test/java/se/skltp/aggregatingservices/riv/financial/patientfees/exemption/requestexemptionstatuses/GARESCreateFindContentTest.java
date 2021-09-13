package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import org.junit.jupiter.api.BeforeAll;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;
import se.skltp.aggregatingservices.data.TestDataGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GARESCreateFindContentTest extends CreateFindContentTest {

  private static GARESAgpServiceConfiguration configuration = new GARESAgpServiceConfiguration();
  private static AgpServiceFactory<RequestExemptionStatusesResponseType> agpServiceFactory = new GARESAgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GARESCreateFindContentTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @BeforeAll
  public static void before() {
    configuration = new GARESAgpServiceConfiguration();
    agpServiceFactory = new GARESAgpServiceFactoryImpl();
    agpServiceFactory.setAgpServiceConfiguration(configuration);
  }


}
