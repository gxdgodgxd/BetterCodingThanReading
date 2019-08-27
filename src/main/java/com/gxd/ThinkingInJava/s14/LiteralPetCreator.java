package com.gxd.ThinkingInJava.s14;

import com.gxd.ThinkingInJava.s14.domain.Cat;
import com.gxd.ThinkingInJava.s14.domain.Dog;
import com.gxd.ThinkingInJava.s14.domain.Pet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gxdgodgxd on 18/3/13.
 */
public class LiteralPetCreator extends PetCreator {

    public static List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class, Cat.class, Dog.class));
    public static List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Cat.class),allTypes.size());

    @Override
    public List<Class<? extends Pet>> numTypes() {
        return types;
    }
}
