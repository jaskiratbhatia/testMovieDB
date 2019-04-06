package org.testmoviedb.apitesting;

import org.testmoviedb.apitesting.api.movie.MovieAPI;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Author @jaskiratbhatia
 * Date Apr/6/2019
 */
public class AppTest 
    
{

    /**
     * Test a valid movie response is 200
     */
	@Test
    public void testMovieCredit()
    {
		ServerResponse res = new MovieAPI().getCreditFor(String.valueOf(550));
		Assert.assertEquals(res.getStatusCode(), 200);
    }
	
	/**
	 * Test a Invalid String movie returns 404
	 */
	@Test
	public void testMovieCreditForInvalidId() {
		ServerResponse res = new MovieAPI().getCreditFor("5555555559999999");
		Assert.assertEquals(res.getStatusCode(), 404);
	}
	
	/**
	 * Test the call using invalid API KEY.
	 */
	@Test
	public void testMovieCreditUsingWrongApiKey() {
		ServerResponse res = new MovieAPI().getCreditFor("550", "ThisIsAnInvalidAPIKey");
		Assert.assertEquals(res.getStatusCode(), 401);
	}
	
	/**
	 * I assume this test should fail. But a valid response is returned.
	 * Need to check with the dev team to confirm the behavior here.
	 */
	@Test
	public void testMovieCreditUsingAlphaNumericId() {
		ServerResponse res = new MovieAPI().getCreditFor("550xxxx");
		Assert.assertEquals(res.getStatusCode(), 404);
	}
}
