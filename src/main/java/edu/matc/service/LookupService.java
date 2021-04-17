package edu.matc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * This class receives an API URL to hit, the object type expected to be created
 * from the returned JSON, and returns the value received from the API.
 *
 * @author tzschernitz
 */
public class LookupService<T> {

    private Class<T> type;

    public LookupService(Class<T> type) {
        this.type = type;
    }

    /**
     * This method receives an API url to send a request to and in turn returns
     * the result to the caller.
     *
     * @param apiUrl the API URL to make request to.
     * @param <T> The designated object type expected to be returned.
     * @return entity is the object populated with the response results from the API.
     */
    public <T> T lookupDetails(String apiUrl) {

        T entity = null;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(apiUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        try {
            entity = (T) mapper.readValue(response, this.type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return entity;
    }

}