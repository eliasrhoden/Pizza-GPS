package fatcat.pizzagps.GPS;

import org.junit.Test;

import fatcat.pizzagps.Position;

import static org.junit.Assert.*;

/**
 * Created on 2018-02-04.
 *
 * Don't work because the Location class is npt mocked....
 * Donät know how to solve, so gonna manually test this later
 *
 *
 */
public class PizzaGPSTest {


    private void assertWithinRange(int expexted, int actual, int error){
        if(actual > expexted + error) {
            fail("Actual value: " + actual + " is above range " + (expexted + error));
        }
        if(actual < expexted - error) {
            fail("Actual value: " + actual + " is below range " + (expexted - error));
        }
    }

    @Test
    public void angleTest_1(){
        Position campino = new Position(57.83991, 12.29771);
        Position toTheLeftShort = new Position(57.83986, 12.29402);
        PizzaGPS pg = new PizzaGPS(campino);
        pg.setMyPosition(toTheLeftShort,0);
        int actual = pg.getBearingToPizzeria();
        assertWithinRange(270,actual,4);
    }

    @Test
    public void angleTest_2(){
        Position campino = new Position(57.83991, 12.29771);
        Position toTheLeftLong = new Position(57.83983, 12.28833);
        PizzaGPS pg = new PizzaGPS(campino);
        pg.setMyPosition(toTheLeftLong,0);
        int actual = pg.getBearingToPizzeria();
        assertWithinRange(270,actual,4);
    }

    @Test
    public void angleTest_3(){
        Position campino = new Position(57.83991, 12.29771);
        Position down = new Position(57.83827, 12.29779);
        PizzaGPS pg = new PizzaGPS(campino);
        pg.setMyPosition(down,0);
        int actual = pg.getBearingToPizzeria();
        assertWithinRange(0,actual,4);
    }

    @Test
    public void angleTest_4(){
        Position campino = new Position(57.83991, 12.29771);
        Position down = new Position(57.84014, 12.30546);
        PizzaGPS pg = new PizzaGPS(campino);
        pg.setMyPosition(down,0);
        int actual = pg.getBearingToPizzeria();
        assertWithinRange(90,actual,4);
    }

}