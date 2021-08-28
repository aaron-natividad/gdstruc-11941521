package com.aaronnatividad;

import java.util.Objects;
import java.util.Random;

public class Player {
    private int userId;
    private String userName;
    private int level;

    public Player(){
        Random random = new Random();
        this.userId = random.nextInt(100000);
        this.userName = "Guest_%05d".formatted(userId);
        this.level = random.nextInt(100) + 1;
    }

    public Player(int userId, String userName, int level) {
        this.userId = userId;
        this.userName = userName;
        this.level = level;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return userId == player.userId && level == player.level && Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, level);
    }
}
