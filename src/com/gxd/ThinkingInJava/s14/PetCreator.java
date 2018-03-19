package com.gxd.ThinkingInJava.s14;

import com.gxd.ThinkingInJava.s14.domain.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by gxdgodgxd on 18/3/13.
 */
public abstract class PetCreator {

    private Random random = new Random(23);

    public abstract List<Class<? extends Pet>> numTypes();

    public Pet randomPet() {
        int n = random.nextInt(numTypes().size());
        try {
            //class的newInstance默认会调用无参构造函数,因此需要保证class有public的无参构造函数
            return numTypes().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int num) {
        Pet[] res = new Pet[num];
        for (int i = 0; i < num; i++) {
            res[i] = randomPet();
        }
        return res;
    }

    public ArrayList<Pet> createList(int num) {
        ArrayList<Pet> list = new ArrayList<>();
        list.addAll(Arrays.asList(createArray(num)));
        return list;
    }
}
