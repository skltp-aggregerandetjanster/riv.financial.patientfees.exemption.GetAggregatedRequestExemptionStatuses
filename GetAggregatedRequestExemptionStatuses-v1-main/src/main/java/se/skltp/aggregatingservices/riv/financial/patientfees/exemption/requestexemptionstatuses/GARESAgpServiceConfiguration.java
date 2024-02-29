package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.financial.patientfees.exemption.requestexemptionstatuses.v1.rivtabp21.RequestExemptionStatusesResponderInterface;
import riv.financial.patientfees.exemption.requestexemptionstatuses.v1.rivtabp21.RequestExemptionStatusesResponderService;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedrequestexemptionstatuses.v1")
public class GARESAgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

  public static final String SCHEMA_PATH = "/schemas/Domain_1.0/interactions/RequestExemptionStatusesInteraction/RequestExemptionStatusesInteraction_1.0_RIVTABP21.wsdl";

  public GARESAgpServiceConfiguration() {

    setServiceName("GetAggregatedRequestExemptionStatuses-v1");
    setTargetNamespace("urn:riv:financial:patientfees:exemption:RequestExemptionStatuses:1:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://localhost:8081/GetAggregatedRequestExemptionStatuses/service/v1");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(RequestExemptionStatusesResponderInterface.class.getName());
    setInboundPortName(RequestExemptionStatusesResponderService.RequestExemptionStatusesResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(RequestExemptionStatusesResponderInterface.class.getName());
    setOutboundPortName(RequestExemptionStatusesResponderService.RequestExemptionStatusesResponderPort.toString());

    // FindContent
    setEiServiceDomain("riv:financial:patientfees:exemption");
    setEiCategorization("fpe-es");

    // TAK
    setTakContract("urn:riv:financial:patientfees:exemption:RequestExemptionStatusesResponder:1");

    // Set service factory
    setServiceFactoryClass(GARESAgpServiceFactoryImpl.class.getName());
  }


}
