package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Screenshot;

public class Hooks extends BaseClass
{
	//every test scenario execution before this method is executed

		//just like @beforeMethod
		@Before
		public void beforeScenario(Scenario scenario)
		{
			launchBrowser();
			log.info("Scenario Executing Start :-"+scenario.getName());
			
		}

		//just like @afterMethod
		@After
		public void afterScenario(Scenario scenario)
		{
			 //validate if scenario has failed
	        if(scenario.isFailed()) {
			scenario.attach(Screenshot.takeScreenShot(), "image/png", scenario.getName());
	        }
	        log.info("Scenario Executing Finish :-"+scenario.getName());
	        teardown();
		}
}
