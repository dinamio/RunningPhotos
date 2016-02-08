package com.runningphotos.bom;


public enum Role {
    PHOTOGRAPHER(1),RUNNER(2),OPERATOR(3),ADMIN(4);

    private final int id;

    Role(int id) {this.id=id;}
    public int getId(){return id;}

}
