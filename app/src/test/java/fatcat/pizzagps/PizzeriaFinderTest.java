package fatcat.pizzagps;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Elias on 2018-01-09.
 */

public class PizzeriaFinderTest {
    private PizzeriaFinder pFinder;
    private FakeGoogleAPI fakeAPI;
    private List<Pizzeria> result;
    private List<Pizzeria> expected;

    @Before
    public void setup(){
        fakeAPI = new FakeGoogleAPI();
        pFinder = new PizzeriaFinder(fakeAPI);
        result = pFinder.getNearByPizzerias(new Position(1,1));
        expected = FakeGoogleAPI.pizzeriasFromResponse1();
    }


    @Test
    public void calledAPI(){
        assertTrue(fakeAPI.called);
    }

    @Test
    public void nrOfPizzeriasFound(){
        assertEquals(expected.size(),result.size());
    }

    @Test
    public void parsedPizzerias(){
        int l = expected.size();
        for(int i = 0;i<l;i++){
            Pizzeria res = result.get(i);
            Pizzeria exp = expected.get(i);
            assertEquals(exp,res);
        }
    }

}
