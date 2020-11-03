package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;
import se.skltp.aggregatingservices.riv.itintegration.engagementindex.findcontentresponder.v1.FindContentType;

@Log4j2
public class GARESAgpServiceFactoryImpl extends
    AgServiceFactoryBase<RequestExemptionStatusesType, RequestExemptionStatusesResponseType>{

  @Override
  public String getPatientId(RequestExemptionStatusesType queryObject){
    return queryObject.getPatientId().getExtension();
  }

  @Override
  public FindContentType createFindContent(MessageContentsList messageContentsList) {
    FindContentType findContentType = super.createFindContent(messageContentsList);
    findContentType.setMostRecentContent(getDateStringOneYearBack());
    return findContentType;
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

  private String getDateStringOneYearBack() {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    Date now = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    c.add(Calendar.YEAR, -1);
    Date then = c.getTime();
    String ret = format.format(then);
    return ret;
  }
}

