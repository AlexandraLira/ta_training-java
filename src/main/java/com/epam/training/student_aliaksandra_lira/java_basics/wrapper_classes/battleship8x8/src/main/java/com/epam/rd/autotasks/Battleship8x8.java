package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        StringBuilder registerShot = new StringBuilder(Long.toBinaryString(shots));
        StringBuilder ship = new StringBuilder(Long.toBinaryString(ships));
        int symbolIndex = 0;
        while (registerShot.length() < 64) {
            registerShot.insert(0, 0);
        }
        while (ship.length() < 64) {
            ship.insert(0, 0);
        }
        char firstSymbol = shot.charAt(0);
        char secondSymbol = shot.charAt(1);
        int count = 0;
        for (char i = 'A'; i <= 'H'; i++) {
            if (i == firstSymbol) {
                symbolIndex = count + (Integer.parseInt(String.valueOf(secondSymbol)) - 1) * 8;
                break;
            }
            count++;
        }
        if (registerShot.charAt(symbolIndex) == '0') {
            registerShot.setCharAt(symbolIndex, '1');
            shots = new BigInteger(registerShot.toString(), 2).longValue();
        }
        return ship.charAt(symbolIndex) == '1';
    }

    public String state() {
        StringBuilder shots = new StringBuilder(Long.toBinaryString(this.shots));
        StringBuilder ships = new StringBuilder(Long.toBinaryString(this.ships));
        StringBuilder state = new StringBuilder();
        while (shots.length() < 64) {
            shots.insert(0, 0);
        }
        while (ships.length() < 64) {
            ships.insert(0, 0);
        }
        for (int i = 0, j = 1; i < 64; i++, j++) {
            if (shots.charAt(i) == '0' && ships.charAt(i) == '0') {
                state.append('.');
            } else if (ships.charAt(i) == '0' && shots.charAt(i) == '1') {
                state.append('×');
            } else if (shots.charAt(i) == '0' && ships.charAt(i) == '1') {
                state.append('☐');
            } else state.append('☒');
            if (j % 8 == 0 && j != 0) {
                state.append('\n');
            }
        }
        return state.toString();
    }
}
