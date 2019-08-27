package com.gxd.ThinkingInJava.s14;

import com.gxd.ThinkingInJava.s14.domain.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gxdgodgxd on 18/3/13.
 */
public class PetCount {

    static class PetCounter extends HashMap<Class<? extends Pet>, Integer> {

        public PetCounter() {
            for (int i = 0; i < LiteralPetCreator.allTypes.size(); i++) {
                put(LiteralPetCreator.allTypes.get(i), 0);
            }
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        public void print(){
            for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                System.out.println(entry.getKey().getName() + "=" + entry.getValue());
            }
        }

    }

    public static void main(String[] args) {
        PetCreator creator = new LiteralPetCreator();
        ArrayList<Pet> list = creator.createList(100);
        PetCounter counter = new PetCounter();
        for (Pet pet : list) {
            counter.count(pet);
        }
        counter.print();
    }

}
