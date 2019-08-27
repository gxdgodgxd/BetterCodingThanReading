package com.gxd.ThinkingInJava.s14;

import com.gxd.ThinkingInJava.s14.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 18/3/13.
 */
public class ForNamePetCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.gxd.ThinkingInJava.s14.domain.Pet",
            "com.gxd.ThinkingInJava.s14.domain.Cat",
            "com.gxd.ThinkingInJava.s14.domain.Dog"
    };

    public static void loader() {
        for (int i = 0; i < typeNames.length; i++) {
            try {
                types.add((Class<? extends Pet>) Class.forName(typeNames[i]));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> numTypes() {
        return types;
    }

}
