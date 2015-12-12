package com.runningphotos.bom;


public class Role extends EntityWithName{

    @Override
    public String toString() {
        return "[" + getId() + ","+getName()+"]";
    }
}
