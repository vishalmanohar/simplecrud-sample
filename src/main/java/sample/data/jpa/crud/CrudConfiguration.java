package sample.data.jpa.crud;

import org.simplecrud.crud.builder.CrudModelBuilder;
import org.simplecrud.crud.service.CrudEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.data.jpa.domain.City;
import sample.data.jpa.service.CityRepository;

import static org.simplecrud.crud.builder.CrudEntityBuilder.newCrudEntity;

@Configuration
public class CrudConfiguration {

    @Bean(name = "cityCrudEntity")
    public CrudEntity cityCrudEntity(CityRepository cityRepository){
        return newCrudEntity(City.class)
                .jpaCrudRepository(cityRepository, Long.class)
                .model(CrudModelBuilder.jpaCrudModel()
                        .idFieldName("id")
                        .displayFields("name", "state", "country")
                        .filterFields("name", "state", "country")).build();
    }
}
