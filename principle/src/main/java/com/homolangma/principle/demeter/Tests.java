package com.homolangma.principle.demeter;

public class Tests {


    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);


    }
}
