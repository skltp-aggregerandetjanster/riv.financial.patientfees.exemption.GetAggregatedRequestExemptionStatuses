package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.financial.patientfees.exemption.requestexemptionstatuses.v1.rivtabp21.RequestExemptionStatusesResponderInterface;
import riv.financial.patientfees.exemption.requestexemptionstatuses.v1.rivtabp21.RequestExemptionStatusesResponderService;
import se.skltp.aggregatingservices.config.TestProducerConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="getaggregatedrequestexemptionstatuses.v1.teststub")
public class ServiceConfiguration extends TestProducerConfiguration {

  public static final String SCHEMA_PATH = "/schemas/DOMAIN_1.0/interactions/RequestExemptionStatusesInteraction/RequestExemptionStatusesInteraction_1.0_RIVTABP21.wsdl";

  public ServiceConfiguration() {
    setProducerAddress("http://localhost:8083/vp");
    setServiceClass(RequestExemptionStatusesResponderInterface.class.getName());
    setServiceNamespace("urn:riv:financial:patientfees:exemption:RequestExemptionStatusesResponder:1");
    setPortName(RequestExemptionStatusesResponderService.RequestExemptionStatusesResponderPort.toString());
    setWsdlPath(SCHEMA_PATH);
    setTestDataGeneratorClass(ServiceTestDataGenerator.class.getName());
  }

}
