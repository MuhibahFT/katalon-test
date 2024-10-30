import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Login
WebUI.openBrowser("https://www.saucedemo.com/")
WebUI.setText(findTestObject('Object Repository/Login - Sauce Demo V1/input_username'), 'standard_user')
WebUI.setEncryptedText(findTestObject('Object Repository/Login - Sauce Demo V1/input_password'), 'qcu24s4901FyWDTwXGr6XA==')
WebUI.click(findTestObject('Object Repository/Login - Sauce Demo V1/button_submit_login'))
WebUI.verifyTextPresent('Products', false)

//Choose Product
WebUI.click(findTestObject('Object Repository/Choose Product - Sauce Demo V1/btn_choose_product_1'))
WebUI.click(findTestObject('Object Repository/Choose Product - Sauce Demo V1/btn_choose_product_2'))

//Process Checkout
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/click_cart'))
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_checkout'))
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_first_name'), 'Muhibah Fata')
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_last_name'), 'Tika')
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_zip_code'), '12440')
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_continue_checkout'))
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_finish'))
WebUI.verifyTextPresent('Thank you for your order!', false)

WebUI.closeBrowser()
