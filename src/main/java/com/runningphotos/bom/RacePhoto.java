package com.runningphotos.bom;

import java.util.List;


public class RacePhoto extends Entity {

    private String path;

    private Race race;

    private User user;

    private List<Runner> runnersMarked;


    public String getPath() {
      return path;
    }
// TODO: Delete
    @Override
    public String toString() {
        return "RacePhoto{" +
                "path='" + path + '\'' +
                ", race=" + race +
                ", user=" + user +
                ", runnersMarked=" + runnersMarked +
                '}';
    }

    public void setPath(String path) {
      this.path = path;
    }



    public Race getRace() {
      return race;
    }


    public void setRace(Race race) {
      this.race = race;
    }


    public User getUser() {
      return user;
    }


    public void setUser(User user) {
      this.user = user;
    }


    public List<Runner> getRunnersMarked() {
      return runnersMarked;
    }


    public void setRunnersMarked(List<Runner> runnersMarked) {
      this.runnersMarked = runnersMarked;
    }

}
