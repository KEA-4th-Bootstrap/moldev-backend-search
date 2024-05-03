package org.bootstrap.search.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ElasticsearchConfig {
    @Value("${spring.elasticsearch.uri}")
    private String hostname;

    @Value("${spring.elasticsearch.apikey}")
    private String apiKey;

    @Bean
    public ElasticsearchClient elasticRestClient() throws IOException {

        RestClient restClient = RestClient
                .builder(new HttpHost(hostname, 443, "https"))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

        // The transport layer of the Elasticsearch client requires a json object mapper to
        // define how to serialize/deserialize java objects. The mapper can be customized by adding
        // modules, for example since the Article and Comment object both have Instant fields, the
        // JavaTimeModule is added to provide support for java 8 Time classes, which the mapper itself does
        // not support.
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper(mapper));

        // And create the API client
        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        return esClient;
    }

}
