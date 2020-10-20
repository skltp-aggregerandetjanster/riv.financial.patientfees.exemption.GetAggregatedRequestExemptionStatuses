package se.skltp.aggregatingservices.riv.financial.patientfees.exemption.requestexemptionstatuses

trait CommonParameters {
  val serviceName:String     = "ExemptionStatuses"
  val urn:String             = "urn:riv:financial:patientfees:exemption:RequestExemptionStatusesResponder:1"
  val responseElement:String = "RequestExemptionStatusesResponse"
  val responseItem:String    = "exemptionStatuses"
  var baseUrl:String         = if (System.getProperty("baseUrl") != null && !System.getProperty("baseUrl").isEmpty()) {
                                   System.getProperty("baseUrl")
                               } else {
                                   "http://33.33.33.33:8081/RequestExemptionStatuses/service/v2"
                               }
}
