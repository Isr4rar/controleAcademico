package br.com.stratus.cx.core;

import static br.com.stratus.cx.commons.InvokedMethodListener.reportLog;
import static br.com.stratus.cx.core.TLDriverFactory.getDriver;
import static com.aventstack.extentreports.Status.INFO;
import static java.lang.System.getProperty;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

/**
 * Domain Specific Language.
 * 
 * Herdada pelos testes é parte da 
 * estrutura do padrão PageObject.
 */
public class DSL {

	//	Methodos
	public void clearCampo(WebElement element) {
		element.clear();
	}
	public void fillFieldPressKey(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}
	public void fillField(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void clickButtonWeb(WebElement element) {
		element.click();
	}
	//Methods com tratamento de erros
	public void preencherCampo(WebElement element, String value) {
		try {
			fillField(element, value);
		} catch (ElementNotVisibleException  e) {
			waitElementDSL(3000);
			fillField(element, value);
		}
	}
	//Methods com tratamento de erros
	public void preencherCampoChat(WebElement element, String value) {
		try {
			fillField(element, value);
		} catch (ElementNotVisibleException  e) {
			reportLogs("Campo de observação não está visível.", INFO);
		}
	}
	public void preencherCampoEnter(WebElement element, String value) {
		try {			
			fillFieldPressKey(element, value);
		}  catch (Exception e) {
			waitElementDSL(3000);
			fillFieldPressKey(element, value);
		}
	}
	public void clickButton(WebElement element) {
		try {
			clickButtonWeb(element);
		} catch (Exception e) {
			waitElementDSL(3000);
			clickButtonWeb(element);
		}
	}
	public void clickButtonChat(WebElement element) {
		try {
			clickButtonWeb(element);	
		} catch (Exception e) {
			reportLogs("Botão não está visível.", INFO);
		}
	}
	public void clickButton(WebElement element, Integer time) {
		try {
			clickButtonWeb(element);	
		} catch (Exception e) {
			waitElementDSL(time);
			clickButtonWeb(element);
		}
	}
	public void reportLogs(WebElement messageElement, Status type) {
		reportLog(messageElement.getAttribute("value"), type);
	}
	public void reportLogs(String message, Status type) {
		reportLog(message, type);
	}
	public void validarMensagem(String value, WebElement element) {
		 Assert.assertEquals(value, element.getText());
	}
	public void validarTabela(List<WebElement> element, String value) {
		waitElementDSL(500);
		boolean cond = false;
		explicityWaitVisibleList(element);
		for (WebElement webElement : element) {
			if (webElement.getText() != null && webElement.getText().equals(value)) {
				cond = true;
			}
		}
		Assert.assertTrue(cond);
	}
	public String returnMensagem(WebElement element) {
		return element.getText();
	}
	public void validarMensagem(String value, String  element) {
		Assert.assertEquals(value, element);
	}
	public void assertTrue(String value, String element) {
		Assert.assertTrue(value.contains(element), value);
	}
	public void selecionarComboComValue(WebElement element, String value) {
		Select combo = new Select(element);
		combo.selectByValue(value);
	}
	public void selecionarCombo(WebElement element, String value) {
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}
	public void deselecionarCombo(WebElement element, String value) {
		Select combo = new Select(element);
		combo.deselectByVisibleText(value);
	}
	public void pressKey(WebElement element) {
		element.sendKeys(Keys.RETURN);
	}
	public void explicityWaitClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void explicityWaitVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicityWaitVisibleList(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public void explicityWaitClickable(WebElement element, Long time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void explicityWaitVisible(WebElement element, Long time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitElementDSL(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickJavaScript(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", element);
	}
	public void scrollDSL(String value) {
		JavascriptExecutor Scroll = (JavascriptExecutor) getDriver();
		Scroll.executeScript("window.scrollBy(0," + value + ")", "");
		waitElementDSL(1000);
	}
	public void sendFile(WebElement element, String directory) {
		element.sendKeys((getProperty("user.dir")) + directory);
	}
	public void dragAndDrop(WebElement from, WebElement to) {
		Actions builder = new Actions(getDriver());
		Action dragAndDrop = builder.clickAndHold(from)
				.moveToElement(to)
					.release(to)
						.build();
		
		dragAndDrop.perform();
	}
	public  void newTab(int i) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(i));
	}
}
