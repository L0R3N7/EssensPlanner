package me.models.mapper;

import me.models.GerichtDTO;
import me.models.PersonDTO;
import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.charset.*;

@Mapper
public interface Mappings {
    Charset charset = StandardCharsets.UTF_8;
    Mappings INSTANCE = Mappers.getMapper( Mappings.class );

    @Mapping(source = "password", target = "password", qualifiedByName = "HashToNull")
    @Mapping(source = "uniqueSessionCode", target = "uniqueSessionCode", qualifiedByName = "HashToString")
    PersonDTO personToPersonDTO(Person p);

    GerichtDTO gerichtToGerichtDTO(Gericht g);

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


        /*CharsetEncoder encoder = charset.newEncoder()
                .onMalformedInput(CodingErrorAction.IGNORE)
                .onUnmappableCharacter(CodingErrorAction.REPLACE)
                .replaceWith(new byte[] { 0 });
        try {
            return encoder.encode(CharBuffer.wrap(value)).array();
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        return null;*/
    }
}
