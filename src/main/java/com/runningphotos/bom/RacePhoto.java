package com.runningphotos.bom;

import java.util.List;


public class RacePhoto extends Entity {

    private String path;

    private Race race;

    private User user;

    private boolean mark;

    private List<Integer> runnersMarked;


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
                ", mark=" + mark +
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


    public boolean isMark() { return mark; }


    public void setMark(boolean mark) { this.mark = mark; }


    public List<Integer> getRunnersMarked() {
      return runnersMarked;
    }


    public void setRunnersMarked(List<Integer> runnersMarked) {
      this.runnersMarked = runnersMarked;
    }

}
