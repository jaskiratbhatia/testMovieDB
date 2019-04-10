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
		Integer movieId = 550;
		ServerResponse res = new MovieAPI().getCreditFor(movieId.toString());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertTrue(res.validateResponse(movieId));
    }
	
	/**
	 * Test a Invalid String movie returns 404
	 */
	@Test
	public void testMovieCreditForInvalidId() {
		ServerResponse res = new MovieAPI().getCreditFor("5555555559999999");
		Assert.assertEquals(res.getStatusCode(), 404);
		Assert.assertTrue(res.validateResponse(-1));
	}
	
	/**
	 * Test the call using invalid API KEY.
	 */
	@Test
	public void testMovieCreditUsingWrongApiKey() {
		ServerResponse res = new MovieAPI().getCreditFor("550", "ThisIsAnInvalidAPIKey");
		Assert.assertEquals(res.getStatusCode(), 401);
		Assert.assertTrue(res.validateResponse(-2));
	}
	
	/**
	 * I assume this test should fail. But a valid response is returned.
	 * Need to check with the dev team to confirm the behavior here.
	 */
	@Test(enabled=false)
	public void testMovieCreditUsingAlphaNumericId() {
		ServerResponse res = new MovieAPI().getCreditFor("550xxxx");
		Assert.assertEquals(res.getStatusCode(), 404);
	}
	
	@Test
	public void testMovieCreditWithNullId() {
		ServerResponse res = new MovieAPI().getCreditFor(null);
		Assert.assertEquals(res.getStatusCode(), 404);
		Assert.assertTrue(res.validateResponse(-1));
	}
	
	@Test
	public void testMovieAlternativeTile() {
		ServerResponse res = new MovieAPI().getAlternativeTitles("500", "KR");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("res comparred " + res.validateResponse(500));
		Assert.assertTrue(res.validateResponse(500),"Response does not match");
	}
	
	@Test(enabled=false)
	public void testMovieAltTitleInvalidCountryCode() {
		
	}
	
	@Test(enabled=false)
	public void testMovieAltTitleNullAsCountryCode() {
		
	}
	
	@Test(enabled=false)
	public void testMovieAltTitleInvalidMovieId() {
		
	}
	
	@Test(enabled=false)
	public void testMovieAltTitleInvalidAPIKey() {
		
	}
	
	@Test(enabled=false)
	public void testMovieAltTitleNoCountryParam() {
		
	}
	//And many more
}

