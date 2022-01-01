package me.models.mapper;

import me.models.PersonDTO;
import me.workloads.person.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Mappings {
    Mappings INSTANCE = Mappers.getMapper( Mappings.class );

    @Mapping(source = "password", target = "password", qualifiedByName = "HashToStringToNull")
    PersonDTO personToPersonDTO(Person p);

    @Named("HashToStringToNull")
    public static String HashToString (byte[] value){
        return null;
    }
}
