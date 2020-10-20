package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;

@Log4j2
public class GARESAgpServiceFactoryImpl extends
    AgServiceFactoryBase<RequestExemptionStatusesType, RequestExemptionStatusesResponseType>{

  @Override
  public String getPatientId(RequestExemptionStatusesType queryObject){
    return queryObject.getPatientId().getExtension();
  }

  @Override
  public String getSourceSystemHsaId(RequestExemptionStatusesType queryObject){
    return null;
  }

  @Override
  public RequestExemptionStatusesResponseType aggregateResponse(List<RequestExemptionStatusesResponseType> aggregatedResponseList ){

    RequestExemptionStatusesResponseType aggregatedResponse=new RequestExemptionStatusesResponseType();
    return aggregatedResponse;
  }
}

