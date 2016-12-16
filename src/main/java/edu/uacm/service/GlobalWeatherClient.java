package edu.uacm.service;


import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import freemarker.template.Configuration;
import freemarker.template.Template;
public class GlobalWeatherClient {
public static void main(String[] args) {
HttpClient httpClient = null;
try {
// Configuración Freemarker
Configuration cfg = new Configuration();
// Cargar plantilla
Template template =
cfg.getTemplate("src/main/resources/templates/template.ftl");
// Modelo de datos
Map<String, Object> data = new HashMap<String, Object>();
//data.put("ciudad", "Madrid");
data.put("pais", "Mexico");
// Crear mensaje SOAP HTTP
StringWriter out = new StringWriter();
template.process(data, out);
String strRequest = out.getBuffer().toString();
// Crear la llamada al servidor
httpClient = new DefaultHttpClient();
HttpPost postRequest = new
HttpPost("http://www.webservicex.net/globalweather.asmx");
StringEntity input = new StringEntity(strRequest);
input.setContentType("application/soap+xml");
postRequest.setEntity(input);
// Tratar respuesta del servidor
HttpResponse response = httpClient.execute(postRequest);
if (response.getStatusLine().getStatusCode() != 200) {
throw new RuntimeException("Error : Codigo de error HTTP : " +
response.getStatusLine().getStatusCode());
}
//Obtener información de la respuesta
DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
Document XMLDoc =factory.newDocumentBuilder().parse(response.getEntity().getContent());
XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xpath.compile("//GetCitiesByCountryResult");

//Aqui se guarda el docuiemto xml
String result = String.class.cast(expr.evaluate(XMLDoc,XPathConstants.STRING));
Source source = new DOMSource(XMLDoc);
Result result2 = new StreamResult(new java.io.File("Servicio"+".xml")); 

Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.transform(source, result2);
System.out.println(result);
//result.
} catch (Exception e) {

e.printStackTrace();
} finally {
// Cierre de la conex
if (httpClient != null) httpClient.getConnectionManager().shutdown();
}
}
}