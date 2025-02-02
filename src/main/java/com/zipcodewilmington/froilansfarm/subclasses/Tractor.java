package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.collections.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Harvest;

import com.zipcodewilmington.froilansfarm.superclasses.Crop;

import com.zipcodewilmington.froilansfarm.superclasses.Edible;
import com.zipcodewilmington.froilansfarm.superclasses.Person;

import com.zipcodewilmington.froilansfarm.superclasses.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Tractor extends Vehicle implements Harvest {

    private Boolean mounted = false;
    List<Crop> tractorTrailer = new ArrayList<>();
    List<Edible> trunk = new ArrayList<>();

    public Tractor(){

    }

    public Tractor(String name) {
        super(name);
    }

    public void harvestCrop(CropRow<Crop> cropRow){

        for(int i = 0; i<cropRow.size(); i++){
            tractorTrailer.add(cropRow.get(i));
        }

        cropRow.harvestCropRow();
    }

    public void harvestEdible(){

        for (int i = 0; i<tractorTrailer.size(); i++){
            trunk.add(tractorTrailer.get(i).yield());
        }
    }

    @Override
    public String makeNoise() {
        return "Tractor go Beep Beep";
    }

    @Override
    public void ride(Person person) {
        ridersList().add(person);
        mounted = true;
    }

    @Override
    public void unride(Person person) {
        ridersList().remove(person);
        if(ridersList().isEmpty()){
            mounted = false;
        }
    }

    @Override
    public Boolean getMountStatus() {
        return mounted;
    }


    @Override
    public <T extends Crop> T harvestCrop(List<T> crops) {
        return null;
    }
}

