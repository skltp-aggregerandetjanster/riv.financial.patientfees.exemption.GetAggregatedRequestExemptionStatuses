package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses;

import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Service;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesResponseType;
import riv.financial.patientfees.exemption.requestexemptionstatusesresponder.v1.RequestExemptionStatusesType;
import riv.financial.patientfees.exemption.v1.IIType;
import se.skltp.aggregatingservices.data.TestDataGenerator;

@Log4j2
@Service
public class ServiceTestDataGenerator extends TestDataGenerator {

	@Override
	public String getPatientId(MessageContentsList messageContentsList) {
		RequestExemptionStatusesType request = (RequestExemptionStatusesType) messageContentsList.get(1);
		String patientId = request.getPatientId().getExtension();
		return patientId;
	}

	@Override
	public Object createResponse(Object... responseItems) {
		log.info("Not aggregating reesponse for this contract. Response items length = {} items", responseItems.length);
		RequestExemptionStatusesResponseType response = new RequestExemptionStatusesResponseType();
		//for (int i = 0; i < responseItems.length; i++) {
			/*nada*/
		//}

		log.info("response.toString:" + response.toString());
		return response;
	}

	@Override
	public Object createResponseItem(String logicalAddress, String registeredResidentId, String businessObjectId, String time) {
		log.debug("Created ResponseItem for logical-address {}, registeredResidentId {} and businessObjectId {}",
				new Object[]{logicalAddress, registeredResidentId, businessObjectId});
		RequestExemptionStatusesResponseType response = new RequestExemptionStatusesResponseType();
		return response;
	}

	public Object createRequest(String patientId, String sourceSystemHSAId){
		RequestExemptionStatusesType request = new RequestExemptionStatusesType();
		IIType patient = new IIType();
		patient.setExtension(patientId);
		request.setPatientId(patient);
		return request;
	}
}
