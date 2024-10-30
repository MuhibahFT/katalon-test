import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.testobject.TestObject

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
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

KeywordLogger log = new KeywordLogger()

// Login
WebUI.openBrowser("https://www.saucedemo.com/")
WebUI.setText(findTestObject('Object Repository/Login - Sauce Demo V1/input_username'), 'standard_user')
WebUI.setEncryptedText(findTestObject('Object Repository/Login - Sauce Demo V1/input_password'), 'qcu24s4901FyWDTwXGr6XA==')
WebUI.click(findTestObject('Object Repository/Login - Sauce Demo V1/button_submit_login'))
WebUI.verifyTextPresent('Products', false)

WebUI.delay(3)

for (int i = 1; i <= 6; i++) {
    TestObject price = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS,
        "(//div[@class='inventory_item_price'])[" + i + "]")

    // Mendapatkan teks harga produk
    String priceText = WebUI.getText(price)
    
    // Mengkonversi harga dari teks menjadi Double
    Double priceItems = Double.parseDouble(priceText.replace('$', ''))
    // Log harga item
    log.logInfo("Price product-${i}: \$${priceItems}")

    // Check if price <= 10, add to cart
	WebUI.delay(1)
    if (priceItems <= 10) {	
		log.logInfo(""+priceItems)
        TestObject addToCart = new TestObject().addProperty('xpath',
            com.kms.katalon.core.testobject.ConditionType.EQUALS,
            "(//button[contains(text(), 'Add to cart')])[" + i + "]")
        WebUI.click(addToCart)
        log.logInfo("Menambahkan produk ke-${i} dengan harga di bawah \$10 ke keranjang")
    }
}

WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/click_cart'))
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_checkout'))
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_first_name'), 'Muhibah Fata')
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_last_name'), 'Tika')
WebUI.setText(findTestObject('Object Repository/Checkout - Sauce Demo V1/input_zip_code'), '12440')
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_continue_checkout'))
WebUI.click(findTestObject('Object Repository/Checkout - Sauce Demo V1/btn_finish'))
WebUI.verifyTextPresent('Thank you for your order!', false)



WebUI.closeBrowser()

