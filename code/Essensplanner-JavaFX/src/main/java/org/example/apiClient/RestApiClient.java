package org.example.apiClient;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.example.apiClient.dto.GerichtDTO;
import org.example.apiClient.dto.PersonDTO;
import org.example.apiClient.dto.TagesplanDTO;
import org.example.apiClient.dto.TagesplanResult;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;


public class RestApiClient {

    final ClientConfig clientConfig = new DefaultClientConfig();
    Client client;
    WebResource webResource;

    public RestApiClient() {
        ignoreSelfSigendCertificate();
        clientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(clientConfig);
        webResource = client.resource(UriBuilder.fromUri("https://localhost:8443").build());
    }

    public void ignoreSelfSigendCertificate() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public java.security.cert.X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }

        return;
    }

    public PersonDTO personSignIn(PersonDTO p) {
        PersonDTO personDTOResponse =  webResource.path("person").path("signin").
                type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(PersonDTO.class,p);
        System.out.println(personDTOResponse.toString());
        Arrays.stream(personDTOResponse.getUniqueSessionCode()).forEach(s -> {
            System.out.println(s);
        });
        return personDTOResponse;
    }

    public PersonDTO personLogIn(PersonDTO p) {
        PersonDTO personDTO = webResource.path("person").path("login")
                .type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(PersonDTO.class, p);
        return personDTO;
    }

    public List<GerichtDTO> gerichteSearch(String eingabe) {
        return webResource
                .path("gericht")
                .path("search")
                .path(eingabe)
                .accept(MediaType.APPLICATION_JSON)
                 .get(new GenericType<List<GerichtDTO>>() {});
    }

    public boolean gerichteIsFavorite(PersonDTO personDTO, Long id) {
        return webResource
                .path("gericht")
                .path("isFavorite")
                .path(""+id)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Boolean.class, personDTO);
    }

    public void gerichteSetFavorite(PersonDTO personDTO, Long id, Boolean b) {
        webResource
                .path("gericht")
                .path("setFavorite")
                .path(""+id)
                .path(""+b)
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .put(personDTO);
    }

    public void rezeptGetById(long uniqueGerichteId) {
    }

    public void addPlannedWeek(List<TagesplanDTO> tagesplanDTOS) {
        webResource
                .path("tagesplan")
                .path("week")
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .post(tagesplanDTOS);
    }

    public void deletePlannedWeek(String localDateToString, PersonDTO personDTO) {
        webResource
                .path("tagesplan")
                .path("week")
                .path(localDateToString)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(personDTO);
    }

    public List<TagesplanResult> getPlannedWeek(String localDateToString, PersonDTO personDTO) {
        return webResource
                .path("tagesplan")
                .path("week")
                .path(localDateToString)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(new GenericType<List<TagesplanResult>>() {}, personDTO);
    }

    public List<GerichtDTO> getGerichtelistByIds(List<Long> gerichteIdList) {
        return webResource
                .path("gericht")
                .path("ids")
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(new GenericType<List<GerichtDTO>>() {
                }, gerichteIdList);
    }
}