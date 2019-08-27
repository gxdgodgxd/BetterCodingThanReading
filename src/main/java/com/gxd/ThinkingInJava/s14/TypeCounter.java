package com.gxd.ThinkingInJava.s14;

import com.gxd.ThinkingInJava.s14.domain.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gxdgodgxd on 18/3/13.
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    public Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> objClass = object.getClass();
        if (baseType.isAssignableFrom(objClass)) {
            return;
        } else {
            throw new RuntimeException("obj class should be subclass of " + baseType.getName());
        }
    }

    public void countClass(Class<?> objClass) {
        Integer i = get(objClass);
        put(objClass, i == null ? 1 : i + 1);
        Class<?> superClass = objClass.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    public void print(){
        for (Map.Entry<Class<?>, Integer> entry : entrySet()) {
            System.out.println(entry.getKey().getName() + "=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PetCreator creator = new LiteralPetCreator();
        ArrayList<Pet> list = creator.createList(100);
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : list) {
            counter.count(pet);
        }
        counter.print();
    }

}
