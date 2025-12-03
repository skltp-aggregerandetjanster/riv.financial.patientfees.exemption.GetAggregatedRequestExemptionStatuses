package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import java.text.SimpleDateFormat;
import java.util.*;

import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;
import se.skltp.aggregatingservices.riv.itintegration.engagementindex.findcontentresponder.v1.FindContentResponseType;
import se.skltp.aggregatingservices.riv.itintegration.engagementindex.findcontentresponder.v1.FindContentType;
import se.skltp.aggregatingservices.riv.itintegration.engagementindex.v1.EngagementType;

import static se.skltp.aggregatingservices.utility.RequestListUtil.createRequest;

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

  @Override
  public List<MessageContentsList> createRequestList(
          MessageContentsList messageContentsList, FindContentResponseType eiResp) {
       int initialCapacity = eiResp.getEngagement().size();
      log.info("Got {} hits in the engagement index", initialCapacity);
      Set<String> addresses = new HashSet<>(initialCapacity);
      for (EngagementType e : eiResp.getEngagement()) {
          String la = e.getLogicalAddress();
          if (la != null) {
              addresses.add(la);
          }
      }
      List<MessageContentsList> reqList = new ArrayList<>(addresses.size());
      for (String la : addresses) {
          log.info("Calling source system using logical address {}", la);
          reqList.add(createRequest(la, messageContentsList));
      }
      log.info("Calling {} source systems", reqList.size());
      return reqList;
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

