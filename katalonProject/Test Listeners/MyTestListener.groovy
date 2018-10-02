import com.kazurayam.KatalonProperties
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class MyTestListener {

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		KatalonProperties props = new KatalonProperties()
		// get appropriate value for GlobalVariable.hostname loaded from katalon.properties files
		WebUI.comment(">>> GlobalVariable.WIKIPEDIA_URL: \'${GlobalVariable.WIKIPEDIA_URL}\'");
		String username = props.getProperty('WIKIPEDIA_USERNAME')
		if (username != null) {
			GlobalVariable.WIKIPEDIA_USERNAME = username
		}
		WebUI.comment(">>> GlobalVariable.WIKIPEDIA_USERNAME: \'${GlobalVariable.WIKIPEDIA_USERNAME}\'")
		String password = props.getProperty('WIKIPEDIA_PASSWORD')
		if (password != null) {
			GlobalVariable.WIKIPEDIA_PASSWORD = password
		}
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
	}

	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		
	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
	}
}