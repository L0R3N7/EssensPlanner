package me.models.mapper;

import me.models.GerichtDTO;
import me.models.PersonDTO;
import me.models.TagesplanDTOo;
import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;
import me.workloads.person.Tagesplan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.charset.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Mapper
public interface Mappings {
    Mappings INSTANCE = Mappers.getMapper( Mappings.class );

    @Mapping(source = "password", target = "password", qualifiedByName = "HashToNull")
    @Mapping(source = "uniqueSessionCode", target = "uniqueSessionCode", qualifiedByName = "HashToString")
    PersonDTO personToPersonDTO(Person p);

    GerichtDTO gerichtToGerichtDTO(Gericht g);

    @Mapping(source = "id.localDate", target = "idLocalDate", qualifiedByName = "LocalDateToString")
    List<TagesplanDTOo> tagesplanToTageslplanDtoo(List<Tagesplan> tagesplan);

    @Named("HashToNull")
    public static String HashToNull (byte[] value){
        return null;
    }

    @Named("HashToString")
    public static String[] HashToString (byte[] value) {
        //return new String(value, charset);
        String[] temp = new String[value.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = String.valueOf(value[i]);
        }
        return temp;
    }

    public static byte[] StringToHash (String[]  value) {
        byte[] temp = new byte[value.length];
        for (int i = 0; i < value.length; i++){
            temp[i] = Byte.valueOf(value[i]);
        }
        return temp;
    }

    @Named("StringToLocalDate")
    public static LocalDate StringToLocalDate(String dataString){
        return LocalDate.parse(dataString,DateTimeFormatter.ISO_DATE);
    }

    @Named("LocalDateToString")
    public static String LocalDateToString(LocalDate localDate){
        return DateTimeFormatter.ISO_DATE.format(localDate);
    }
}
