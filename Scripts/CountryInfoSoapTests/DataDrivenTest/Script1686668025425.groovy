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

println("... The value of country code is: " + countryCode)
println("... The value of currency is: " + currency)
println("... The value of capital is: " + capital)
currencyResponse = WS.sendRequest(findTestObject('CountryInfoSoapService/GetCurrency', [('countryISOCode') : countryCode]))
WS.verifyElementText(currencyResponse, 'CountryCurrencyResponse.CountryCurrencyResult.sName', currency)

capitalResponse = WS.sendRequest(findTestObject('CountryInfoSoapService/GetCapital', [('countryISOCode') : countryCode]))
WS.verifyElementText(capitalResponse, 'CapitalCityResponse.CapitalCityResult', capital)

